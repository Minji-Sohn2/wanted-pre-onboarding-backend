package com.example.wantedpreonboardingbackend.repository;

import com.example.wantedpreonboardingbackend.entity.Post;
import com.example.wantedpreonboardingbackend.entity.User;
import com.example.wantedpreonboardingbackend.entity.UserApply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserApplyRepository extends JpaRepository<UserApply, Long> {
    UserApply findByUserAndPost(User user, Post post);
}
