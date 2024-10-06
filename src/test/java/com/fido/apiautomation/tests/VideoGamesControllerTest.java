package com.fido.apiautomation.tests;

import com.fido.apiautomation.endpoints.VideoGamesController;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class VideoGamesControllerTest {
    VideoGamesController videoGamesController = new VideoGamesController();

//    TODO:: validate the schemas
    @Test
    public void testGetAllGames() {
        videoGamesController.getAllVideoGames();
    }

    @Test
    public void testGetAllVideoGames() {
        // Initialize VideoGamesController
        VideoGamesController videoGamesController = new VideoGamesController();

        // Get all video games
        Response response = videoGamesController.getAllVideoGames();

//        System.out.println("Response Body: " + response.asString());

        // Validate the response body
        response.then().body("size()", greaterThan(0)) // Check there are games in the response
                .body("[0].id", notNullValue()) // Ensure the first game has a non-null ID
                .body("[0].name", notNullValue()); // Ensure the first game has a non-null name
    }

    // TODO:: validate get all games json schema

    @Test
    public void testCreateVideoGame_WithNoParametersProvided() {
        // Initialize VideoGamesController
        VideoGamesController videoGamesController = new VideoGamesController();

        /*
         * TODO:: Move the requestBody to the VideoGamesController when the can data is created and stored in the database
         *  TODO:: Verify that required failed are part of the payload before creation
         */
        // Define the request body for creating a new video game
        String requestBody = "{\n" +
                "    \"category\": \"\",\n" +
                "    \"name\": \"\",\n" +
                "    \"rating\": \"\",\n" +
                "    \"releaseDate\": \"\",\n" +
                "    \"reviewScore\": \n" +
                "}";

        // a just  a change

        // Send the POST request
        Response response = videoGamesController.createVideoGame(requestBody);

        // Validate that the status code is 403 (Forbidden)
        response.then().statusCode(400);

         System.out.println("Response Body: " + response.asString());

        response.then()
                .body("status", equalTo(400))  // Check that the status is 403
                .body("error", equalTo("Bad Request"))  // Check for the "Forbidden" error
                .body("message", nullValue())  // Ensure there's an error message
                .body("path", equalTo("/api/v2/videogame"));  // Check the path of the error
    }

    @Test
    public void testCreateVideoGame_AllParametersProvidedWithSuccessfulCreation() {
        // Initialize VideoGamesController
        VideoGamesController videoGamesController = new VideoGamesController();

        /*
         * TODO:: Move the requestBody to the VideoGamesController when the can data is created and stored in the database
         *  TODO:: Verify that required failed are part of the payload before creation
         */
        // Define the request body for creating a new video game
        String requestBody = "{\n" +
                "    \"category\": \"Platform\",\n" +
                "    \"name\": \"Mario\",\n" +
                "    \"rating\": \"Mature\",\n" +
                "    \"releaseDate\": \"2012-05-04\",\n" +
                "    \"reviewScore\": 85\n" +
                "}";

        // Send the POST request
        Response response = videoGamesController.createVideoGame(requestBody);

        // Validate that the status code is 403 (Forbidden)
        response.then().statusCode(200);

        // System.out.println("Response Body: " + response.asString());

    }

//    TODO:: Validate post data for the json

    @Test
    public void testGetVideoGame_withValidId() {
        // Initialize VideoGamesController
        VideoGamesController videoGamesController = new VideoGamesController();

        // Send the POST request
        Response response = videoGamesController.getVideoGame(1);

        System.out.println("Response Body: " + response.asString());

        // Validate that the status code is 403 (Forbidden)
        response.then().statusCode(200);

        // System.out.println("Response Body: " + response.asString());

//        todo:: validate the body data
//        response.then().
//                body("VideoGame.id",  equalTo(1))
//                .body("VideoGame.name", equalTo("2"))
//                .body("VideoGame.reviewScore", equalTo("2"))
//                .body("VideoGame.rating", equalTo("2"));

    }

    @Test
    public void testGetVideoGame_UsingInvalidId() {
        // Initialize VideoGamesController
        VideoGamesController videoGamesController = new VideoGamesController();

        // Send the POST request
        Response response = videoGamesController.getVideoGame("one");

        System.out.println("Response Body: " + response.asString());

        // Validate that the status code is 403 (Forbidden)
        response.then().statusCode(400);

    }

    @Test
    public void testPutVideoGame_WithValidPayload() {
        // Initialize VideoGamesController
        VideoGamesController videoGamesController = new VideoGamesController();

        /*
         * TODO:: Move the requestBody to the VideoGamesController when the can data is created and stored in the database
         *  TODO:: Verify that required failed are part of the payload before creation
         */
        // Define the request body for creating a new video game
        String requestBody = "{\n" +
                "    \"category\": \"Platform\",\n" +
                "    \"name\": \"Mario\",\n" +
                "    \"rating\": \"Mature\",\n" +
                "    \"releaseDate\": \"2012-05-04\",\n" +
                "    \"reviewScore\": 85\n" +
                "}";

        // Send the POST request
        Response response = videoGamesController.putVideoGame(1, requestBody);

        // Validate that the status code is 403 (Forbidden)
        response.then().statusCode(200);

         System.out.println("Response Body: " + response.asString());

//        response.then()
//                .body("status", equalTo(403))  // Check that the status is 403
//                .body("error", equalTo("Forbidden"))  // Check for the "Forbidden" error
//                .body("message", nullValue())  // Ensure there's an error message
//                .body("path", equalTo("/api/videogame"));  // Check the path of the error

    }

    @Test
    public void testPutVideoGame_WithInvalidPayload() {
        // Initialize VideoGamesController
        VideoGamesController videoGamesController = new VideoGamesController();

        /*
         * TODO:: Move the requestBody to the VideoGamesController when the can data is created and stored in the database
         *  TODO:: Verify that required failed are part of the payload before creation
         */
        // Define the request body for creating a new video game
        String requestBody = "{\n" +
                "    \"category\": \"\",\n" +
                "    \"name\": \"\",\n" +
                "    \"rating\": \"\",\n" +
                "    \"releaseDate\": \"\",\n" +
                "    \"reviewScore\": \n" +
                "}";

        // Send the POST request
        Response response = videoGamesController.putVideoGame(1, requestBody);

        // Validate that the status code is 403 (Forbidden)
        response.then().statusCode(400);

        System.out.println("Response Body: " + response.asString());

        response.then()
                .body("status", equalTo(400))  // Check that the status is 403
                .body("error", equalTo("Bad Request"))  // Check for the "Forbidden" error
                .body("message", nullValue())  // Ensure there's an error message
                .body("path", equalTo("/api/v2/videogame/1"));  // Check the path of the error

    }

    @Test
    public void testPutVideoGame_WithValidPayloadButInvalidID() {
        // Initialize VideoGamesController
        VideoGamesController videoGamesController = new VideoGamesController();

        /*
         * TODO:: Move the requestBody to the VideoGamesController when the can data is created and stored in the database
         *  TODO:: Verify that required failed are part of the payload before creation
         */
        // Define the request body for creating a new video game
        String requestBody = "{\n" +
                "    \"category\": \"Platform\",\n" +
                "    \"name\": \"Mario\",\n" +
                "    \"rating\": \"Mature\",\n" +
                "    \"releaseDate\": \"2012-05-04\",\n" +
                "    \"reviewScore\": 85\n" +
                "}";

        // Send the POST request
        Response response = videoGamesController.putVideoGame("one", requestBody);

        // Validate that the status code is 403 (Forbidden)
        response.then().statusCode(400);

        System.out.println("Response Body: " + response.asString());

        response.then()
                .body("status", equalTo(400))  // Check that the status is 403
                .body("error", equalTo("Bad Request"))  // Check for the "Forbidden" error
                .body("message", nullValue())  // Ensure there's an error message
                .body("path", equalTo("/api/v2/videogame/one"));  // Check the path of the error

    }

    @Test
    public void testPutVideoGame_WithValidPayloadButIDNotFound() {
        // Initialize VideoGamesController
        VideoGamesController videoGamesController = new VideoGamesController();

        /*
         * TODO:: Move the requestBody to the VideoGamesController when the can data is created and stored in the database
         *  TODO:: Verify that required failed are part of the payload before creation
         */
        // Define the request body for creating a new video game
        String requestBody = "{\n" +
                "    \"category\": \"Platform\",\n" +
                "    \"name\": \"Mario\",\n" +
                "    \"rating\": \"Mature\",\n" +
                "    \"releaseDate\": \"2012-05-04\",\n" +
                "    \"reviewScore\": 85\n" +
                "}";

        // Send the PUT request with the assumption large int values will not be found
        Response response = videoGamesController.putVideoGame(123333333, requestBody);

        // Validate that the status code is 403 (Forbidden)
        response.then().statusCode(404);

        System.out.println("Response Body: " + response.asString());

        response.then()
                .body("status", equalTo(404))  // Check that the status is 403
                .body("error", equalTo("Not Found"))  // Check for the "Forbidden" error
                .body("message", nullValue())  // Ensure there's an error message
                .body("path", equalTo("/api/v2/videogame/123333333"));  // Check the path of the error

    }

    @Test
    public void testDeleteVideoGame_withValidId() {
        // Initialize VideoGamesController
        VideoGamesController videoGamesController = new VideoGamesController();

        // Send the POST request
        Response response = videoGamesController.deleteVideoGame(1);

        System.out.println("Response Body: " + response.asString());

        // Validate that the status code is 403 (Forbidden)
        response.then().statusCode(200);

         System.out.println("Response Body: " + response.asString());

//        todo:: validate the body data
//        response.then().
//                body( "m",  equalTo("Video game deleted"));

    }





}
