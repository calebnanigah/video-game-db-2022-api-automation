package com.fido.apiautomation.config;

import io.restassured.RestAssured;

public class BaseUrlSetup {
    private String baseUrl;

    // Constructor to initialize the base URL
    public BaseUrlSetup() {
        // Load configurations using ConfigReader
        ConfigReader config = new ConfigReader();
        this.baseUrl = config.getProperty("url.base");
    }

    // Method to set up RestAssured base URI and return full URL with endpoint
    public String getEndpoint(String uriKey) {
        // Load the endpoint dynamically based on the key passed (like 'video.games.controller')
        String endpoint = new ConfigReader().getProperty(uriKey);

        // Set RestAssured baseURI
        RestAssured.baseURI = baseUrl;

        // Return the complete endpoint URL (base URL + endpoint path)
        return baseUrl + endpoint;
    }
}
