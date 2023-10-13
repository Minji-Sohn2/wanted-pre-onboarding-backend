package com.example.wantedpreonboardingbackend.dto.post;

import com.example.wantedpreonboardingbackend.entity.Post;
import lombok.Getter;

/* 공고 전체 조회시에만 사용 */
@Getter
public class PostCompanyDto {
    private Long postId;

    private String companyName;
    private String country;
    private String region;

    private String position;
    private Long reward;
    private String skills;

    public PostCompanyDto(Post post) {
        this.postId = post.getId();
        this.companyName = post.getCompany().getCompanyName();
        this.country = post.getCompany().getCountry();
        this.region = post.getCompany().getRegion();
        this.position = post.getPosition();
        this.reward = post.getReward();
        this.skills = post.getSkills();
    }
}
