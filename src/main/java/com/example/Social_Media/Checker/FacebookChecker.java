package com.example.Social_Media.Checker;

import com.example.Social_Media.Services.FacebookApiImp;
import com.example.Social_Media.Services.TwitterApiImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class FacebookChecker {
    @Autowired
    FacebookApiImp facebookApiImp;

        public boolean checkFacebookActivity(String domain) throws InterruptedException, JsonProcessingException, JsonProcessingException {

        ResponseEntity<String> response = facebookApiImp.SocailMediaApigetbydomainname(domain);

        // Parse JSON response
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(response.getBody());
        JsonNode postsNode = rootNode.path("results");

        LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
        if(postsNode.size()==0)
        {
            return false;
        }
        long createdAtTimestamp = postsNode.get(0).path("timestamp").asLong();
        LocalDateTime postDate = LocalDateTime.ofInstant(Instant.ofEpochSecond(createdAtTimestamp), ZoneId.systemDefault());
        System.out.println("Created At: " + postDate);

        // Check if the post date is within the last six months
        if (postDate.toLocalDate().isAfter(sixMonthsAgo)) {
            return true;
        }
        return false;
    }
}
