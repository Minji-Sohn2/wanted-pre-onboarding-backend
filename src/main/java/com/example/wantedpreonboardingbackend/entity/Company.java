package com.example.wantedpreonboardingbackend.entity;

import com.example.wantedpreonboardingbackend.dto.company.CompanyRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String region;

    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
    private List<Post> posts;

    /* 생성자 */
    public Company(CompanyRequestDto companyRequestDto) {
        this.companyName = companyRequestDto.getCompanyName();
        this.country = companyRequestDto.getCountry();
        this.region = companyRequestDto.getRegion();
    }
}
