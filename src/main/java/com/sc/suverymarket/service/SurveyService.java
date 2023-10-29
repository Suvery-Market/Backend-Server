package com.sc.suverymarket.service;

import com.sc.suverymarket.document.Survey;
import com.sc.suverymarket.dto.survey.SurveyRegisterReqDto;
import com.sc.suverymarket.dto.survey.SurveyResDto;
import com.sc.suverymarket.repository.SurveyRepository;
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
