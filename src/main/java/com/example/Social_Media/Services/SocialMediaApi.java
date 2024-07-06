package com.example.Social_Media.Services;

import org.springframework.http.ResponseEntity;

public interface SocialMediaApi {
    public ResponseEntity<String> SocailMediaApigetbydomainname(String name);
}
