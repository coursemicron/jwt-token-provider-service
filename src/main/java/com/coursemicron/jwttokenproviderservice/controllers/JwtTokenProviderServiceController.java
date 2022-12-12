package com.coursemicron.jwttokenproviderservice.controllers;

import com.coursemicron.jwttokenproviderservice.services.JwtTokenProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/jwt")
public class JwtTokenProviderServiceController {
    @Autowired
    JwtTokenProviderService jwtTokenProviderService;

    @PostMapping("/token")
    public ResponseEntity<?> authenticate(@RequestHeader("username") String userName, @RequestHeader("secret") String secret){
        if(userName.equals("admin") && secret.equals("Pwd@123")){
            return new ResponseEntity<>(jwtTokenProviderService.generateToken(userName), HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed authenticate user.", HttpStatus.CONFLICT);
    }
}
