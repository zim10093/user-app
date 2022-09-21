# user app
### Description
This is basic application for managing user.
Where you can create, update, delete user and find users by birth date range.
### Endpoints:
- **POST** `/users` create user
- **PATCH** `/users/{id}` update one/some user's fields
- **UPDATE** `/users/{id}` update all user`s fields
- **DELETE** `/users/{id}` delete user by id
- **GET** `/users`  with param `formDate` and `toDate`. Find all users by birth data range
#### User`s fields
-   **Email** (required);
-   **First name** (required);
-   **Last name** (required);
-   **Birth date** (required);
-   **Phone number** (optional);
-   **Address** (optional);
#### Features
- **Email** validation
- **Birth date** validation, user should be older than value set in the properties file
#### Used technology
- Java 11
- Spring boot 2.7
- H2 DB
- JUnit
- Mockito
- SOLID
- REST
- N-layer architecture
    - Controller
    - Service
    - Persistence