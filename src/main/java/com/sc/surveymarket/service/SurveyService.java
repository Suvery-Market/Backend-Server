package com.sc.surveymarket.service;

import com.sc.surveymarket.document.Survey;
import com.sc.surveymarket.dto.survey.SurveyRegisterReqDto;
import com.sc.surveymarket.dto.survey.SurveyResDto;
import com.sc.surveymarket.exception.CustomAPIException;
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

    public SurveyResDto retrieve(String id) {
        Survey findSurvey = surveyRepository.findById(id)
                .orElseThrow(() -> new CustomAPIException("{}에 해당하는 Survey가 존재하지 않습니다."));
        return SurveyResDto.create(findSurvey);
    }

    public void delete(String id) {
        surveyRepository.deleteById(id);
    }
}
