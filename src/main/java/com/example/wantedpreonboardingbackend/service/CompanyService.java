package com.example.wantedpreonboardingbackend.service;

import com.example.wantedpreonboardingbackend.dto.CompanyResponseDto;
import com.example.wantedpreonboardingbackend.dto.company.CompanyRequestDto;
import com.example.wantedpreonboardingbackend.entity.Company;
import com.example.wantedpreonboardingbackend.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyResponseDto createCompany(CompanyRequestDto companyRequestDto) {
        Company company = new Company(companyRequestDto);

        companyRepository.save(company);

        return new CompanyResponseDto(company);
    }
}
