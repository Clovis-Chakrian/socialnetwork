package com.clovischakrian.socialnetwork.repositories.users;

import com.clovischakrian.socialnetwork.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, UUID> {
    UserDetails findByEmail(String email);
}
