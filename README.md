# Starter Spring + React project


## Frontend
### Run
cd frontend

npm start

## Backend
### Run
./mvnw spring-boot:run

### Debug
./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"

## Build
./mvnw clean install