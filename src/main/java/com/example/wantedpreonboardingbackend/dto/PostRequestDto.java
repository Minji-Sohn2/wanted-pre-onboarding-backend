package com.example.wantedpreonboardingbackend.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String companyId;
    private String position;
    private Long reward;
    private String details;
    private String skills;
}
