package com.example.jpatest02.service;

import com.example.jpatest02.domain.Post;
import com.example.jpatest02.domain.PostImage;
import com.example.jpatest02.dto.PostCreateForm;
import com.example.jpatest02.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Long post(PostCreateForm postCreateForm){

        Post post = postCreateForm.toPostEntity();
        List<PostImage> postImages = postCreateForm.toPostImagesEntity(post);

        Long savePostId = postRepository.create(post);
        postRepository.createPostImages(postImages);

        return savePostId;
    }
}
