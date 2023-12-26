# Social Media API with Spring Boot

This project is a Social Media API developed using the Spring Boot framework. It provides a platform for managing users, friendships, posts, likes, and comments through a RESTful API.

## Base Classes

The project includes the following base classes:

- **User:** Represents a user in the system with properties like username, password, email, etc.
- **Friendship:** Represents the friendship relationship between users. Includes status (e.g., pending, accepted).
- **Post:** Represents a post created by a user with content, creation date, and associated likes and comments.
- **Like:** Represents a like given to a post by a user.
- **Comment:** Represents a comment made on a post by a user.

## Dependencies

The project uses the following dependencies:

- **Spring Web:** For building RESTful web services.
- **Spring Data JPA:** For easy implementation of JPA repositories.
- **MySqlDriver:** MySQL JDBC driver for connecting to the MySQL database.
- **Lombok:** A library to reduce boilerplate code, such as getters, setters, and constructors.

## Database Tables

The following tables are used in the MySQL database:

- **Users:** Stores user information.
- **Friendships:** Manages friendships with reference to users.
- **Posts:** Stores posts with content, creation date, and the associated user.
- **Likes:** Represents the likes given to posts.
- **Comments:** Stores comments made on posts with associated user and post.

These tables are related to each other using one-to-many relationships.
API Endpoints
**GET /api/users**: Get all users.
**GET /api/users/{userId}**: Get a specific user by ID.
**POST /api/users**: Create a new user.
**GET /api/friendships**: Get all friendships.
**GET /api/friendships/{friendshipId}**: Get a specific friendship by ID.
**POST /api/friendships**: Create a new friendship.
**GET /api/posts**: Get all posts.
**GET /api/posts/{postId}**: Get a specific post by ID.
**POST /api/posts**: Create a new post.
**DELETE /api/posts/{postId}**: Delete a post by ID.
**POST /api/posts/{postId}/like**: Add a like to a post.
**GET /api/posts/{postId}/likes**: Get the like count of a post.
**GET /api/comments**: Get all comments.
**GET /api/comments/{commentId}**: Get a specific comment by ID.
**GET /api/comments/post/{postId}**: Get all comments for a specific post.
**POST /api/comments**: Create a new comment.
**DELETE /api/comments/{commentId}**: Delete a comment by ID.

## Contributing
If you would like to contribute to the project, please fork the repository and submit pull requests.

## Usage

To run the project, you need to configure a MySQL database and update the `application.properties` file accordingly. Make sure to have Java and Maven installed.

```bash
# Clone the repository
git clone https://github.com/your-username/social-media-api.git

# Navigate to the project directory
cd social-media-api

# Build and run the application
mvn spring-boot:run
