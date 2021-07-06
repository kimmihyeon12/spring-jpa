package com.example.jpatest02.repository;

import com.example.jpatest02.domain.Post;
import com.example.jpatest02.domain.PostImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PostRepository {

    private final EntityManager em;

    public PostRepository(EntityManager em) {
        this.em = em;
    }

    public Long create(Post post){
        em.persist(post);
        return post.getId();
    }

    public void createPostImages(List<PostImage> postImages) {
        for( PostImage postImage : postImages ) {
            em.persist(postImage);
        }
    }
}
