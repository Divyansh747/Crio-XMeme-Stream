# CRIO WINTER OF DOING STAGE - 2B
# Crio-XMeme-Stream
CRIO XMEME STREAM PROJECT

# Technology Used
Frontend         => HTML/CSS, Bootstrap, Thymeleaf
Database         => Postgresql
API              => JAVA REST API
SWAGGER          => API DOCUMENTATION
Container Engine => Docker

# About Repository Structure
Scripts/                    => contains all required scripts for deployment
xmeme_stream                => contains xmeme stream project source code
xmeme_stream/Dockerfile     => Dockerfile for Spring Boot project
xmeme_stream/docker-compose => Docker compose file for deploying Postgresql and Xmeme Stream App with database connectivity

# How To Setup (UBUNTU 18.04 LINUX X86)
1) git clone repository
2) cd Crio-Xmeme-Stream
3) cd Scripts
4) chmod +x install.sh
5) chmod +x server_run.sh
6) chmod +x sleep.sh or wait 10-20 sec
7) goto http://{your ip address}:8081/ 
8) for Swagger Dashboard goto http://{your ip address}:8080/swagger-ui.html
9) for Swagger API goto http://{your ip address}:8080/swagger-ui/
10) for database(POSTGRESQL) =>  {your ip address}:5432  

# How to Setup in Non UBUNTU 18.04 Distros
1) Install packages :-
openjdk-8-jdk openjdk-8-jre maven
2) Setup Docker and Docker-compose
3) chmod +x server_run.sh
4) wait 10-20 sec
5) goto http://{your ip address}:8081/ 
6) for Swagger Dashboard goto http://{your ip address}:8080/swagger-ui.html
7) for Swagger API goto http://{your ip address}:8080/swagger-ui/
8) for database(POSTGRESQL) =>  {your ip address}:5432  

