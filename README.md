# Basic Spring Boot Application  

This project is a simple **Spring Boot REST API** application designed for managing a collection of courses. The application provides basic CRUD (Create, Read, Update, Delete) operations for courses stored in a database.  

## Features  

1. **Entity Management**  
   - The `Course` entity represents the structure of data stored in the database.  
   - Each course has the following fields:  
     - `id` (Primary Key, Auto-Generated)  
     - `name` (Name of the course)  
     - `author` (Author of the course)  

2. **RESTful API**  
   - Endpoints are provided for CRUD operations on the `Course` entity:  
     - `GET /courses` – Retrieve all courses.  
     - `GET /courses/{id}` – Retrieve details of a specific course by its ID.  
     - `POST /courses` – Add a new course.  
     - `PUT /courses/{id}` – Update an existing course.  
     - `DELETE /courses/{id}` – Delete a course by its ID.  

3. **Persistence Layer**  
   - The application uses **Spring Data JPA** for database interactions.  
   - The `CourseRepository` interface extends `JpaRepository` to provide a seamless implementation of database operations like save, find, and delete.  

4. **Exception Handling**  
   - When a course with the requested ID is not found, the application throws a `RuntimeException` with a relevant error message.  

5. **Spring Boot Framework**  
   - The application is built on Spring Boot, leveraging its features for auto-configuration, dependency injection, and an embedded web server (Tomcat).  


## RESTful API Endpoints  

| HTTP Method | URL                 | Description                          | Request Body           | Response                  |
|-------------|---------------------|--------------------------------------|------------------------|---------------------------|
| `GET`       | `/courses`          | Retrieves all courses.               | N/A                    | List of `Course` objects. |
| `GET`       | `/courses/{id}`     | Retrieves a course by ID.            | N/A                    | `Course` object or error. |
| `POST`      | `/courses`          | Creates a new course.                | JSON with course data. | Created `Course` object.  |
| `PUT`       | `/courses/{id}`     | Updates an existing course by ID.    | JSON with course data. | Updated `Course` object.  |
| `DELETE`    | `/courses/{id}`     | Deletes a course by ID.              | N/A                    | No content or error.      |

---

## Technologies Used  

- **Spring Boot**: Simplifies application development with auto-configuration and embedded server support.  
- **Spring Data JPA**: Simplifies database interaction using repositories.  
- **Hibernate**: Manages ORM (Object-Relational Mapping).  
- **H2 Database**: Lightweight in-memory database for development.  
- **Spring Web**: Provides REST API development capabilities.  

---

## How to Run the Application  

1. Clone this repository to your local machine.  
2. Ensure you have Java and Maven installed.  
3. Run the following commands:  
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```  
4. Access the API using tools like Postman or your browser at `http://localhost:8080/courses`.  

---

## Example API Usage  

### Create a Course  

**Request**:  
```http
POST /courses
Content-Type: application/json

{
  "name": "Learn Spring Boot",
  "author": "John Doe"
}
```

**Response**:  
```json
{
  "id": 1,
  "name": "Learn Spring Boot",
  "author": "John Doe"
}
```

### Get All Courses  

**Request**:  
```http
GET /courses
```

**Response**:  
```json
[
  {
    "id": 1,
    "name": "Learn Spring Boot",
    "author": "John Doe"
  }
]
