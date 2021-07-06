package com.example.jpatest02.dto;

import com.example.jpatest02.domain.Post;
import com.example.jpatest02.domain.PostImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PostCreateForm {
    private String title;
    private String content;
    private String writer;
    private MultipartFile[] images;

    public Post toPostEntity() {
        return Post.builder()
                .title(this.title)
                .content(this.content)
                .writer(this.writer)
                .build();
    }

    public List<PostImage> toPostImagesEntity(Post post) {

        List<PostImage> postImages = new ArrayList<>();
        for( MultipartFile image : this.images ) {
            PostImage postImage = PostImage.builder()
                    .originPath(image.getOriginalFilename())
                    .post(post)
                    .build();
            postImages.add(postImage);
        }

        return postImages;
    }
}
