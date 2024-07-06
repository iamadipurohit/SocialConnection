package com.example.Social_Media.Checker;

import com.example.Social_Media.Services.InstagramApiImp;
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
public class InstaChecker {
    @Autowired
   InstagramApiImp instagramApiImp;
    public boolean checkInstagramActivity(String domain) throws InterruptedException, JsonProcessingException, JsonProcessingException {

		try {
			ResponseEntity<String> response = instagramApiImp.SocailMediaApigetbydomainname(domain);

			// Parse JSON response
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode rootNode = objectMapper.readTree(response.getBody());

			JsonNode postsNode = rootNode.path("data").path("items");

			LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
			if (postsNode.size() == 0) {
				System.out.println("No posts found.");
				return false;
			}
			long createdAtTimestamp = postsNode.get(0).path("caption").path("created_at").asLong();
			LocalDateTime postDate = LocalDateTime.ofInstant(Instant.ofEpochSecond(createdAtTimestamp), ZoneId.systemDefault());

			// Check if the post date is within the last six months
			if (postDate.toLocalDate().isAfter(sixMonthsAgo)) {
				return true;
			}
		} catch (Exception e) {
			System.err.println("An error occurred while checking Instagram activity: " + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
}
