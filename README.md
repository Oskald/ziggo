## Order service
### Open API
[OpenAPI](openapi.json)
### Postman
[Postman collection](ZiggoTest.postman_collection.json)
### Installation instruction
1. Using only Dockerfile
   1. Create or reuse existed mysql
   2. build and run [Dockerfile](Dockerfile)
      1. build like: docker build . -t <application-image-name>
      2. run like: docker run -d --network <mysql-network-if-in-docker> -e MYSQLDB_HOST=<mysql-db-host> -e MYSQLDB_PORT=<mysql-db-port> -e MYSQLDB_USER=<mysql-db-user> -e MYSQLDB_PASSWORD=<mysql-db-password> -p <host-port>:<container-port>  <application-image-name>
2. Using docker-compose
   1. Setup following environment
      1. MYSQLDB_USER=<mysql-db-user>
      2. MYSQLDB_PASSWORD=<mysql-db-password>
   2. Create and start containers via [docker-compose](docker-compose.yml)
