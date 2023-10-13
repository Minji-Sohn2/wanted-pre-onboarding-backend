package com.example.wantedpreonboardingbackend.service;

import com.example.wantedpreonboardingbackend.dto.PostRequestDto;
import com.example.wantedpreonboardingbackend.dto.PostResponseDto;
import com.example.wantedpreonboardingbackend.dto.PostUpdateDto;
import com.example.wantedpreonboardingbackend.entity.Post;
import com.example.wantedpreonboardingbackend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostResponseDto createPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);

        postRepository.save(post);

        return new PostResponseDto(post);
    }

    @Transactional
    public PostResponseDto updatePost(Long postId, PostUpdateDto postUpdateDto) {
        Post post = findPostById(postId);

        post.update(postUpdateDto);

        return new PostResponseDto(post);
    }

    public void deletePost(Long postId) {
        Post post = findPostById(postId);

        postRepository.delete(post);
    }

    private Post findPostById(Long postId) {
        return postRepository.findById(postId).orElseThrow(
                () -> new NullPointerException("존재하지 않는 공고글입니다.")
        );
    }
}
