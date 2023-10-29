package com.sc.suverymarket.document.question;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@NoArgsConstructor
public class Question {
    private String question;
    private QuestionType type;
    private List<String> selectionList = new ArrayList<>();

    @Builder
    public Question(String question, QuestionType type, List<String> selectionList) {
        this.question = question;
        this.type = type;
        this.selectionList = selectionList;
    }
}
