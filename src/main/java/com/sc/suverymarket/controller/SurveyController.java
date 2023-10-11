package com.sc.suverymarket.controller;

import com.sc.suverymarket.dto.survey.SurveyRegisterReqDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    @PostMapping
    public ResponseEntity register(@RequestBody @Valid SurveyRegisterReqDto surveyRegisterReqDto) {
        return ResponseEntity.ok(null);
    }

}
