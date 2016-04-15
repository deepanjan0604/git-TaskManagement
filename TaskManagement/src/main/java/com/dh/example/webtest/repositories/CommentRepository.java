package com.dh.example.webtest.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dh.example.webtest.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}