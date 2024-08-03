package com.clovischakrian.socialnetwork.api.controllers;

import com.clovischakrian.socialnetwork.application.dtos.users.LoginDTO;
import com.clovischakrian.socialnetwork.application.dtos.users.NewUserDTO;
import com.clovischakrian.socialnetwork.application.functionalities.users.commands.create.CreateUserCommand;
import com.clovischakrian.socialnetwork.libs.controller.ApiResponse;
import com.clovischakrian.socialnetwork.application.services.users.IUserService;
import com.clovischakrian.socialnetwork.libs.controller.BaseController;
import com.clovischakrian.socialnetwork.libs.mediatr.IMediatR;
import com.clovischakrian.socialnetwork.libs.exceptions.BadRequestException;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth Controller", description = "Authentication Controller")
@SuppressWarnings("rawtypes")
public class AuthController extends BaseController {
    @Autowired
    IUserService userService;

    @Autowired
    IMediatR mediator;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody NewUserDTO newUserDTO) throws Exception {

//        var response = userService.signup(newUserDTO);
        return ApiReturn(mediator.send(new CreateUserCommand()), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginDTO loginDTO) throws BadRequestException {
        var response = userService.login(loginDTO);
        return new ResponseEntity<>(new ApiResponse(true, response, new ArrayList<>()), HttpStatus.OK);
    }
}
