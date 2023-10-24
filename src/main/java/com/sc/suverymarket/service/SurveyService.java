package com.sc.suverymarket.service;

import com.sc.suverymarket.dto.survey.SurveyRegisterReqDto;
import com.sc.suverymarket.dto.survey.SurveyResDto;
import com.sc.suverymarket.entity.Survey;
import com.sc.suverymarket.entity.User;
import com.sc.suverymarket.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SurveyService {

    private final SurveyRepository surveyRepository;

    @Transactional
    public SurveyResDto register(SurveyRegisterReqDto surveyRegisterReqDto) {
        Survey savedSurvey = surveyRepository.save(surveyRegisterReqDto.toEntity(new User()));
        return SurveyResDto.create(savedSurvey);
    }

}
