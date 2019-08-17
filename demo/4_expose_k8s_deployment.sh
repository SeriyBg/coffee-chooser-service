#!/usr/bin/env bash

kubectl expose deployment coffee-service --type=LoadBalancer --port=8080
