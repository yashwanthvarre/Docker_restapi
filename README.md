# Creating a simple REST based application

## Basic Idea
1) This is a simple project which helps you understand the basic implemntation of REST API( Representational State Transfer).
2) The Rest api uses http method to access and use the data. The type of data which is used in this project is json format data.
3) The Rest api contains the following methods :
  a) GET
  b) PUT
  c) POST
  d) DELETE
  The above 4 metods are implemented in this project
  
## Introduction
- This project contains a rest api using spring boot.
- Javascript ,HTML, CSS and ajax calls are used for retrieving the data.
- Remote JSON database is used.
- The theme of the project is Users. Displaying user details such as username, phone
number, email address and orders of a customer.
Starting off with the Back-end development, we developed 4 REST API’s with Spring
Boot. Functions of API’s are:
- allUsersData – Get all the users from json database
- specificUserData - Get only the data of a particular user using userId.
- specificUser,AllOrdersData –Get only the orders of a particular user using userId.
- specificUser,SpecificOrderData- Get only an order of a particular user using userId and orderId.

Using JavaScript, JQuery, CSS to display a simple webpage with buttons, fields and
tables. It’s a Single Page Application, wherein, clicking on buttons data is displayed within a
table. Inputs are displayed to choose particular user and particular order.

## Steps to install docker ubuntu:

```sh
sudo apt-get update
sudo apt-get remove docker docker-engine docker.io
sudo apt install docker.io
sudo systemctl start docker
sudo systemctl enable docker
docker --version
```

## Instructions:
- Download the project from github.
- Make the command prompt working directory to be downloaded folder.
- Perform: docker run -p 7200:8080  rest-service (Port number as specified in application  properties file you can use any port number.
- Go to  http://localhost:7200.
