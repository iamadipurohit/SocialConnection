# Social Media Activity Checker

## Overview
The **Social Media Activity Checker** is a Spring Boot application that retrieves social media links associated with a given domain name and determines their activity status based on the timestamp of their last post.

## Features
- Retrieves social media links (e.g., **Facebook**, **Instagram**, **Twitter**) associated with a domain.
- Determines if each social media handle has been active within the last 6 months.
- Displays the status of each handle as either **active** or **inactive**.

## Technologies Used
- Java
- Spring Boot
- Maven
- Jackson JSON library

## Prerequisites
Before running the application, ensure you have the following installed:
- Java Development Kit (JDK) version 8 or higher
- Apache Maven

## Configuration
1. Clone the repository:
   ```bash
   git clone <repository_url>
   cd social-media-activity-checker
2. Install the dependencies using Maven:
   ```bash
   mvn clean install
3. Configure the RapidAPI keys in your application.properties file:
   ```bash
   rapidapi.instagram.host=instagram-scraper-api2.p.rapidapi.com
   rapidapi.instagram.key=your_rapidapi_key
   rapidapi.facebook.host=axesso-facebook-data-service.p.rapidapi.com
   rapidapi.facebook.key=your_rapidapi_key
   rapidapi.twitter.host=twitter154.p.rapidapi.com
   rapidapi.twitter.key=your_rapidapi_key

## Running the Application
1. Start the Spring Boot application:
   ```bash
   mvn spring-boot:run
2. The application will start on http://localhost:8080.

## Testing the Tool
1. Endpoint
   ```bash
   GET http://localhost:8080/api/checkActivity
2. Parameters
   ```bash
   domain: The domain name for which you want to check social media activity.
3. Example Request
   ```bash
   GET http://localhost:8080/api/checkActivity?domain=zomato.com
4. Example Response
   ```bash
   {
    "instagram": {
        "url": "https://www.instagram.com/zomato",
        "active": true
    },
    "tiktok": {
        "url": "https://www.tiktok.com/@zomatoindia",
        "active": false
    },
    "twitter": {
        "url": "https://twitter.com/zomato",
        "active": true
    }
   }

## Additional Information
1. Make sure to replace your_rapidapi_key with your actual RapidAPI key in the application.properties file.
2. Ensure that the API services you are using are active and you have sufficient quota on your RapidAPI account.
3. If you encounter any issues, check the logs for error messages and ensure your API keys are correct.

## Contact
 For any questions or issues, please contact iamadipurohit@gmail.com

