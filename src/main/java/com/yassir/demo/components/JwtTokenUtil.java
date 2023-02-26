package com.yassir.demo.components;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.yassir.demo.entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

@Component
public class JwtTokenUtil implements Serializable
{

    SecretKey secret = Keys.secretKeyFor(SignatureAlgorithm.HS256); //or HS384 or HS512



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

    public Date getExpirationDateFromToken(String token)
    {
        return getClaimsFromToken(token, Claims.class).getExpiration();
    }

    private Claims getAllClaimsFromToken(String token)
    {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token)
    {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(String email)
    {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, email);
    }

    public String doGenerateToken(Map<String, Object> claims, String subject)
    {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(secret,SignatureAlgorithm.HS256).compact();
    }

}










