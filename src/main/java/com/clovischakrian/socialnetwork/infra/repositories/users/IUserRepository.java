package com.clovischakrian.socialnetwork.infra.repositories.users;

import com.clovischakrian.socialnetwork.domain.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
