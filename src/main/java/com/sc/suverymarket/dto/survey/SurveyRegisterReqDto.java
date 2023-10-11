package com.sc.suverymarket.dto.survey;

import com.sc.suverymarket.dto.question.QuestionRegisterReqDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SurveyRegisterReqDto {

    @NotEmpty
    @Size(min = 5, max = 100)
    private String title;

    @NotEmpty
    private List<QuestionRegisterReqDto> questionRegisterReqDtoList;

}
