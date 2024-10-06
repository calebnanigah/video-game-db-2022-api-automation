package com.fido.apiautomation.tests;

import com.fido.apiautomation.endpoints.AuthController;
import com.fido.apiautomation.config.ConfigReader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthControllerTest {

    private AuthController authController;
    ConfigReader config = new ConfigReader();

    @BeforeMethod
    public void setUp() {
        // Initialize the AuthController
        authController = new AuthController();
    }

    @Test
    public void testAuthenticate_ValidCredentials() {

        // Use the AuthController to authenticate with valid credentials
        Response response = authController.authenticate(config.getProperty("auth.username"), config.getProperty("auth.password"));

        // Assert the status code and token
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200");
        String token = response.jsonPath().getString("token");
        Assert.assertNotNull(token, "Token should not be null");
        Assert.assertFalse(token.isEmpty(), "Token should not be empty");
        // Split the token by dots to check if it has 3 parts
        String[] tokenParts = token.split("\\.");
        Assert.assertEquals(tokenParts.length, 3, "Token should have 3 parts separated by dots");
    }

    @Test
    public void testAuthenticate_InvalidCredentials() {
        // Use the AuthController to authenticate with invalid credentials
        Response response = authController.authenticate("wrongUser", "wrongPassword");

        // Assert the status code for invalid credentials
        Assert.assertEquals(response.getStatusCode(), 403, "Expected status code 403 for invalid credentials when password and username are invalid");
    }

    @Test
    public void testAuthenticate_EmptyCredentials() {
        // Use the AuthController to authenticate with invalid credentials
        Response response = authController.authenticate("", "");

        // Assert the status code for invalid credentials
        Assert.assertEquals(response.getStatusCode(), 403, "Expected status code 403 for invalid credentials when password and username are empty");
    }

    @Test
    public void testAuthenticate_EmptyPassword() {
        // Use the AuthController to authenticate with invalid credentials
        Response response = authController.authenticate(config.getProperty("auth.username"), "");

        // Assert the status code for invalid credentials
        Assert.assertEquals(response.getStatusCode(), 400, "Expected status code 403 for invalid credentials when password is empty");
    }

    @Test
    public void testAuthenticate_EmptyUsername() {
        // Use the AuthController to authenticate with invalid credentials
        Response response = authController.authenticate("", config.getProperty("auth.password"));

        // Assert the status code for invalid credentials
        Assert.assertEquals(response.getStatusCode(), 403, "Expected status code 403 for invalid credentials when username is empty");
    }
}
