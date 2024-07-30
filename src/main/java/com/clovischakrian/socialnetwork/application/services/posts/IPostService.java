package com.clovischakrian.socialnetwork.application.services.posts;

import com.clovischakrian.socialnetwork.application.dtos.posts.NewPostDTO;
import com.clovischakrian.socialnetwork.domain.entities.posts.Post;

import java.util.List;
import java.util.UUID;

public interface IPostService {
    public List<Post> getPosts();
    public UUID createPost(NewPostDTO newPostDTO);
}
