package com.example.wantedpreonboardingbackend.service;

import com.example.wantedpreonboardingbackend.dto.apply.ApplyRequestDto;
import com.example.wantedpreonboardingbackend.entity.Post;
import com.example.wantedpreonboardingbackend.entity.User;
import com.example.wantedpreonboardingbackend.entity.UserApply;
import com.example.wantedpreonboardingbackend.repository.PostRepository;
import com.example.wantedpreonboardingbackend.repository.UserApplyRepository;
import com.example.wantedpreonboardingbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.RejectedExecutionException;

@Service
@RequiredArgsConstructor
public class ApplyService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final UserApplyRepository userApplyRepository;

    public void applyPost(ApplyRequestDto applyRequestDto) {

        User user = findUserById(applyRequestDto.userId);
        Post post = findPostById(applyRequestDto.postId);

        // 이미 지원한 공고글일 경우
        if(findUserPost(user, post)) {
            throw new RejectedExecutionException("이미 지원했던 공고입니다.");
        }

        UserApply userApply = new UserApply(user, post);
        userApplyRepository.save(userApply);
    }

    private boolean findUserPost(User user, Post post) {
        return userApplyRepository.findByUserAndPost(user, post) != null;
    }

    private Post findPostById(Long postId) {
        return postRepository.findById(postId).orElseThrow(
                () -> new NullPointerException("존재하지 않는 공고글입니다.")
        );
    }

    private User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new NullPointerException("존재하지 않는 회원입니다.")
        );
    }
}
