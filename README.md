# CRIO WINTER OF DOING STAGE - 2B
# Crio-XMeme-Stream
CRIO XMEME STREAM PROJECT

# Technology Used
1) Backend          => JAVA Spring Boot
2) Frontend         => HTML/CSS, Bootstrap, Thymeleaf
3) Database         => Postgresql
4) API              => JAVA REST API
5) SWAGGER          => API DOCUMENTATION
6) Container Engine => Docker

# NOTE
1) Both backend(backend codebase) and frontend deployed together, so they both have same URL.
2) Database URL also same.
3) *Database table xmeme_entity will generate Automatically. No need to create table manually 
4) Database structure :- (id Long type, name String type, url String type, caption String type)

# About Repository Structure
1) xmeme_stream                => contains xmeme stream project source code
2) xmeme_stream/Dockerfile     => Dockerfile for Spring Boot project
3) xmeme_stream/docker-compose => Docker compose file for deploying Postgresql and Xmeme Stream App with database connectivity

# DATABASE (psql -h ip_addr -U xmeme -p 5432)
1) DATABASE TABLE 	  :- xmeme_stream
2) DATABASE USER  	  :- xmeme
3) DATABASE PASSWORD      :- xmeme

# How To Setup (UBUNTU 18.04 LINUX X86)
1) git clone repository
2) cd divyansh-1999-dr-me_buildout_xmeme
3) chmod +x install.sh
4) chmod +x server_run.sh
5) chmod +x sleep.sh or wait 10-20 sec
6) goto http://{your ip address}:8081/ 
7) for Swagger Dashboard goto http://{your ip address}:8080/swagger-ui.html
8) for Swagger API goto http://{your ip address}:8080/swagger-ui/
9) for database(POSTGRESQL) =>  {your ip address}:5432  

# How to Setup in Non UBUNTU 18.04 Distros
1) Install packages :-
openjdk-8-jdk openjdk-8-jre maven
2) Setup Docker and Docker-compose
3) git clone gitlab-repository
4) cd divyansh-1999-dr-me_buildout_xmeme
5) chmod +x server_run.sh
6) wait 10-20 sec
7) goto http://{your ip address}:8081/ 
8) for Swagger Dashboard goto http://{your ip address}:8080/swagger-ui.html
9) for Swagger API goto http://{your ip address}:8080/swagger-ui/
10) for database(POSTGRESQL) =>  {your ip address}:5432  
