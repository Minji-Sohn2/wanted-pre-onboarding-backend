package com.example.wantedpreonboardingbackend.service;

import com.example.wantedpreonboardingbackend.dto.PostRequestDto;
import com.example.wantedpreonboardingbackend.dto.PostResponseDto;
import com.example.wantedpreonboardingbackend.entity.Post;
import com.example.wantedpreonboardingbackend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostResponseDto createPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        postRepository.save(post);

        return new PostResponseDto(post);
    }

}
