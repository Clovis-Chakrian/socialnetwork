package com.clovischakrian.socialnetwork.infra.repositories.posts;

import com.clovischakrian.socialnetwork.domain.entities.posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
}
