---

# Management App

## Overview

The Management App is a Spring Boot application designed for managing employee data with different user roles including ADMIN, MANAGER, and USER. It includes functionalities for user authentication and authorization, employee CRUD operations, and JWT-based security.

## Features

- **Authentication**: Register and login using JWT.
- **Authorization**: Role-based access control with different permissions for ADMIN, MANAGER, and USER roles.
- **Employee Management**:
  - **ADMIN**: Full CRUD operations on employee data.
  - **MANAGER**: Read and create employee data.
  - **USER**: Read-only access to employee data.

## Tech Stack

- **Backend**: Spring Boot
- **Database**: PostgreSQL
- **Security**: Spring Security, JWT
- **Build Tool**: Maven
- **Java Version**: 17

## Setup

### Prerequisites

- Java 17
- PostgreSQL

### Configuration

1. **Database Setup**:
   - Create a PostgreSQL database named `management_db`.
   - Update the `application.properties` file with your PostgreSQL credentials.

2. **Application Properties**:
   ```properties
   spring.application.name=Management_App
   spring.datasource.url=jdbc:postgresql://localhost:5432/management_db
   spring.datasource.username=postgres
   spring.datasource.password=your_password
   spring.datasource.driver-class-name=org.postgresql.Driver
   ```

3. **Dependencies**:
   - Ensure the dependencies are correctly specified in `pom.xml`.

### Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/management-app.git
   cd management-app
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Access the application at `http://localhost:8080`.

## Endpoints

### Authentication

- **Register**: `POST /api/auth/signup`
  - Request Body: `RegisterRequest`
- **Login**: `POST /api/auth/login`
  - Request Body: `AuthenticationRequest`

### Employee Management

- **ADMIN Endpoints**:
  - **Get Employee by ID**: `GET /api/admin/view/{id}`
  - **Get All Employees**: `GET /api/admin/view`
  - **Save Employee**: `POST /api/admin/add`
  - **Update Employee**: `PUT /api/admin/update/{id}`
  - **Delete Employee**: `DELETE /api/admin/delete/{id}`

- **MANAGER Endpoints**:
  - **Get Employee by ID**: `GET /api/manager/view/{id}`
  - **Get All Employees**: `GET /api/manager/view`
  - **Save Employee**: `POST /api/manager/add`

- **USER Endpoints**:
  - **Get Employee by ID**: `GET /api/user/view/{id}`
  - **Get All Employees**: `GET /api/user/view`

## Contribution

Feel free to contribute by submitting issues or pull requests. Please adhere to the coding standards and write clear commit messages.


## Contact

For questions or feedback, please contact [kkaanapriyan@gmail.com].

---
