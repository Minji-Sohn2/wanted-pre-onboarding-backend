package com.example.wantedpreonboardingbackend.entity;

import com.example.wantedpreonboardingbackend.dto.post.PostRequestDto;
import com.example.wantedpreonboardingbackend.dto.post.PostUpdateDto;
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
    private String position;

    private Long reward;

    @Column(nullable = false)
    private String details;

    private String skills;

    /* 연관관계 */
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    /* 생성자 */
    public Post(PostRequestDto postRequestDto) {
        this.position = postRequestDto.getPosition();
        this.reward = postRequestDto.getReward();
        this.details = postRequestDto.getDetails();
        this.skills = postRequestDto.getSkills();
    }

    /* 연관관계 편의 메서드 */
    public void setCompany(Company company) {
        this.company = company;
        company.getPosts().add(this);
    }

    /* 서비스 메서드 */
    public void update(PostUpdateDto postUpdateDto) {
        this.position = postUpdateDto.getPosition();
        this.reward = postUpdateDto.getReward();
        this.details = postUpdateDto.getDetails();
        this.skills = postUpdateDto.getSkills();
    }
}
