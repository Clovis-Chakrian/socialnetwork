package com.clovischakrian.socialnetwork.infra.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @Info(
        contact = @Contact(name = "Social Network - Fun with SpringBoot"),
        title = "Social Network - Fun with SpringBoot",
        version = "1.0.0"),
        security = @SecurityRequirement(name = "JWT Token"))
@SecurityScheme(
        name = "JWT Token",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
@Configuration
public class SwaggerConfig {
}
