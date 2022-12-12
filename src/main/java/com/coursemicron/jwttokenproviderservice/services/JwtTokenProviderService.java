package com.coursemicron.jwttokenproviderservice.services;

import java.util.Map;

public interface JwtTokenProviderService {
    Map<String, String> generateToken(String userName);
}
