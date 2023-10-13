package com.example.wantedpreonboardingbackend.dto;

import com.example.wantedpreonboardingbackend.entity.Company;
import lombok.Getter;

@Getter
public class CompanyResponseDto {
    private Long companyId;
    private String companyName;
    private String country;
    private String region;

    public CompanyResponseDto(Company company) {
        this.companyId = company.getId();
        this.companyName = company.getCompanyName();
        this.country = company.getCountry();
        this.region = company.getRegion();
    }
}
