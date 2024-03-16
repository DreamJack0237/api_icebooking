package com.example.icebooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.icebooking.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
