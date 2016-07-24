#!/bin/bash

SERVER="121.251.255.96"
JAR="target/IntegrateApplication-0.0.1-SNAPSHOT.jar"

echo "Building $JAR..."
mvn package

echo "Upload $JAR to server $SERVER..."
scp $JAR root@$SERVER:/root/Desktop/integrate/

echo "upload config to server"
scp src/main/resources/application-production.yml root@$SERVER:/root/Desktop/integrate/current/

python deploy.py