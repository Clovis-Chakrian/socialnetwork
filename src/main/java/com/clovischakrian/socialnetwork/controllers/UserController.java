package com.clovischakrian.socialnetwork.controllers;

import com.clovischakrian.socialnetwork.dtos.users.NewUserDTO;
import com.clovischakrian.socialnetwork.services.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userService;

    @PostMapping()
    public UUID createUser(@RequestBody NewUserDTO newUserDTO) {
        return userService.createUser(newUserDTO);
    }
}
