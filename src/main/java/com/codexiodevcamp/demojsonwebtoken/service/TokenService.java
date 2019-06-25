package com.codexiodevcamp.demojsonwebtoken.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service
public class TokenService {

    private static final String TOKEN_SECRET = "s4T2zOIWHMM1sxq";

    String createToken(Long id) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            String token = JWT.create()
                    .withClaim("id", id)
                    .withClaim("createdAt", new Date())
                    .sign(algorithm);
            return token;
        } catch (UnsupportedEncodingException | JWTCreationException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public Long getUserIdFromToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim("id").asLong();
        } catch (UnsupportedEncodingException | JWTVerificationException exception) {
            exception.printStackTrace();
            return null;
        }

    }

    public boolean isTokenValid(String token) {
        Long userId = this.getUserIdFromToken(token);
        return userId != null;
    }
}
