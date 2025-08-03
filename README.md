# NAGP Kubernetes Microservice Documentation

## Setup

### Git Repo setup
Below steps to be performed for git repo setup.
1. `git clone  https://github.com/prateek91sharma/NAGP_Kubernetes_Advanced_2025.git`
2. `cd NAGP_Kubernetes_Advanced_2025/`
3. `git checkout master`

### Docker image
Docker repo web URL for reference
https://hub.docker.com/repository/docker/prateek91sharma/kubernetes_advanced_2025

Build runnable jar with the command
`gradle bootJar`

Docker image is build using Dockerfile using below command in the base folder <br/>
`docker build . -t prateek91sharma/kubernetes_advanced_2025`

Then it is pushed to the docker hub via below command:<br/>
`docker login` (One time only)<br/>
`docker push prateek91sharma/kubernetes_advanced_2025`

### K8s Deployment steps

The k8s folder contains manifest files for application and database layers
in k8s/app and k8s/db folders respectively

For app deployment the yaml manifests are applied based on dependency order as below.
1. secrets.yaml and configmap.yaml
2. deployment.yaml
3. service.yaml
4. ingress.yaml

For postgres database we need to deploy headless service and deployment in below order.
1. secrets.yaml
2. headless-service.yaml
3. postgres-stateful-set.yaml

## API reference Doc

This is a java based microservice with PostgresSQL as backing database to
persist records and fetch whenever requested by the exposed REST API.

The below REST APIs are exposed on 8080 port by the application layer. On local environment
the domain is http://localhost:8080 and on GCP cluster the Load Balancer endpoint is

#### Add Employee:
POST {{domain}}/employee
{
"firstName": "John",
"lastName": "Doe",
"employeeId": "12345"
}

#### Get Employee:
GET {{domain}}/employee

#### Delete Employee
DELETE {{domain}}/employee?id=1


## Testing

Post creation of database used below command to test the connectivity using psql
`kubectl run -it --rm --image=postgres:latest postgres-client -- /bin/bash` <br/>
Inside bash following commands to connect to db <br/>
`psql -h postgres-headless-svc -U "postgres" -d "postgres"` <br/>
On prompt enter the password. Post entering psql command line, the connectivity is established. <br/>
Run below command to check if app server had initialized the db as well  <br/>
`select * from employee;`

For checking all injected parameters from configmap and secrets use below
`kubectl exec <pod-name> -- printenv`