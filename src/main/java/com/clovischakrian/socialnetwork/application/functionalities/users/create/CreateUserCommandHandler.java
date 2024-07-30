package com.clovischakrian.socialnetwork.application.functionalities.users.create;

import com.clovischakrian.socialnetwork.libs.mediatr.IRequestHandler;
import org.springframework.stereotype.Service;

@Service
public class CreateUserCommandHandler implements IRequestHandler<CreateUserCommand, String> {
    public String nome;

    @Override
    public String handle(CreateUserCommand request) {
        return "Olá";
    }
}
