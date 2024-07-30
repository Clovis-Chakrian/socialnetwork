package com.clovischakrian.socialnetwork.application.dtos.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewUserDTO {
    private String name;
    private String email;
    private String password;
}
