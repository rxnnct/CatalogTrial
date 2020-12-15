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

create table items(
id bigint primary key,
name varchar(255),
description varchar(255)
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
---todo

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
---todo

### DELETE
#### Browser:
fetch('/api/json/items/2', { method: 'DELETE' }).then(result => console.log(result))
#### cURL:
---todo