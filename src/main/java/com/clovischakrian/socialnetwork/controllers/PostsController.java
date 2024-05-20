package com.clovischakrian.socialnetwork.controllers;

import com.clovischakrian.socialnetwork.dtos.users.NewUserDTO;
import com.clovischakrian.socialnetwork.models.posts.Post;
import com.clovischakrian.socialnetwork.services.posts.IPostService;
import com.clovischakrian.socialnetwork.services.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    IPostService postService;

    @GetMapping()
    public List<Post> getPosts() {
        return postService.getPosts();
    }
}
