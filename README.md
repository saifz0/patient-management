# Patient Management

A REST API for managing patient records, built with Spring Boot as a learning project.

## Tech Stack

- Java 21
- Spring Boot 4.1.1
- Spring Data JPA (Hibernate)
- Bean Validation
- H2 in-memory database
- Maven

## Features

- Create, read, update and delete patients (CRUD)
- Request validation (required fields, email format, date format)
- Unique email check, with a clear 409 error for duplicates
- Separate request and response DTOs
- Central error handling with `@RestControllerAdvice`

## Project Structure

```
patient-service/src/main/java/com/pm/patientservice
├── controller   # REST endpoints
├── service      # Business logic
├── repository   # Database access (Spring Data JPA)
├── model        # JPA entities
├── dto          # Request and response objects
├── mapper       # Converts between entities and DTOs
└── exception    # Custom exceptions and global handler
```

## Getting Started

### Prerequisites

- JDK 21
- Maven (or use the included Maven wrapper)

### Run the application

```bash
cd patient-service
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

The API starts on `http://localhost:4000`.

## API Endpoints

| Method | Endpoint | Description | Success |
|--------|----------|-------------|---------|
| GET | `/patients` | Get all patients | 200 |
| POST | `/patients` | Create a patient | 201 |
| PUT | `/patients/{id}` | Update a patient | 200 |
| DELETE | `/patients/{id}` | Delete a patient | 204 |

### Example request body (POST)

```json
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "address": "123 Main Street",
  "dateOfBirth": "1995-09-09",
  "registeredDate": "2024-11-28"
}
```

Dates use the `yyyy-MM-dd` format. `registeredDate` is required only when creating a patient.

### Error responses

| Status | When |
|--------|------|
| 400 | Validation failed or invalid date |
| 404 | Patient ID not found |
| 409 | Email already exists |

## Try the API

Ready-made requests are in the `api-request/` folder. Open the `.http` files in IntelliJ and click the run icon next to a request.

## H2 Console

With the app running, open `http://localhost:4000/h2-console` and use:

- JDBC URL: `jdbc:h2:mem:testdb`
- User: `admin_viewer`
- Password: see `application.properties`

The database is in memory, so data resets every time the app restarts.

## Future Improvements

- Get a single patient by ID
- Switch from H2 to PostgreSQL
- Unit and integration tests
- Pagination for the patient list