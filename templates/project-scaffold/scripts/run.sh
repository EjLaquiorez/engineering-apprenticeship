#!/bin/bash
# Build and run the application locally

set -euo pipefail

mvn clean package -DskipTests
java -jar target/*.jar
