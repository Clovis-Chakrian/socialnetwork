package com.clovischakrian.socialnetwork.models.users;

import com.clovischakrian.socialnetwork.dtos.users.NewUserDTO;
import com.clovischakrian.socialnetwork.models.comments.Comment;
import com.clovischakrian.socialnetwork.models.posts.Post;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Table(name = "users")
@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "userId")
public class User implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private UserRole userRole;
    private Date createdAt;
    private Date updatedAt;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Post> posts;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Comment> comments;

    public User(NewUserDTO newUserDTO) {
        this.name = newUserDTO.name();
        this.email = newUserDTO.email();
        this.password = newUserDTO.password();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (userRole == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("admin"), new SimpleGrantedAuthority("user"));
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
