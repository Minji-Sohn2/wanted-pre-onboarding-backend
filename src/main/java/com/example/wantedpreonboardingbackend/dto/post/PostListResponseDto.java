package com.example.wantedpreonboardingbackend.dto.post;

import lombok.Getter;

import java.util.List;

@Getter
public class PostListResponseDto {
    private List<PostCompanyDto> postList;

    public PostListResponseDto(List<PostCompanyDto> postList) {
        this.postList = postList;
    }
}
