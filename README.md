# EmployWise Project

## Description
This project provides REST API endpoints to manage employee data in a MongoDB database.

## Setup Instructions
1. **Clone the Repository:**

2. **Database Configuration:**
- Ensure MongoDB is installed and running on `localhost` at port `27017`.
- Create a MongoDB database named `EmployWise`.

3. **Run the Application:**
- Configure MongoDB connection settings in `application.properties`.
- Build and run the project using your preferred IDE or by running the command: `./mvnw spring-boot:run`.

4. **Accessing the APIs:**
- Base URL: `http://localhost:<port>/employees`

## API Endpoints

### 1. Add Employee
- **Route**: `POST /add`
- **Description**: Add a single employee to the database.
- **Input JSON Structure**:
```json
{
 "employeeName": "employee1",
 "phoneNumber": "1234567890",
 "email": "emp1@example.com",
 "reportsTo": "managerId",
 "profileImage": "image1_url"
}
```
### 2\. Get All Employees

*   **Route**: `GET /all`
*   **Description**: Retrieve a list of all employees.

### 3\. Get Employee by ID

*   **Route**: `GET /{id}`
*   **Description**: Retrieve an employee by their ID.

### 4\. Delete Employee by ID

*   **Route**: `DELETE /{id}`
*   **Description**: Delete an employee by their ID.

### 5\. Update Employee

*   **Route**: `PUT /{id}`
*   **Description**: Update an employee's information.
*   **Input JSON Structure**:
  
```json
{
    "employeeName": "Updated Name",
    "phoneNumber": "9876543210",
    "email": "updated@example.com",
    "reportsTo": "updatedManagerId",
    "profileImage": "updated_image_url"
    }
```
### 6. Add Multiple Employees

- **Route**: `POST /employees/add-multiple`
- **Description**: Add multiple employees to the database in a single request.
- **Input JSON Structure**:

```json
[
  {
    "employeeName": "Employee 1",
    "phoneNumber": "1111111101",
    "email": "emp1@example.com",
    "reportsTo": "managerId1",
    "profileImage": "image_url_1"
  },
  {
    "employeeName": "Employee 2",
    "phoneNumber": "8769765502",
    "email": "emp2@example.com",
    "reportsTo": "managerId2",
    "profileImage": "image_url_2"
  }
]

```

### 7. Get Nth Level Manager

- **Route**: `GET /manager`
- **Description**: Retrieve the nth level manager of an employee.
- **Query Parameters**:
    - `employeeId`: ID of the employee
    - `level`: The level of the manager to retrieve.
- **Example**:
```
GET /employees/manager?employeeId=employeeIdValue&level=3
```
### 8. Get Employees with Pagination and Sorting

- **Route**: `GET /paged`
- **Description**: Retrieve employees with pagination and sorting.
- **Query Parameters**:
- `page`: Page number for pagination
- `size`: Number of records per page
- `sortBy`: Field to sort the records
- **Example**:
```
GET /employees/paged?page=1&size=10&sortBy=employeeName
```

***Additional Notes:***

* For each API endpoint, ensure proper JSON structure is provided in the request body where applicable.
- Replace `<port>` with the actual port number the application is running on.
- Update MongoDB connection settings in `application.properties` if needed.

For more details, refer to the codebase.
