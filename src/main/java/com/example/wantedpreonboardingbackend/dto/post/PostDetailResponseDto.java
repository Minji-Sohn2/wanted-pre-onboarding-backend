package com.example.wantedpreonboardingbackend.dto.post;

import com.example.wantedpreonboardingbackend.entity.Company;
import com.example.wantedpreonboardingbackend.entity.Post;
import lombok.Getter;

import java.util.List;

@Getter
public class PostDetailResponseDto {
    private Long postId;

    private String companyName;
    private String country;
    private String region;

    private String position;
    private Long reward;
    private String skills;
    private String details;

    private List<Long> postIdList;

    public PostDetailResponseDto(Post post, Company company, List<Long> postIdList) {
        this.postId = post.getId();
        this.companyName = post.getCompany().getCompanyName();
        this.country = post.getCompany().getCountry();
        this.region = post.getCompany().getRegion();
        this.position = post.getPosition();
        this.reward = post.getReward();
        this.skills = post.getSkills();
        this.details = post.getDetails();
        this.postIdList = postIdList;
    }
}
