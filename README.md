# CatalogTrial

## Implementation details
* Apache Maven
* Spring Boot
* Lombok
* PostgreSQL

## About application
Simple catalog.

## DB creation (psql). Not necessary
create database catalog_trial;

\c catalog_trial

create table items(<br>
id bigint primary key,<br>
name varchar(255),<br>
description varchar(255)<br>
);

## I/O (API)
Use browser console or tools like cURL.

### POST
#### Browser:
fetch(
  '/api/json/items', 
  { 
    method: 'POST', 
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ name: 'First item', description: 'Hi'})
  }
).then(result => result.json().then(console.log))
#### cURL:
curl -i -X POST -H "Content-Type: application/json" -d '{"name":"123","description":"333"}' http://localhost:8080/api/json/items

### GET
#### Browser:
fetch('/api/json/items').then(response => response.json().then(console.log))
fetch('/api/json/items/2').then(response => response.json().then(console.log))
#### cURL:
curl localhost:8080/api/json/items
curl localhost:8080/api/json/items/2

### PUT
#### Browser:
fetch(
  '/api/json/items/2', 
  { 
    method: 'PUT', 
    headers: { 'Content-Type': 'application/json' }, 
    body: JSON.stringify({ description: 'sdfsdfsdf'})
  }
).then(result => result.json().then(console.log));
#### cURL:
curl -i -X PUT -H "Content-Type: application/json" -d "{\"description\":\"111\"}" http://localhost:8080/api/json/items/1

### DELETE
#### Browser:
fetch('/api/json/items/2', { method: 'DELETE' }).then(result => console.log(result))
#### cURL:
curl -X DELETE http://localhost:8080/api/json/items/2