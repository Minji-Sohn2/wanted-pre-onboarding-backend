package com.example.wantedpreonboardingbackend.dto.post;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private Long companyId;
    private String position;
    private Long reward;
    private String details;
    private String skills;
}
