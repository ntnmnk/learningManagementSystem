#!/bin/bash

# Start the Spring Boot application using Gradle
./gradlew bootRun &

# Wait for the application to start up
sleep 30

# Populate sample data using curl commands
# Replace localhost:8080 with your actual application URL
# You may need to adjust the curl commands based on your API endpoints

# Populate students
curl -X POST -H "Content-Type: application/json" -d '{"registrationId": "1001", "name": "Alice Smith"}' http://localhost:8080/students
curl -X POST -H "Content-Type: application/json" -d '{"registrationId": "1002", "name": "Bob Johnson"}' http://localhost:8080/students
curl -X POST -H "Content-Type: application/json" -d '{"registrationId": "1003", "name": "Charlie Brown"}' http://localhost:8080/students

# Populate subjects
curl -X POST -H "Content-Type: application/json" -d '{"subjectId": "CS101", "name": "Computer Science"}' http://localhost:8080/subjects
curl -X POST -H "Content-Type: application/json" -d '{"subjectId": "MATH101", "name": "Mathematics"}' http://localhost:8080/subjects

# Populate exams
# Assuming CS101 and MATH101 are subject IDs
curl -X POST -H "Content-Type: application/json" -d '{"subject": {"subjectId": "CS101"}, "students": [{"registrationId": "1001"}, {"registrationId": "1002"}]}' http://localhost:8080/exams
curl -X POST -H "Content-Type: application/json" -d '{"subject": {"subjectId": "MATH101"}, "students": [{"registrationId": "1002"}, {"registrationId": "1003"}]}' http://localhost:8080/exams
