package com.sc.suverymarket.dto.survey;

import com.sc.suverymarket.dto.question.QuestionRegisterReqDto;
import com.sc.suverymarket.entity.Survey;
import com.sc.suverymarket.entity.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class SurveyRegisterReqDto {

    @NotEmpty
    @Size(min = 5, max = 100)
    private String title;

    @NotEmpty
    private List<QuestionRegisterReqDto> questionRegisterReqDtoList;

    public Survey toEntity(User user) {
        return Survey.builder()
                .user(user)
                .title(title)
                .questionList(questionRegisterReqDtoList.stream()
                        .map(QuestionRegisterReqDto::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }

}
