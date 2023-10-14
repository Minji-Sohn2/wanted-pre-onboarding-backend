package com.example.wantedpreonboardingbackend.repository;

import com.example.wantedpreonboardingbackend.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(
            value = "SELECT p FROM Post p " +
                    "WHERE p.company.companyName LIKE %:keyword% " +
                    "OR p.details LIKE %:keyword% " +
                    "OR p.skills LIKE %:keyword% " +
                    "OR p.position LIKE %:keyword%"
    )
    List<Post> findAllByKeyword(@Param("keyword") String keyword);

}
