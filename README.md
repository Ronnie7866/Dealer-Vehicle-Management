# Dealer & Vehicle Management API

A Spring Boot REST API for managing dealers and their vehicles with payment processing simulation.

## Features

### Task 1: Dealer & Vehicle Management
- Complete CRUD operations for Dealers and Vehicles
- Fetch vehicles belonging to PREMIUM dealers only
- PostgreSQL database integration
- JPA/Hibernate ORM

### Task 2: Payment Gateway Simulation
- Payment initiation endpoint
- Async payment status update (5-second simulation)
- Support for UPI, Card, and NetBanking methods

## Tech Stack
- Java 17
- Spring Boot 3.5.5
- Spring Data JPA
- PostgreSQL
- Lombok
- Swagger/OpenAPI 3

## Setup Instructions

### Prerequisites
- Java 17+
- PostgreSQL 12+
- Maven 3.6+

### Database Setup
1. Create PostgreSQL database: `dealer_management`
2. Update credentials in `application.properties`
3. Run the application - tables will be auto-created

### Running the Application
```bash
mvn spring-boot:run
```

Application will start on: http://localhost:8080

## API Documentation

### Swagger UI
Access interactive API documentation at: http://localhost:8080/swagger-ui.html

### Endpoints

#### Dealers
- `GET /api/dealers` - Get all dealers
- `GET /api/dealers/{id}` - Get dealer by ID
- `POST /api/dealers` - Create new dealer
- `PUT /api/dealers/{id}` - Update dealer
- `DELETE /api/dealers/{id}` - Delete dealer

#### Vehicles
- `GET /api/vehicles` - Get all vehicles
- `GET /api/vehicles/{id}` - Get vehicle by ID
- `POST /api/vehicles?dealerId={id}` - Create vehicle for dealer
- `PUT /api/vehicles/{id}` - Update vehicle
- `DELETE /api/vehicles/{id}` - Delete vehicle
- `GET /api/vehicles/premium-dealers` - Get vehicles from PREMIUM dealers only

#### Payments
- `POST /api/payment/initiate` - Initiate payment (auto-updates to SUCCESS after 5 seconds)

## Sample Requests

### Create Dealer
```json
POST /api/dealers
{
  "name": "Premium Motors",
  "email": "premium@motors.com",
  "subscriptionType": "PREMIUM"
}
```

### Create Vehicle
```json
POST /api/vehicles?dealerId=1
{
  "model": "BMW X5",
  "price": 75000.00,
  "vehicleStatus": "AVAILABLE"
}
```

### Initiate Payment
```json
POST /api/payment/initiate
{
  "dealerId": 1,
  "amount": 1000.00,
  "method": "UPI"
}
```

## Database Schema
See `src/main/resources/schema.sql` for complete database schema and sample data.

## Testing
- Use Swagger UI for interactive testing
- Import Postman collection (if provided)
- All endpoints return appropriate HTTP status codes
- Error handling implemented for common scenarios