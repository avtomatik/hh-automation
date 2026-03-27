#!/bin/bash
set -e

PROJECT_DIR="$HOME/dev/hh-automation"
JAR="$PROJECT_DIR/target/hh-automation-1.0-SNAPSHOT.jar"
LOG_DIR="$PROJECT_DIR/logs"

mkdir -p "$LOG_DIR"

echo "[$(date)] Starting job..."

cd "$PROJECT_DIR"

java -jar "$JAR"

echo "[$(date)] Finished."
