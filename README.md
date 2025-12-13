# 📖 Journal App

A secure personal journal application built with Spring Boot, featuring Google OAuth authentication, JWT tokens, sentiment analysis, and comprehensive API documentation.

## 🌟 Features

- **JWT Authentication** - Secure token-based user sessions
- **Google OAuth 2.0** - Sign in with your Google account
- **Journal Management** - Create, read, update, and delete personal journal entries
- **User Isolation** - Each user can only access their own entries
- **Sentiment Analysis** - Automatic mood detection in journal entries
- **Email Notifications** - Weekly sentiment reports via email
- **Real-time Messaging** - Kafka integration for event-driven architecture
- **API Documentation** - Interactive Swagger UI at the root URL
- **Caching** - Redis integration for improved performance

## 🛠️ Tech Stack

- **Backend**: Spring Boot 2.7.16, Java 8+
- **Database**: MongoDB Atlas
- **Caching**: Redis Cloud
- **Authentication**: JWT + Google OAuth 2.0
- **APIs**: RESTful APIs with Spring Web
- **Message Queue**: Apache Kafka (Confluent Cloud)
- **Email Service**: Spring Mail with SMTP
- **Documentation**: Swagger/OpenAPI 3
- **Testing**: JUnit 5, Mockito
- **Security**: Spring Security with BCrypt
- **Deployment**: Render

## 🚀 Live Demo

**URL**: [https://journalapp-stff.onrender.com/](https://journalapp-stff.onrender.com/)

Visit the URL to see complete API documentation and usage examples.

## 📋 API Endpoints

### 🔓 Public Endpoints
- `GET /` - API Documentation Homepage
- `POST /public/signup` - Create new user account
- `POST /public/login` - User login (returns JWT token)
- `GET /public/health-check` - Public health status
- `GET /auth/google/callback` - Google OAuth callback

### 🔒 Authenticated Endpoints (Require JWT Token)
- `GET /journal/v2` - Get all user's journal entries
- `POST /journal/v2` - Create new journal entry
- `GET /journal/v2/id/{id}` - Get specific journal entry
- `PUT /journal/v2/id/{id}` - Update journal entry
- `DELETE /journal/v2/id/{id}` - Delete journal entry
- `GET /user` - Get user profile
- `PUT /user` - Update user profile
- `DELETE /user` - Delete user account

## 🔧 Quick Start

### 1. Create Account
```bash
POST /public/signup
{
  "userName": "user@example.com",
  "email": "user@example.com",
  "password": "password123"
}
```

### 2. Login & Get Token
```bash
POST /public/login
{
  "userName": "user@example.com",
  "password": "password123"
}
```

### 3. Create Journal Entry
```bash
POST /journal/v2
Authorization: Bearer YOUR_JWT_TOKEN
{
  "title": "My Day",
  "content": "Today was amazing!"
}
```

### 4. Alternative: Google OAuth
Use Google OAuth for quick authentication and get JWT token from the callback response.

## 🏗️ Architecture

- **Security Layer**: JWT Filter, Spring Security, BCrypt encryption
- **Data Layer**: MongoDB for persistence, Redis for caching
- **Service Layer**: User management, Journal CRUD, Email notifications
- **Integration Layer**: Kafka for messaging, Google OAuth for authentication
- **API Layer**: RESTful endpoints with comprehensive documentation

## 🔒 Security Features

- JWT token authentication with configurable expiration
- Google OAuth 2.0 integration for secure third-party login
- BCrypt password encryption
- User data isolation - users can only access their own data
- Input validation and sanitization
- HTTPS enforcement in production

## 🧪 Testing

- **Unit Tests**: JUnit 5 for comprehensive test coverage
- **Mocking**: Mockito for service layer testing
- **Integration Tests**: Spring Boot Test for end-to-end testing

## 📊 Additional Features

- **Health Monitoring**: Application health check endpoints
- **Sentiment Analysis**: AI-powered mood tracking in journal entries
- **Email Reports**: Automated weekly sentiment analysis reports
- **Event Streaming**: Kafka integration for real-time notifications
- **Performance**: Redis caching for optimized data retrieval

## 🌐 Deployment

Deployed on **Render** with:
- Automatic deployments from GitHub
- Environment variable management for secrets
- SSL/HTTPS enabled by default
- MongoDB Atlas for database hosting
- Redis Cloud for caching
- Confluent Cloud for Kafka messaging

Built with ❤️ using Spring Boot, MongoDB, Redis, and modern cloud technologies.