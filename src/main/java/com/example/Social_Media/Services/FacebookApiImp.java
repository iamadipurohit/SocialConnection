package com.example.Social_Media.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Component
public class FacebookApiImp implements SocialMediaApi{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<String> SocailMediaApigetbydomainname(String name) {
        String baseurl = "https://axesso-facebook-data-service.p.rapidapi.com/fba/facebook-search-hashtag?hashtag={name}";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Host", "axesso-facebook-data-service.p.rapidapi.com");
        headers.set("X-RapidAPI-Key", "d2ffcb2c1cmsha8601ed199c395ap1adb45jsne15212e2821b");

        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("name", name);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseurl);

            return restTemplate.exchange(builder.buildAndExpand(urlParams).toUri(), HttpMethod.GET, entity, String.class);
        } catch (Exception e) {
            System.err.println("An error occurred while making the API request: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
