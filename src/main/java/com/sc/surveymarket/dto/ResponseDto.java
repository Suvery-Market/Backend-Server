package com.sc.surveymarket.dto;

import lombok.*;

@Getter
@Setter
public class ResponseDto<T> {

    private Integer code;
    private String message;
    private T data;

    @Builder
    public ResponseDto(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}