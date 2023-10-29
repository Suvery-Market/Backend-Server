package com.sc.surveymarket.service;

import com.sc.surveymarket.document.Survey;
import com.sc.surveymarket.dto.survey.SurveyRegisterReqDto;
import com.sc.surveymarket.dto.survey.SurveyResDto;
import com.sc.surveymarket.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SurveyService {

    private final SurveyRepository surveyRepository;

    public SurveyResDto register(SurveyRegisterReqDto surveyRegisterReqDto) {

        Survey survey = Survey.builder()
                .title(surveyRegisterReqDto.getTitle())
                .questionList(surveyRegisterReqDto.getQuestionList())
                .build();

        Survey savedSurvey = surveyRepository.save(survey);

        return SurveyResDto.create(savedSurvey);
    }

}
