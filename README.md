# SpringBootHibernate

SpringBootHibernate demonstrates on how to build a simple REST API using SpringBoot framework and Hibernate as an ORM tool. H2 is used as an in-memory DB to perform CRUD operations.

## Installation

Use gradle wrapper to clean, build, test and run the application

##### To clean the application of previous build artifacts
```bash
./gradlew clean
```
##### To run unit tests
```bash
./gradlew test
```
##### To clean previous generated artifacts and build the application to generate an executable .jar file
```bash
./gradlew clean build
```
##### To run the application locally
```bash
./gradlew bootRun
```
##### To check DB data
```bash
http://localhost:8080/h2-console
JDBC url: jdbc:h2:mem:mydb
username: sa
password: <no password>
Connect to the DB and check tables in the left hand pane. Query data in the SQL console
```
##### To get all the customers
```bash
curl -X GET http://localhost:8080/customers
```
##### To get total number of customers
```bash
curl -X GET http://localhost:8080/customers/count
```
##### To get a customer by id
```bash
curl -X GET http://localhost:8080/customers/:customerId

Example:
curl -X GET http://localhost:8080/customers/2
```
##### To add a new customer
```bash
curl -X POST --header "Content-Type: application/json" --data '{"firstName": "Chaitanya", "lastName": "Rayala"}' http://localhost:8080/customers
```
##### To remove an existing customer by id
```bash
curl -X DELETE http://localhost:8080/customers/6
```
##### To replace an existing customer with a new customer
```bash
crul -X PUT --header "Content-Type: application/json" --data `{"firstName": "John", "lastName": "Doe"}' http://localhost:8080/customers/5
```