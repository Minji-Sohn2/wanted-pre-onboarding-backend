package com.example.wantedpreonboardingbackend.dto.apply;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApplyRequestDto {
    @NotNull
    public Long postId;

    @NotNull
    public Long userId;
}
