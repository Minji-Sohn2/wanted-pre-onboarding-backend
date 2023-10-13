package com.example.wantedpreonboardingbackend.dto;

import com.example.wantedpreonboardingbackend.entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private String companyId;
    private String position;
    private Long reward;
    private String details;
    private String skills;

    public PostResponseDto(Post post) {
        this.companyId = post.getCompanyId();
        this.position = post.getPosition();
        this.reward = post.getReward();
        this.details = post.getDetails();
        this.skills = post.getSkills();
    }
}
