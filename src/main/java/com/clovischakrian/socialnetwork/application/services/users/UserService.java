package com.clovischakrian.socialnetwork.application.services.users;

import com.clovischakrian.socialnetwork.application.dtos.users.LoginDTO;
import com.clovischakrian.socialnetwork.application.dtos.users.NewUserDTO;
import com.clovischakrian.socialnetwork.infra.config.security.TokenService;
import com.clovischakrian.socialnetwork.domain.entities.users.User;
import com.clovischakrian.socialnetwork.infra.repositories.users.IUserRepository;
//import com.clovischakrian.socialnetwork.libs.data.BaseRepository;
import com.clovischakrian.socialnetwork.libs.exceptions.BadRequestException;
import com.clovischakrian.socialnetwork.libs.mapper.Mapper;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final TokenService tokenService;
    private final Mapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(IUserRepository userRepository, TokenService tokenService, Mapper mapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public String signup(NewUserDTO newUserDTO) {
        User user = mapper.map(newUserDTO, User.class);
        user.setPassword(passwordEncoder.encode(newUserDTO.getPassword()));

        userRepository.save(user);

        return tokenService.generateToken(user);
    }

    @Override
    public String login(LoginDTO loginDTO) throws BadRequestException {
        User user = this.loadUserByUsername(loginDTO.email());

        if (!passwordEncoder.matches(loginDTO.password(), user.getPassword())) throw new BadRequestException("Incorrect email or password");

        return tokenService.generateToken(user);
    }

    @Override
    public boolean follow(UUID userId, User currentUserFromToken) throws BadRequestException {
        User userToFollow = userRepository.findById(userId).orElseThrow(() -> new BadRequestException("User to follow not found"));
        User currentUser = this.loadUserByUsername(currentUserFromToken.getEmail());
        return false;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found."));
    }
}
