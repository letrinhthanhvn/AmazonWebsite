package com.amazonweb.service.impl;

import com.amazonweb.api.form.AuthForm;
import com.amazonweb.model.User;
import com.amazonweb.service.ITokenAuthenticationService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenAuthenticationService implements ITokenAuthenticationService {

    private String secret = "hello";

    @Autowired
    private UserService userService;

    @Override
    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    @Override
    public String createToken(User user)  {
        Date date = new Date();
        long t = date.getTime();
        Integer periodTime = 1000 * 86400;
        Date expirationTime = new Date(t + periodTime);
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(expirationTime)
                .signWith(SignatureAlgorithm.HS512, secret)
                .claim("data", user)
                .compact();
    }

    @Override
    public User getUserFromToken(String token) {
        final String username = getUsernameFromToken(token);
        return userService.findByUsername(username);
    }

    @Override
    public Integer getRoleFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token)
                .getBody();
        return claims.get("role", Integer.class);
    }
}
