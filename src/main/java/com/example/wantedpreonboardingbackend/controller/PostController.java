package com.example.wantedpreonboardingbackend.controller;

import com.example.wantedpreonboardingbackend.dto.ApiResponseDto;
import com.example.wantedpreonboardingbackend.dto.post.PostRequestDto;
import com.example.wantedpreonboardingbackend.dto.post.PostResponseDto;
import com.example.wantedpreonboardingbackend.dto.post.PostUpdateDto;
import com.example.wantedpreonboardingbackend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostRequestDto postRequestDto) {
        PostResponseDto result = postService.createPost(postRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(result);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostResponseDto> updatePost(@PathVariable Long postId,
                                                      @RequestBody PostUpdateDto postRequestDto) {
        PostResponseDto result = postService.updatePost(postId, postRequestDto);

        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<ApiResponseDto> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);

        return ResponseEntity.ok().body(new ApiResponseDto("공고 삭제 성공", HttpStatus.OK.value()));
    }
}
