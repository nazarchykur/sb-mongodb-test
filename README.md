# Spring Boot and MongoDB Project

This project demonstrates a simple CRUD application built with Spring Boot and MongoDB. It provides standard CRUD operations for managing data in a MongoDB database. The application is containerized using Docker Compose, and MongoDB is used as the database backend.

### Build and Run Instructions

To build and run the project, follow these steps:

1. Clone the repository:

`git clone https://github.com/your-username/your-project.git`

`cd your-project`

2. Start the Docker containers using Docker Compose:

`docker compose up -d`
This will start the MongoDB container and the Mongo Express web interface for managing the database.

To stop Docker Compose use: `docker compose down`

3. Build the application:

Clean and build the application using Gradle:
`./gradlew clean build`

4. Access the application:

The Spring Boot application is running on http://localhost:8080. You can access the REST APIs provided by the application using a tool like cURL or Postman.

The Mongo Express web interface is running on http://localhost:8081. You can use it to visually interact with the MongoDB database.

5. Explore the API documentation:

The project includes API documentation generated with the springdoc-openapi library.

To access the API documentation, open your web browser and navigate to http://localhost:8080/swagger-ui/index.html.

The Swagger UI provides an interactive interface for exploring the available endpoints, request/response schemas, and making test requests.

6. Running Tests:

Tests have been added for the services and controllers of the application.

To run the tests, execute the following command:
`./gradlew test`

7. Screenshots:

* The project includes screenshots of Postman requests, Mongo Express and the Swagger UI.
* You can find the screenshots in the screenshots directory of the project.

### Important Decisions and Assumptions

This project assumes that you have Docker and Docker Compose installed on your machine.

MongoDB is used as the database backend, and it is configured with a root username and password for authentication.

The Spring Boot application is configured to connect to the MongoDB database using the provided connection URI in the application.yml file.

The application provides standard CRUD operations for managing data in the MongoDB database. You can extend the functionality as per your requirements.


### Clean Code Principles

In this project, we applied the following clean code principles:

**Separation of Concerns:** The project follows a modular structure with separate packages for controllers, services, repositories, and models. This promotes code organization and makes it easier to understand and maintain the application.

**Descriptive Naming:** We used meaningful and descriptive names for classes, methods, and variables, making the code more readable and self-explanatory.

**Code Reusability:** We focused on writing reusable code by creating generic abstractions, such as a generic repository and service classes. This avoids code duplication and improves maintainability.

**Proper Error Handling:** The application handles and communicates errors effectively by using appropriate exception handling mechanisms and returning meaningful error responses.

**Unit Testing:** We included unit tests for services and controllers using frameworks like JUnit 5 and Mockito. This helps ensure the correctness of the code and provides a safety net for refactoring.