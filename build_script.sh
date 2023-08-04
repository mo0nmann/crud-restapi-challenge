#!/bin/sh

eval $(minikube docker-env)
docker build -t crud-restapi-challenge:latest .
helm uninstall crud-restapi-challenge
helm install crud-restapi-challenge helm/crud-restapi-challenge