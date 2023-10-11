package com.sc.suverymarket.dto.question;

import com.sc.suverymarket.entity.Question;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class QuestionRegisterReqDto {

    @Schema
    @NotEmpty
    @Size(min = 5, max = 100)
    private String header;

    @Schema
    @NotEmpty
    private List<String> body;

    @Schema
    @NotEmpty
    private Question.Type type;

}
