# CRUD Products: Product Management System 📦

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![Test Coverage](https://img.shields.io/badge/coverage-85%25-green)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.4-green)
![MongoDB](https://img.shields.io/badge/MongoDB-Cloud-green)
![Java](https://img.shields.io/badge/Java-17-orange)
![License](https://img.shields.io/badge/license-Apache%202.0-blue)

CRUD Products is a REST API that implements CRUD operations (Create, Read, Update, Delete) for product management. Developed with Spring Boot and MongoDB, it offers a robust and scalable solution for inventory management, using modern architecture and development best practices.

## Table of Contents 📋

- Technologies Used
- Architecture
- Main Features
- CI/CD Pipeline
- Design Patterns
  - Data Transfer Objects (DTO)
  - Repository Pattern
  - Service Layer
- Project Dependencies
- Project Configuration
- API Documentation (Swagger)
- Project Structure
- Unit Tests

## Technologies Used 🛠️

- **Java OpenJDK 17**: Main programming language
- **Spring Boot 3.4.4**: Framework for web application development
- **Spring Data MongoDB**: For MongoDB integration
- **MongoDB Atlas**: NoSQL database in the cloud
- **Maven**: Dependency management tool
- **JUnit 5 & Mockito**: Framework for unit testing
- **GitHub Actions**: CI/CD pipelines
- **Azure App Service**: Deployment platform
- **Jacoco**: Code coverage
- **Swagger/OpenAPI**: REST API documentation

## Architecture 🏗️

The project is built following a layered architecture:

- **Controllers**: Handle HTTP requests and responses.
- **Services**: Contain business logic.
- **Repositories**: Interfaces for data access.
- **Models**: Domain entities and DTOs.
- **Exceptions**: Custom error handling.

## Main Features ✨

- **Complete RESTful API**: Endpoints to create, read, update, and delete products
- **MongoDB Persistence**: Data storage in the cloud with MongoDB Atlas
- **Data Validation**: Input validation using Jakarta annotations
- **Documentation with OpenAPI/Swagger**: Interactive API documentation
- **Unit Tests**: Extensive test coverage with JUnit and Mockito
- **CI/CD Pipeline**: Continuous integration and deployment with GitHub Actions
- **Cloud Deployment**: Configuration for deployment on Azure App Service

## CI/CD Pipeline 🔄

The project implements a complete CI/CD pipeline using GitHub Actions:

```yaml
name: CI/CD Pipeline Production

on:
  pull_request:
  push:
    branches:
      - main

jobs:
  build:
    name: Build
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'
          cache: maven
      - name: Maven Package
        run: mvn clean package -DskipTests
      - name: Upload Artifact for deployment job
        uses: actions/upload-artifact@v4
        with:
          name: springboot-example
          path: target/*.jar

  test:
    name: Test
    needs: build
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'
          cache: maven
      - name: Maven Verify
        run: mvn verify
      - name: Run Product Tests
        run: |
          echo "Running product tests..."

  deploy:
    name: Deploy
    needs: test
    runs-on: ubuntu-latest
    steps:
      - name: Download Artifact from build job
        uses: actions/download-artifact@v4
        with:
          name: springboot-example
      - name: Deploy to Azure App Service
        uses: azure/webapps-deploy@v2
        with:
          app-name: Blessings
          publish-profile: ${{ secrets.AZUREPARTIALUBLISHPROFILE }}
          package: '*.jar'
```

## Design Patterns 📐

### Data Transfer Objects (DTO)

The project uses the DTO pattern to separate domain entities from objects used for data transfer:

```java
public class ProductoDTO {
    private String idProducto;
    private String nombre;
    private double precio;
    private String descripcion;
    
    // Constructors, getters and setters
}
```

### Repository Pattern

The application implements the Repository pattern using Spring Data MongoDB:

```java
@Repository
public interface ProductoRepository extends MongoRepository<Producto, String> {
    /**
     * Search for a product by its id.
     * @param idProducto product identifier
     * @return the product found or null if it doesn't exist.
     */
    Producto findByIdProducto(String idProducto);
}
```

### Service Layer

The service layer encapsulates business logic:

```java
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> consultarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto consultarProducto(String idProducto) {
        return productoRepository.findByIdProducto(idProducto);
    }
    
    // Implementation of other methods...
}
```

## Project Dependencies 📚

- **Spring Boot Starter Web**: For creating web applications with Spring MVC
  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  ```

- **Spring Boot Starter Data MongoDB**: MongoDB integration
  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-mongodb</artifactId>
  </dependency>
  ```

- **SpringDoc OpenAPI**: API documentation with Swagger
  ```xml
  <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
      <version>2.1.0</version>
  </dependency>
  ```

- **JaCoCo**: For code coverage analysis
  ```xml
  <plugin>
      <groupId>org.jacoco</groupId>
      <artifactId>jacoco-maven-plugin</artifactId>
      <version>0.8.12</version>
  </plugin>
  ```

## Project Configuration ⚙️

### Prerequisites

- Java OpenJDK 17.x.x
- Apache Maven 3.9.x
- MongoDB / MongoDB Atlas
- Postman (optional)

### Required Environment Variables

```properties
# MongoDB Configuration
spring.data.mongodb.uri=mongodb+srv://username:password@host/
spring.data.mongodb.database=CRUD
```

### Running the Project Locally

1. Clone the repository:
```bash
git clone https://github.com/AnderssonProgramming/crud-products.git
```

2. Navigate to the project directory:
```bash
cd crud-products
```

3. Build the project:
```bash
mvn clean package
```

4. Run the application:
```bash
java -jar target/crud-0.0.1-SNAPSHOT.jar
```

## API Documentation (Swagger) 📘

The project uses Swagger to document the REST API. Access the documentation at:

```
http://localhost:8080/swagger-ui/index.html
```

Example endpoint documentation:

```java
@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    /**
     * Query all products.
     * @return ResponseEntity with the list of products.
     */
    @GetMapping("")
    @Operation(summary = "Query products", description = "Endpoint to query all products.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Products returned correctly"),
        @ApiResponse(responseCode = "404", description = "Products not found")
    })
    public ResponseEntity<List<Producto>> getProductos() {
        return ResponseEntity.ok(productoService.consultarProductos());
    }
    
    // Other endpoints...
}
```

## Project Structure 📁

```
src
├── main
│   ├── java
│   │   └── edu
│   │       └── eci
│   │           └── cvds
│   │               └── crud
│   │                   ├── CrudApplication.java
│   │                   ├── Producto.java
│   │                   ├── ProductoController.java
│   │                   ├── ProductoDTO.java
│   │                   ├── ProductoRepository.java
│   │                   ├── ProductoService.java
│   │                   └── ProductoServiceImpl.java
│   └── resources
│       └── application.properties
├── test
│   └── java
│       └── edu
│           └── eci
│               └── cvds
│                   └── crud
│                       ├── CrudApplicationTests.java
│                       ├── ProductoControllerTest.java
│                       ├── ProductoDTOTest.java
│                       ├── ProductoRepositoryTest.java
│                       ├── ProductoServiceImplTest.java
│                       └── ProductoTest.java
└── pom.xml
```

## Unit Tests 🧪

The project includes unit tests for all layers:

- **Entities**: Tests to validate getters, setters, and constructors
- **DTOs**: Tests to validate transformations and validations
- **Services**: Tests with mocks to validate business logic
- **Controllers**: Tests to validate endpoints and HTTP responses
- **Repositories**: Tests to validate database operations

Example of a unit test for a service:

```java
@Test
void testConsultarProductos() {
    List<Producto> productos = Arrays.asList(
        new Producto("Producto1", 10.0, "Desc1"),
        new Producto("Producto2", 20.0, "Desc2")
    );
    when(productoRepository.findAll()).thenReturn(productos);
    List<Producto> result = productoService.consultarProductos();
    assertEquals(2, result.size());
    verify(productoRepository).findAll();
}
```

---

Developed with ❤️ as part of a Spring Boot learning project