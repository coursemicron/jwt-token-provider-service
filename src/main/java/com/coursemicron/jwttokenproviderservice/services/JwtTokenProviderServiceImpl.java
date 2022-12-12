package com.coursemicron.jwttokenproviderservice.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenProviderServiceImpl implements JwtTokenProviderService{

    @Value("${jwt.secret}")
    private String secret;
    @Value("${app.jwttoken.message}")
    private String message;


    /**
     * @param userName
     * @return
     */
    @Override
    public Map<String, String> generateToken(String userName) {
        String jwtToken="";
        jwtToken = Jwts.builder().setSubject(userName).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, secret).compact();
        Map<String, String> jwtTokenGen = new HashMap<>();
        jwtTokenGen.put("token", jwtToken);
        jwtTokenGen.put("message", message);
        return jwtTokenGen;
    }
}
