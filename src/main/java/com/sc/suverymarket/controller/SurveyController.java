package com.sc.suverymarket.controller;

import com.sc.suverymarket.dto.survey.SurveyReqDto;
import com.sc.suverymarket.dto.survey.SurveyReqDto.SurveyRegisterReqDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    @PostMapping
    public ResponseEntity register(@RequestBody @Valid SurveyRegisterReqDto surveyRegisterReqDto) {
        return new ResponseEntity<>(null, OK);
    }

}
