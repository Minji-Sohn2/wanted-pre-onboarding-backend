package com.example.wantedpreonboardingbackend.entity;

import com.example.wantedpreonboardingbackend.dto.PostRequestDto;
import com.example.wantedpreonboardingbackend.dto.PostUpdateDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String companyId;

    @Column(nullable = false)
    private String position;

    private Long reward;

    @Column(nullable = false)
    private String details;

    private String skills;

    /* 생성자 */
    public Post(PostRequestDto postRequestDto) {
        this.companyId = postRequestDto.getCompanyId();
        this.position = postRequestDto.getPosition();
        this.reward = postRequestDto.getReward();
        this.details = postRequestDto.getDetails();
        this.skills = postRequestDto.getSkills();
    }

    /* 서비스 메서드 */
    public void update(PostUpdateDto postUpdateDto) {
        this.position = postUpdateDto.getPosition();
        this.reward = postUpdateDto.getReward();
        this.details = postUpdateDto.getDetails();
        this.skills = postUpdateDto.getSkills();
    }
}
