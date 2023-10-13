package com.example.wantedpreonboardingbackend.service;

import com.example.wantedpreonboardingbackend.dto.post.*;
import com.example.wantedpreonboardingbackend.entity.Company;
import com.example.wantedpreonboardingbackend.entity.Post;
import com.example.wantedpreonboardingbackend.repository.CompanyRepository;
import com.example.wantedpreonboardingbackend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final CompanyRepository companyRepository;

    public PostListResponseDto getPosts() {
        List<PostCompanyDto> postList = postRepository.findAll().stream()
                .map(PostCompanyDto::new).toList();

        return new PostListResponseDto(postList);
    }

    public PostResponseDto createPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        Company company = findCompanyById(postRequestDto.getCompanyId());

        post.setCompany(company);

        postRepository.save(post);

        return new PostResponseDto(post);
    }

    public PostDetailResponseDto getOnePost(Long postId) {
        Post post = findPostById(postId);
        Company company = post.getCompany();

        return new PostDetailResponseDto(post, company);
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

    private Company findCompanyById(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow(
                () -> new NullPointerException("존재하지 않는 회사입니다.")
        );
    }
}
