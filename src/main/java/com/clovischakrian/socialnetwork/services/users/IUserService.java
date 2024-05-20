package com.clovischakrian.socialnetwork.services.users;

import com.clovischakrian.socialnetwork.dtos.users.NewUserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;

public interface IUserService extends UserDetailsService {
    public UUID createUser(NewUserDTO newUserDTO);
}
