package com.example.wantedpreonboardingbackend.controller;

import com.example.wantedpreonboardingbackend.dto.CompanyResponseDto;
import com.example.wantedpreonboardingbackend.dto.company.CompanyRequestDto;
import com.example.wantedpreonboardingbackend.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<CompanyResponseDto> createCompany(@RequestBody CompanyRequestDto companyRequestDto) {
        CompanyResponseDto result = companyService.createCompany(companyRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(result);
    }
}
