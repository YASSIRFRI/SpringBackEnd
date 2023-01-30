package com.yassir.demo.components;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtTokenUtil implements Serializable
{

    @Value("${jwt.secret}")
    private String secret;


    @Value("${jwt.expiration}")
    private Long expiration;


    public String getUserNameFromUser(String token)
    {
        return null;
    }


    public <T> T getClaimsFromToken(String token, Class<T> clazz)
    {
        final Claims claims = getAllClaimsFromToken(token);
        return claims.get("user", clazz);
    }

    private Claims getAllClaimsFromToken(String token)
    {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    

}










