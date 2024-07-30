package com.clovischakrian.socialnetwork.application.services.posts;

import com.clovischakrian.socialnetwork.application.dtos.posts.NewPostDTO;
import com.clovischakrian.socialnetwork.domain.entities.posts.Post;
import com.clovischakrian.socialnetwork.infra.repositories.posts.PostRepository;
import com.clovischakrian.socialnetwork.libs.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService implements IPostService {
    private final PostRepository postRepository;
    private final Mapper mapper;

    @Autowired
    public PostService(PostRepository postRepository, Mapper mapper) {
        this.postRepository = postRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public UUID createPost(NewPostDTO newPostDTO) {
        Post post = mapper.map(newPostDTO, Post.class);


        return null;
    }
}
