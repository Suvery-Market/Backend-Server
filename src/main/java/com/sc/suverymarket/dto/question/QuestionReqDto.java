package com.sc.suverymarket.dto.question;

import com.sc.suverymarket.entity.Question.Type;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public class QuestionReqDto {

    public static class QuestionRegisterReqDto {

        @NotEmpty
        @Size(min = 5, max = 100)
        private String header;

        @NotEmpty
        private List<String> body;

        @NotEmpty
        private Type type;

    }
}
