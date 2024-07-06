package com.example.Social_Media.Controller;

import com.example.Social_Media.Checker.FacebookChecker;
import com.example.Social_Media.Checker.InstaChecker;
import com.example.Social_Media.Checker.TwitterChecker;
import com.example.Social_Media.Services.AllMediasImp;
import com.example.Social_Media.Services.FacebookApiImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class RequestHandler {
    @Autowired
    AllMediasImp allMediasImp;

    @Autowired
    InstaChecker instaChecker;
    @Autowired
    TwitterChecker twitterChecker;
    @Autowired
    FacebookChecker facebookChecker;
    @GetMapping("/checkActivity")
    public JsonNode getActivities(@RequestParam String domain) throws JsonProcessingException, InterruptedException {
        ResponseEntity<String> response = allMediasImp.SocailMediaApigetbydomainname(domain);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(response.getBody());
        JsonNode dataNode = rootNode.path("data").get(0);

        String[] socialMediaKeys = {"facebook", "instagram", "tiktok", "snapchat", "twitter", "linkedin", "github", "youtube", "pinterest"};

        ObjectNode resultNode = objectMapper.createObjectNode();

        for (String key : socialMediaKeys) {
            JsonNode socialMediaNode = dataNode.path(key);
            boolean isActive = false;
            if (!socialMediaNode.isNull()) {
                String url = socialMediaNode.asText();

                switch (key) {
                    case "instagram":
                        isActive = instaChecker.checkInstagramActivity(domain);
                        break;
                    case "twitter":
                        isActive = twitterChecker.checkTwitterActivity(domain);
                        break;
                    case "facebook":
                        isActive = facebookChecker.checkFacebookActivity(domain);
                        break;
                }

                ObjectNode socialMediaStatusNode = objectMapper.createObjectNode();
                socialMediaStatusNode.put("url", url);
                socialMediaStatusNode.put("active", isActive);

                resultNode.set(key, socialMediaStatusNode);

                System.out.println(key + ": " + url);
                System.out.println(key + " handle is " + (isActive ? "Active" : "Inactive from last 6 Months"));
            }
        }
        return resultNode;
    }

}
