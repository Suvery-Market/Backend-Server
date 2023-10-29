package com.sc.suverymarket.document.question;

enum QuestionType {
    SHORT_ANSWER("단답형"),
    LONG_ANSWER("장문형"),
    MULTIPLE_CHOICE("객관식"),
    CHECK_BOX("체크박스"),
    DROP_DOWN("드롭다운"),
    LINEAR_SCALE("선형배열");

    private String value;

    QuestionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
