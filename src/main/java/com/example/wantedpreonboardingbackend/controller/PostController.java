package com.example.wantedpreonboardingbackend.controller;

import com.example.wantedpreonboardingbackend.dto.PostRequestDto;
import com.example.wantedpreonboardingbackend.dto.PostResponseDto;
import com.example.wantedpreonboardingbackend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostResponseDto> createPost (@RequestBody PostRequestDto postRequestDto) {
        PostResponseDto result = postService.createPost(postRequestDto);

        return ResponseEntity.status(201).body(result);
    }
}
