package com.sc.suverymarket.controller;

import com.sc.suverymarket.dto.ResponseDto;
import com.sc.suverymarket.dto.survey.SurveyRegisterReqDto;
import com.sc.suverymarket.dto.survey.SurveyResDto;
import com.sc.suverymarket.service.SurveyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/surveys")
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyService surveyService;

    @PostMapping
    public ResponseEntity register(@RequestBody @Valid SurveyRegisterReqDto surveyRegisterReqDto) {

        SurveyResDto surveyResDto = surveyService.register(surveyRegisterReqDto);

        return ResponseEntity
                .ok(ResponseDto.builder()
                        .code(1)
                        .message("Success")
                        .data(surveyResDto));
    }

}
