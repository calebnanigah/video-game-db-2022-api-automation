package com.fido.apiautomation.endpoints;

import com.fido.apiautomation.config.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthController {
    private String baseUrl;
    private String authEndpoint;

    // Constructor to initialize baseUrl and authEndpoint
    public AuthController() {
        ConfigReader config = new ConfigReader();
        this.baseUrl = config.getProperty("url.base");
        this.authEndpoint = config.getProperty("auth.controller");

        // Set the base URI for RestAssured
        RestAssured.baseURI = baseUrl;
    }

    // Method to create the request body with credentials dynamically
    public String requestBody(String username, String password) {
        return "{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}";
    }

    // Method to send authentication request
    public Response authenticate(String username, String password) {
        String body = requestBody(username, password);

        // Make the API request and return the response
        return RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(authEndpoint)
                .then()
                .extract()
                .response();
    }
}
