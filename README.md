# Social Media Activity Checker

## Overview
The **Social Media Activity Checker** is a Spring Boot application that retrieves social media links associated with a given domain name and determines their activity status based on the timestamp of their last post.

## Features
- Retrieves social media links (e.g., **Facebook**, **Instagram**, **Twitter**, **TikTok**) associated with a domain.
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
