package com.auth.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "ASHHDFHSOIUEUBDIFBUIEWGFVSDVFIWWEE487536DGKFHGHDSGFHKSDGFUEFUEVCUKEUFUDVCVDHSVHSDVHF";

    private Key getKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generateToken(String username) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("email", "test@gmail.com");

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)   // ✅ use this
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 5))
                .signWith(getKey())
                .compact();
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())              // ✅ new syntax
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Date extractExpiration(String token) {
        return getClaims(token).getExpiration();
    }
}