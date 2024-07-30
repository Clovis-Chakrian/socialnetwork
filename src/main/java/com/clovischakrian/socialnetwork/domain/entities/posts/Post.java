package com.clovischakrian.socialnetwork.domain.entities.posts;

import com.clovischakrian.socialnetwork.domain.entities.comments.Comment;
import com.clovischakrian.socialnetwork.domain.entities.users.User;
import com.clovischakrian.socialnetwork.libs.data.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity(name = "posts")
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "postId", callSuper = true)
public class Post extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID postId;
    private String imageUrl;
    private String label;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Comment> comments;

    @ManyToMany
    private List<User> likes;
}
