package com.sc.surveymarket.dto.survey;

import com.sc.surveymarket.document.question.Question;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class SurveyRegisterReqDto {

    @NotEmpty
    @Size(min = 1, max = 40)
    private String title;

    @NotEmpty
    private List<Question> questionList = new ArrayList<>();
}
