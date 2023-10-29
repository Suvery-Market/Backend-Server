package com.sc.surveymarket.dto.survey;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sc.surveymarket.document.Survey;
import com.sc.surveymarket.document.question.Question;
import com.sc.surveymarket.dto.user.UserResDto;
import lombok.*;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class SurveyResDto {
    private String id;
    private String title;
    private UserResDto userResDto;
    private List<Question> questionList;

    @Builder
    public SurveyResDto(String id, String title, UserResDto userResDto, List<Question> questionList) {
        this.id = id;
        this.title = title;
        this.userResDto = userResDto;
        this.questionList = questionList;
    }

    public static SurveyResDto create(Survey survey) {
        return SurveyResDto.builder()
                .id(survey.getId())
                .title(survey.getTitle())
                .questionList(survey.getQuestionList())
                .build();
    }
}
