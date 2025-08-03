# NAGP Kubernetes Microservice Documentation

### Documentation

This is a java based microservice with PostgresSQL as backing database to 
persist records and fetch whenever requested by the exposed REST API.

The below REST APIs are exposed on 8080 port. On local environment 
the domain is http://localhost:8080 and on GCP cluster the Load Balancer endpoint is

Add Employee: 
POST {{domain}}/employee
{
"firstName": "John",
"lastName": "Doe",
"employeeId": "12345"
}

Get Employee:
GET {{domain}}/employee

Delete Employee
DELETE {{domain}}/employee?id=1

### Docker image

Docker image is build using Dockerfile using below command in the base folder
docker build . -t kubernetes_advanced_2025

Then it is pushed to the docker hub via below command
docker push prateek91sharma/kubernetes_advanced_2025

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

