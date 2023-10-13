package com.example.wantedpreonboardingbackend.dto;

import lombok.Getter;

@Getter
public class ApiResponseDto {

    private String message;
    private Integer statusCode;

    public ApiResponseDto(String message, Integer statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
