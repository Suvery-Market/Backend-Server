package com.sc.suverymarket.dto.survey;

import com.sc.suverymarket.dto.user.UserResDto;
import com.sc.suverymarket.entity.Survey;
import lombok.*;

@Getter
public class SurveyResDto {
    private Long id;
    private String title;
    private UserResDto userResDto;

    @Builder
    public SurveyResDto(Long id, String title, UserResDto userResDto) {
        this.id = id;
        this.title = title;
        this.userResDto = userResDto;
    }

    public static SurveyResDto create(Survey survey) {
        return SurveyResDto.builder()
                .id(survey.getId())
                .title(survey.getTitle())
                .userResDto(UserResDto.create(survey.getUser()))
                .build();
    }
}
