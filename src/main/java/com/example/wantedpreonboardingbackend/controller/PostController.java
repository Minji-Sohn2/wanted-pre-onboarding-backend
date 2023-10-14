package com.example.wantedpreonboardingbackend.controller;

import com.example.wantedpreonboardingbackend.dto.ApiResponseDto;
import com.example.wantedpreonboardingbackend.dto.post.*;
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

    @GetMapping
    public ResponseEntity<PostListResponseDto> getPosts() {
        PostListResponseDto result = postService.getPosts();

        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostRequestDto postRequestDto) {
        PostResponseDto result = postService.createPost(postRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(result);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDetailResponseDto> getOnePost(@PathVariable Long postId) {
        PostDetailResponseDto result = postService.getOnePost(postId);

        return ResponseEntity.ok().body(result);
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

    @GetMapping("/search")
    public ResponseEntity<PostListResponseDto> searchPostByKeyword(@RequestParam String search) {
        PostListResponseDto result = postService.searchPostByKeyword(search);

        return ResponseEntity.ok().body(result);
    }
}
