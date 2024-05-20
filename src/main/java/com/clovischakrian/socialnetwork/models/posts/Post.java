package com.clovischakrian.socialnetwork.models.posts;

import com.clovischakrian.socialnetwork.models.comments.Comment;
import com.clovischakrian.socialnetwork.models.users.User;
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
@EqualsAndHashCode(of = "postId")
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID postId;
    private String imageUrl;
    private String label;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Comment> comments;
}
