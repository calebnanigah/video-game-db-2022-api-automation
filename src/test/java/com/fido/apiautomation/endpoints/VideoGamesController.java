package com.fido.apiautomation.endpoints;

import com.fido.apiautomation.config.BaseUrlSetup;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

public class VideoGamesController {

    private String videoGamesEndpoint;

    // Constructor to initialize baseUrl and authEndpoint
    public VideoGamesController() {
        // Initialize the BaseUrlSetup to get the full URL for the video games endpoint
        BaseUrlSetup baseUrlSetup = new BaseUrlSetup();
        this.videoGamesEndpoint = baseUrlSetup.getEndpoint("video.games.controller");
    }

    // Method to get all video games
    public Response getAllVideoGames() {
        return RestAssured
                .given()
                .when()
                .get(videoGamesEndpoint)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    // Method to create a new video game (POST request)
    public Response createVideoGame(String requestBody) {

        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(videoGamesEndpoint)
                .then()
                .extract()
                .response();
    }

    // Method to get a new video game (GET request)
    public Response getVideoGame(Object id) {
        String idAsString;

        // Convert the id to a string, depending on its type
        if (id instanceof Integer) {
            idAsString = String.valueOf(id);  // Convert Integer to String
        } else if (id instanceof String) {
            idAsString = (String) id;  // It's already a String
        } else {
            throw new IllegalArgumentException("ID must be either an Integer or String");
        }

        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .get(videoGamesEndpoint + '/' + idAsString)  // Use the ID as a String
                .then()
                .extract()
                .response();
    }

    // Method to get a new video game (GET request)
    public Response putVideoGame(Object id, String requestBody) {
        String idAsString;

        // Convert the id to a string, depending on its type
        if (id instanceof Integer) {
            idAsString = String.valueOf(id);  // Convert Integer to String
        } else if (id instanceof String) {
            idAsString = (String) id;  // It's already a String
        } else {
            throw new IllegalArgumentException("ID must be either an Integer or String");
        }

        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put(videoGamesEndpoint + '/' + idAsString)  // Use the ID as a String
                .then()
                .extract()
                .response();
    }

    // Method to get a new video game (GET request)
    public Response deleteVideoGame(Object id) {
        String idAsString;

        // Convert the id to a string, depending on its type
        if (id instanceof Integer) {
            idAsString = String.valueOf(id);  // Convert Integer to String
        } else if (id instanceof String) {
            idAsString = (String) id;  // It's already a String
        } else {
            throw new IllegalArgumentException("ID must be either an Integer or String");
        }

        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .delete(videoGamesEndpoint + '/' + idAsString)  // Use the ID as a String
                .then()
                .extract()
                .response();
    }
}
