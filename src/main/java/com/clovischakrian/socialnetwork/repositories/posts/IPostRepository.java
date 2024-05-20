package com.clovischakrian.socialnetwork.repositories.posts;

import com.clovischakrian.socialnetwork.models.posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IPostRepository extends JpaRepository<Post, UUID> {
}
