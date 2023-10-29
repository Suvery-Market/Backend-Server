package com.sc.surveymarket.controller;

import com.sc.surveymarket.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health-check")
public class BasicController {

    @GetMapping
    public ResponseEntity healthCheck() {
        return ResponseEntity.ok(new ResponseDto(1, "Success", "Health Check"));
    }

}
