package com.example.wantedpreonboardingbackend.controller;

import com.example.wantedpreonboardingbackend.dto.ApiResponseDto;
import com.example.wantedpreonboardingbackend.dto.apply.ApplyRequestDto;
import com.example.wantedpreonboardingbackend.service.ApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apply")
@RequiredArgsConstructor
public class ApplyController {

    private final ApplyService applyService;

    @PostMapping
    public ResponseEntity<ApiResponseDto> applyPost(@RequestBody ApplyRequestDto applyRequestDto) {
        applyService.applyPost(applyRequestDto);

        return ResponseEntity.ok().body(new ApiResponseDto("지원 완료", HttpStatus.OK.value()));
    }
}
