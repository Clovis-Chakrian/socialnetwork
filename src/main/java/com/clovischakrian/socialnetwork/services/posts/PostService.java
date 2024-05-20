package com.clovischakrian.socialnetwork.services.posts;

import com.clovischakrian.socialnetwork.models.posts.Post;
import com.clovischakrian.socialnetwork.repositories.posts.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {
    @Autowired
    private IPostRepository postRepository;

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }
}
