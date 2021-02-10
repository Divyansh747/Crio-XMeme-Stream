#!/bin/bash

cd xmeme_stream

mvn package -DskipTests
docker build -t xmeme-divyansh747 .
docker-compose up -d
