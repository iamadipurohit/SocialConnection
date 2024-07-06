package com.example.Social_Media.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Component
public class AllMediasImp implements SocialMediaApi{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<String> SocailMediaApigetbydomainname(String name) {
        String baseurl = "https://website-contacts-scraper.p.rapidapi.com/scrape-contacts?query={name}&match_email_domain=false&external_matching=false";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Host", "website-contacts-scraper.p.rapidapi.com");
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
            return null; // or you can return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    }
}
