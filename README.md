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
    body: JSON.stringify({ name: '{name}', description: '{description}'})
  }
).then(result => result.json().then(console.log))
#### cURL:
curl -i -X POST -H "Content-Type: application/json" -d '{"name":"{name}","description":"{description}"}' http://localhost:8080/api/json/items

### GET
#### Browser:
fetch('/api/json/items').then(response => response.json().then(console.log))<br>
fetch('/api/json/items/{id}').then(response => response.json().then(console.log))
#### cURL:
curl localhost:8080/api/json/items
curl localhost:8080/api/json/items/{id}

### Find by name
#### Browser:
fetch('/api/json/items/find-by-name?name={name}').then(response => response.json().then(console.log))
#### cURL:
curl localhost:8080/api/json/items/find-by-name?name={name}

### PUT
#### Browser:
fetch(
  '/api/json/items/{id}', 
  { 
    method: 'PUT', 
    headers: { 'Content-Type': 'application/json' }, 
    body: JSON.stringify({ description: '{description}'})
  }
).then(result => result.json().then(console.log));
#### cURL:
curl -i -X PUT -H "Content-Type: application/json" -d '{"description":"{description}"}' http://localhost:8080/api/json/items/{id}

### DELETE
#### Browser:
fetch('/api/json/items/{id}', { method: 'DELETE' }).then(result => console.log(result))
#### cURL:
curl -X DELETE http://localhost:8080/api/json/items/{id}