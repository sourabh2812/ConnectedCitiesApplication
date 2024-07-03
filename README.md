# Connected Cities Application

## Overview

The Connected Cities application is a Java-based program that determines if two cities are connected based on a given list of city connections. The application uses a graph data structure to represent the cities and their connections and employs a breadth-first search (BFS) algorithm to check if there is a path between the specified cities.

## Features

- **Graph Representation**: Uses an adjacency list to represent the graph of cities.
- **Breadth-First Search (BFS)**: Efficiently checks if two cities are connected.
- **Spring Boot Integration**: Utilizes Spring Boot for streamlined configuration and execution.
- **Logging**: Implements SLF4J for robust logging and error handling.
- **Comprehensive Unit Tests**: Includes both positive and negative test cases to ensure the correctness of the application.

## Tools and Dependencies

- **Java 17**: The application is built using Java 17, leveraging modern language features and performance improvements.
- **Spring Boot 3.3.1**: Provides a streamlined framework for building and running the application.
- **SLF4J**: A simple logging facade for Java, used for logging and debugging.
- **JUnit 5**: Used for unit testing to ensure the correctness and reliability of the application.

## Why It's Production Ready

- **Efficient Graph Representation**: The adjacency list provides efficient storage and retrieval of city connections.
- **Robust Algorithm**: BFS ensures that the application can handle large graphs without deep recursion issues.
- **Logging**: SLF4J provides detailed logging, making it easier to debug and monitor the application.
- **Testing**: Comprehensive unit tests ensure that the application works correctly under various scenarios.
- **Spring Boot**: Offers a mature framework for building, running, and managing Java applications, with extensive community support and documentation.

## How to Run the Application

### Prerequisites

- Java 17 or higher
- Maven or Gradle (for building the project)

### Build and Run with Maven

1. **Build the Project**:
    ```sh
    mvn clean package
    ```

2. **Run the Application**:
    ```sh
    java -jar target/connected-cities-1.0.0.jar "New York" "Los Angeles" "src/test/resources/test_connected.txt"
    ```

### Build and Run with Gradle

1. **Build the Project**:
    ```sh
    ./gradlew clean build
    ```

2. **Run the Application with Arguments**:
    ```sh
    ./gradlew bootRun --args='New York Los Angeles src/test/resources/test_connected.txt'
    ```

### Running Tests

To run the unit tests, use the following command:
```sh
./gradlew test
