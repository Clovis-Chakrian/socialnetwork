package com.clovischakrian.socialnetwork.application.dtos.posts;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewPostDTO {
    @NotEmpty(message = "Não é possível fazer uma publicação nova sem imagem.")
    private String imageUrl;
    private String label;
}
