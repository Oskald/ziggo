## Order service
### Open API
[OpenAPI](openapi.json)
### Postman
[Postman collection](ZiggoTest.postman_collection.json)
### Installation instruction
1. Using only Dockerfile
   1. Create or reuse existed mysql
   2. Setup following environment variables:
       1. spring.datasource.url
       2. spring.datasource.username
       3. spring.datasource.password
   3. build and run [Dockerfile](Dockerfile)
2. Using docker-compose
   1. Setup following environment
      1. spring.datasource.username
      2. spring.datasource.password
   2. Create and start containers via [docker-compose](docker-compose.yml)
