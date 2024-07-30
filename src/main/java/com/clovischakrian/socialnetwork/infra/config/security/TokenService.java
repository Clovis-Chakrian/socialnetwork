package com.clovischakrian.socialnetwork.infra.config.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.clovischakrian.socialnetwork.domain.entities.users.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTCreationException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String tokenSecret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(tokenSecret);

            String token = JWT.create()
                    .withIssuer("socialnet")
                    .withSubject(user.getEmail())
                    .withExpiresAt(generateExpirationTime())
                    .withHeader(Map.of("typ", "at+JWT"))
                    .sign(algorithm);

            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while authenticating.");
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
            DecodedJWT decodedToken = JWT.require(algorithm)
                    .withIssuer("socialnet")
                    .build()
                    .verify(token);

            var typHeader = decodedToken.getHeaderClaim("typ");

            if (!typHeader.asString().equals("at+jwt")) return null;

            return JWT.require(algorithm)
                    .withIssuer("socialnet")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    public Instant generateExpirationTime() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }
}
