package com.sc.surveymarket.exception;

import com.sc.surveymarket.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity exception(Exception e) {
        log.error(e.getMessage());
        return ResponseEntity
                .badRequest()
                .body(ResponseDto.builder()
                        .code(-1)
                        .message("서버에서 오류가 발생하였습니다.")
                        .build());
    }

    @ExceptionHandler(CustomAPIException.class)
    public ResponseEntity customAPIException(CustomAPIException e) {
        log.error(e.getMessage());
        return ResponseEntity
                .badRequest()
                .body(ResponseDto.builder()
                        .code(-1)
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage());

        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> errorMap = new HashMap<>();

        if (bindingResult.hasErrors()) {
            errorMap = bindingResult.getFieldErrors()
                    .stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        }

        return ResponseEntity
                .badRequest()
                .body(ResponseDto.builder()
                        .code(-1)
                        .message("데이터 유효성 검증에 실패하였습니다.")
                        .data(errorMap)
                        .build());
    }
}
