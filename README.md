# Spring Boot OAuth & Security Management System

This project serves as a robust, production-ready security template for Spring Boot applications. It integrates **Spring Security 6**, **OAuth2**, and **JSON Web Tokens (JWT)** to provide a dual-layered authentication mechanism: traditional credential-based login and modern social login providers.

## Core Security Features

-   **OAuth2 Social Login:** Seamless integration with external providers including **Google** and **GitHub** using Spring Security's OAuth2 client.
-   **Stateless JWT Authentication:** Implementation of stateless sessions using JWT for secure, scalable API communication.
-   **Role-Based Access Control (RBAC):** Fine-grained authorization logic using `@PreAuthorize` annotations and custom security filters.
-   **Secure Password Management:** Industry-standard password hashing using `BCryptPasswordEncoder`.
-   **CORS & CSRF Protection:** Pre-configured security headers and Cross-Origin Resource Sharing (CORS) policies.
-   **Centralized Exception Handling:** Custom `AuthenticationEntryPoint` and `AccessDeniedHandler` for consistent API error responses.

## Technical Architecture

The system follows a modular security filter chain architecture:

1.  **SecurityFilterChain:** Intercepts requests to determine the authentication strategy (Form login vs. OAuth2 vs. JWT).
2.  **JWT Filter:** A custom per-request filter that validates the token in the `Authorization` header and populates the `SecurityContext`.
3.  **Custom UserDetailsService:** Loads user-specific data from the database for standard login flows.
4.  **OAuth2 Success Handler:** Custom logic to handle post-authentication redirects and JWT generation after a successful social login.

## Tech Stack

-   **Backend:** Java 17+, Spring Boot 3.x
-   **Security:** Spring Security 6.x, OAuth2 Client, JJWT (Java JWT)
-   **Database:** PostgreSQL / MySQL (JPA/Hibernate)
-   **Documentation:** Swagger UI / OpenAPI 3
-   **Build Tool:** Maven

## Getting Started

### Prerequisites
-   JDK 17 or higher
-   Maven 3.8+
-   Registered OAuth2 Credentials (Client ID & Secret) from Google/GitHub Developer Consoles.

### Configuration
1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/arancksj22/SpringBootOAuthSecurityManagementSystem.git](https://github.com/arancksj22/SpringBootOAuthSecurityManagementSystem.git)
    cd SpringBootOAuthSecurityManagementSystem
    ```

2.  **Update `application.yml`:**
    Add your OAuth2 credentials in the `src/main/resources` directory:
    ```yaml
    spring:
      security:
        oauth2:
          client:
            registration:
              google:
                client-id: ${GOOGLE_CLIENT_ID}
                client-secret: ${GOOGLE_CLIENT_SECRET}
              github:
                client-id: ${GITHUB_CLIENT_ID}
                client-secret: ${GITHUB_CLIENT_SECRET}
    ```

3.  **Run the application:**
    ```bash
    mvn spring-boot:run
    ```

## API Endpoints

-   `POST /api/v1/auth/register` - Public: User registration.
-   `POST /api/v1/auth/login` - Public: Returns a JWT on success.
-   `GET /oauth2/authorization/google` - Public: Initiates Google OAuth2 flow.
-   `GET /api/v1/user/profile` - Protected: Requires valid JWT or OAuth2 Session.
-   `GET /api/v1/admin/**` - Protected: Requires `ROLE_ADMIN`.

