package com.example.Social_Media.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class TwitterApiImp implements SocialMediaApi{
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<String> SocailMediaApigetbydomainname(String name) {
        String baseurl = "\"https://twitter154.p.rapidapi.com/search/search/continuation?query={name}&section=top&min_retweets=20&limit=5&continuation_token=DAACCgACF_Sz76EAJxAKAAMX9LPvoP_Y8AgABAAAAAILAAUAAABQRW1QQzZ3QUFBZlEvZ0dKTjB2R3AvQUFBQUFVWDlJWmx4cHZBZkJmMG5RNUxHdUVQRi9TdTZPSGJzQ0VYOUp6Y3psdUJ3UmYwbFE3Q1dxQWsIAAYAAAAACAAHAAAAAAwACAoAARf0hmXGm8B8AAAA&min_likes=20&start_date=2022-01-01&language=en\"";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Host", "twitter154.p.rapidapi.com");
        headers.set("X-RapidAPI-Key", "d2ffcb2c1cmsha8601ed199c395ap1adb45jsne15212e2821b");

        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("name", name);
        HttpEntity<?> entity = new HttpEntity<>(headers);


        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseurl);

        System.out.println(builder.buildAndExpand(urlParams).toUri());


        return restTemplate.exchange(builder.buildAndExpand(urlParams).toUri(), HttpMethod.GET, entity, String.class);
    }
}
