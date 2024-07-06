package com.example.Social_Media;

import com.example.Social_Media.Services.InstagramApiImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SocialMediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaApplication.class, args);
		System.out.println("Hello World");
	}
//	@Bean
//	public CommandLineRunner commandLineRunner(InstagramApiImp instagramApiImp) {
//		return args -> {
//			System.out.println("Running logic after application startup");
//			// Add your initialization or execution logic here
//
//			// Example: Checking social media activity
//			String domain = "iamadipurohit";
//           boolean ans=checkInstagramActivity(domain,instagramApiImp);
//			System.out.println(ans);
//		};
//	}
//	private static boolean checkInstagramActivity(String domain, InstagramApiImp instagramApiImp) throws IOException, InterruptedException, JsonProcessingException {
//
//		ResponseEntity<String> response = instagramApiImp.InstagramApigetbydomainname(domain);
//
//		// Parse JSON response
//		ObjectMapper objectMapper = new ObjectMapper();
//		JsonNode rootNode = objectMapper.readTree(response.getBody());
//		JsonNode postsNode = rootNode.path("data").path("items");
//
//		LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
//
//		for (JsonNode post : postsNode) {
//			// Get the created_at Unix timestamp and convert it to LocalDateTime
//			long createdAtTimestamp = post.path("caption").path("created_at").asLong();
//			System.out.println(createdAtTimestamp);
//			long unixTimestamp = 1680716307L;
//
//			LocalDateTime postDate = LocalDateTime.ofInstant(Instant.ofEpochSecond(createdAtTimestamp), ZoneId.systemDefault());
//			System.out.println("Created At: " + postDate);
//
//			// Check if the post date is within the last six months
//			if (postDate.toLocalDate().isAfter(sixMonthsAgo)) {
//				return true;
//			}
//		}
//
//		return false;
//	}
}
