package com.clovischakrian.socialnetwork.models.comments;

import com.clovischakrian.socialnetwork.models.posts.Post;
import com.clovischakrian.socialnetwork.models.users.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "comments")
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "commentId")
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID commentId;
    private String comment;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "postId", referencedColumnName = "postId")
    private Post post;
}
