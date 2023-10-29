package com.sc.surveymarket.controller;

import com.sc.surveymarket.dto.ResponseDto;
import com.sc.surveymarket.dto.survey.SurveyRegisterReqDto;
import com.sc.surveymarket.dto.survey.SurveyResDto;
import com.sc.surveymarket.service.SurveyService;
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
    public ResponseEntity register(@Valid @RequestBody SurveyRegisterReqDto surveyRegisterReqDto) {

        SurveyResDto surveyResDto = surveyService.register(surveyRegisterReqDto);

        return ResponseEntity.ok(ResponseDto.builder()
                .code(1)
                .message("Success")
                .data(surveyResDto)
                .build());
    }

}
