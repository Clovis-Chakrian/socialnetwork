package com.clovischakrian.socialnetwork.services.users;

import com.clovischakrian.socialnetwork.dtos.users.NewUserDTO;
import com.clovischakrian.socialnetwork.models.users.User;
import com.clovischakrian.socialnetwork.repositories.users.IUserRepository;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UUID createUser(NewUserDTO newUserDTO) {
        User user = new User(newUserDTO);

        userRepository.save(user);

        return user.getUserId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username);
    }
}
