![Java CI with Maven](https://github.com/calebnanigah/video-game-db-2022-api-automation/actions/workflows/maven.yml/badge.svg)

# Video Game DB 2022 API Automation

This project is designed to automate testing of backend APIs using Java, TestNG, RestAssured, and Maven. 
<br>
The automation framework is built to allow ease of scalability and maintainability.

## Prerequisites

Before setting up the project, make sure you have the following installed:

1. **Java 21** (or JDK 21)  
   Ensure that you have Java 21 installed. You can check this by running:
   ```bash
   java -version
   
2. **Maven**
   Maven is used as the build and dependency management tool. You can check if Maven is installed by running:
    ```bash 
   mvn -v
    ```
   If Maven is not installed, follow this [guide](https://maven.apache.org/install.html).

## Technologies
1. Java 21: The core programming language used for developing this project.
2. Maven: Used for project build, dependency management, and running TestNG test cases.
3. TestNG: A testing framework used for structuring test cases and managing test execution.
4. RestAssured: A Java-based library used for testing RESTful APIs.
5. SLF4J & Logback: Used for logging during test execution.

# Setup

## 1. Clone the Repository
````
git clone https://github.com/calebnanigah/video-game-db-2022-api-automation.git
cd fido-backend-api-automation
````
## 2. Set Up Java
Ensure that Java 21 is installed and configured. You can use SDKMAN! for easy installation:
```bash
sdk install java 21.x.x
sdk use java 21.x.x
```
Verify installation:
```bash
java -version
```

## 3. Build the Project
Maven will handle dependencies and project compilation. Run the following command to build the project:
```bash
mvn clean install
```

## 4. Running TestNG Tests
```bash
mvn test
```
This will execute all tests present in the src/test/java/com/fido/apiautomation/tests directory.

## 4. Viewing Tests Reports
After running the tests, generate the Allure report:
```bash
mvn allure:report
```
## 4. Serving Tests Reports
Serve the report:
```bash
mvn allure:serve
```

## 5. Setting Up API Endpoints Configuration

1. The API endpoints for the Video Games Swagger API are stored in a configuration file for easy maintenance.
That is: `endpoints.properties` file under `src/main/resources/config/endpoints.properties` with the following content:
```bash
# User Credentials
auth.username=<your-username>
auth.password=<your-password>

# Base URL for API endpoints
url.base=https://www.videogamedb.uk:443

# Endpoints
auth.controller=/api/authenticate
video.games.controller=/api/v2/videogame
```

2. Use the `ConfigLoader` utility to read the properties in your test classes

## 6. Authentication Handling
There is a service layer that handles authentication in `src/test/java/com/fido/apiautomation/endpoints/AuthController.java`

## 7. Structuring the Test Classes

### Test cases are organized by API controllers.

_For this current project, the test are handled by_
1. API Authentication Controller Test
2. API Video Games Controller Test
