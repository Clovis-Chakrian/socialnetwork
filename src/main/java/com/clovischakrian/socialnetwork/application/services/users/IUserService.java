package com.clovischakrian.socialnetwork.application.services.users;

import com.clovischakrian.socialnetwork.application.dtos.users.LoginDTO;
import com.clovischakrian.socialnetwork.application.dtos.users.NewUserDTO;
import com.clovischakrian.socialnetwork.domain.entities.users.User;
import com.clovischakrian.socialnetwork.libs.exceptions.BadRequestException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;

public interface IUserService extends UserDetailsService {
    public String signup(NewUserDTO newUserDTO);
    public String login(LoginDTO loginDTO) throws BadRequestException;
    public boolean follow(UUID userId, User currentUser) throws BadRequestException;
}
