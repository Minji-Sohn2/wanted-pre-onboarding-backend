package com.example.wantedpreonboardingbackend.controller;

import com.example.wantedpreonboardingbackend.dto.PostRequestDto;
import com.example.wantedpreonboardingbackend.dto.PostResponseDto;
import com.example.wantedpreonboardingbackend.dto.PostUpdateDto;
import com.example.wantedpreonboardingbackend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostResponseDto> createPost (@RequestBody PostRequestDto postRequestDto) {
        PostResponseDto result = postService.createPost(postRequestDto);

        return ResponseEntity.status(201).body(result);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostResponseDto> updatePost(@PathVariable Long postId,
                                                      @RequestBody PostUpdateDto postRequestDto) {
        PostResponseDto result = postService.updatePost(postId, postRequestDto);

        return ResponseEntity.ok().body(result);
    }
}
