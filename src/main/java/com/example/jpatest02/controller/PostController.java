package com.example.jpatest02.controller;

import com.example.jpatest02.domain.Post;
import com.example.jpatest02.domain.PostImage;
import com.example.jpatest02.dto.PostCreateForm;
import com.example.jpatest02.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("post/create")
    public ResponseEntity create(PostCreateForm postCreateForm){



        Long savePostId = postService.post(postCreateForm);

        return ResponseEntity.ok().body(savePostId);
    }
}
