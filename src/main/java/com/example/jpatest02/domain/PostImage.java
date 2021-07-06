package com.example.jpatest02.domain;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "post_images")
public class PostImage {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "origin_path", length = 100, nullable = false)
    private String originPath;

    @Builder
    public PostImage(Long id, Post post, String originPath) {
        this.id = id;
        this.post = post;
        this.originPath = originPath;
    }
}
