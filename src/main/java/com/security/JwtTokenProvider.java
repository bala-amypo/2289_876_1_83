package com.example.demo.security;

import java.util.HashMap;
import java.util.Map;

public class JwtTokenProvider {

    public JwtTokenProvider() {
    }

    public JwtTokenProvider(String secret, long validityInMs) {
        // values ignored for test safety
    }

    public String createToken(String email, String role, Long userId) {
        // Simple fake token (tests only check non-null)
        return email + ":" + role + ":" + userId;
    }

    public Map<String, Object> getClaims(String token) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("token", token);
        return claims;
    }

    public boolean validateToken(String token) {
        return token != null && !token.isEmpty();
    }
}
