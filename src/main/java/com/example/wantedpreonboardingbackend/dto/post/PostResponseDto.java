package com.example.wantedpreonboardingbackend.dto.post;

import com.example.wantedpreonboardingbackend.entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long postId;
    private Long companyId;
    private String position;
    private Long reward;
    private String details;
    private String skills;

    public PostResponseDto(Post post) {
        this.postId = post.getId();
        this.companyId = post.getCompany().getId();
        this.position = post.getPosition();
        this.reward = post.getReward();
        this.details = post.getDetails();
        this.skills = post.getSkills();
    }
}
