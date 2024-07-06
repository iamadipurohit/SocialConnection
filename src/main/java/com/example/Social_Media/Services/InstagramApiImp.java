package com.example.Social_Media.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class InstagramApiImp implements SocialMediaApi {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<String> SocailMediaApigetbydomainname(String name) {
        String baseurl = "https://instagram-scraper-api2.p.rapidapi.com/v1.2/posts?username_or_id_or_url={name}";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Host", "instagram-scraper-api2.p.rapidapi.com");
        headers.set("X-RapidAPI-Key", "d2ffcb2c1cmsha8601ed199c395ap1adb45jsne15212e2821b");

        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("name", name);
        HttpEntity<?> entity = new HttpEntity<>(headers);


        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseurl);

        System.out.println(builder.buildAndExpand(urlParams).toUri());


        return restTemplate.exchange(builder.buildAndExpand(urlParams).toUri(), HttpMethod.GET, entity, String.class);
    }

}
