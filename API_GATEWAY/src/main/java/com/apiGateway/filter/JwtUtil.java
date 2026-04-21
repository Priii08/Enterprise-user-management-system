package com.apiGateway.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;


@Component
public class JwtUtil {
    private final String SECRET_KEY = "ASHHDFHSOIUEUBDIFBUIEWGFVSDVFIWWEE487536DGKFHGHDSGFHKSDGFUEFUEVCUKEUFUDVCVDHSVHSDVHF";

    private Key getkey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }
    public void validateToken(String token){
        Jwts.parserBuilder()
                .setSigningKey(getkey())
                .build()
                .parseClaimsJws(token);
    }

}
