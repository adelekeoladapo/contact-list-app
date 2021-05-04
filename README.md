# Contact List Application

## Technologies used
##### Backend
- Java
- Springboot
- Postgres database
- Ebean ORM

##### Frontend
- HTML
- CSS
- TypeScript
- Angular

##### Others
- Docker
- Docker compose
- NGINX

### Requirements
- Install <b>docker</b>
- Install <b>docker compose</b>

## Starting the App
1. Clone the project and change directory into the root directory of the project using your terminal<br />
   There are two directories (contact-app-backend and contact-app-frontend), a docker-compose.yml file and a README.md file.
2. Run <b>docker-compose up -d</b> to install all dependencies and also start the server. This process might take a few minutes, depending on your internet connection.
3. The backend service runs on port 7000, while the front end runs on port 4200
4. Run <b>docker ps</b> to  confirm that the services have started running.
5. Open your desired web browser and visit http://localhost:4200

## Stopping th App
To stop the services, run <b>docker-compose down --rmi all</b> from your terminal

## Live Sample
I have deployed a sample to my personal server, click https://contact-list.dapoadeleke.me to check.

