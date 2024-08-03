package com.clovischakrian.socialnetwork.application.functionalities.users.commands.create;

import com.clovischakrian.socialnetwork.libs.mediatr.IRequestHandler;
import org.springframework.stereotype.Service;

@Service
public class CreateUserCommandHandler implements IRequestHandler<CreateUserCommand, String> {
    public String nome;

    @Override
    public String handle(CreateUserCommand request) {
        // Operação muito complexa para criar um usuários
        Integer t = 2 * 3;
        return t.toString();
    }
}
