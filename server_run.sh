#!/bin/bash

cd xmeme_stream

mvn package -DskipTests
sudo docker build -t xmeme-divyansh747 .
sudo docker-compose up -d
