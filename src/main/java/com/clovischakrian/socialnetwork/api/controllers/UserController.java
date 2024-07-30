package com.clovischakrian.socialnetwork.api.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Tag(name = "Users Controller", description = "Users Controller with their respective functionalities")
public class UserController {

}
