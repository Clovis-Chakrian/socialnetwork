package com.clovischakrian.socialnetwork.domain.entities.comments;

import com.clovischakrian.socialnetwork.domain.entities.posts.Post;
import com.clovischakrian.socialnetwork.domain.entities.users.User;
import com.clovischakrian.socialnetwork.libs.data.BaseEntity;
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
public class Comment extends BaseEntity {
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
