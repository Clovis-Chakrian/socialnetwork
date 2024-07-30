package com.clovischakrian.socialnetwork.application.functionalities.users.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewUserDto {
    @NotEmpty(message = "The name is a required information.")
    private String name;

    @NotEmpty(message = "The email is a required information.")
    @Email(message = "The email must be valid")
    private String email;

    @NotEmpty(message = "The name is a required information.")
    @Size(min = 8, message = "The password must have at least 8 characters")
    private String password;
}
