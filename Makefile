# Makefile for Spring Boot API Learning

# Variables
MVNW = ./mvnw
APP_NAME = spring-api-learn

.PHONY: help run build test clean install stop

help: ## Menampilkan bantuan ini
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-15s\033[0m %s\n", $$1, $$2}'

run: ## Menjalankan aplikasi Spring Boot secara lokal
	$(MVNW) spring-boot:run

build: ## Membangun aplikasi menjadi file JAR (tanpa menjalankan test)
	$(MVNW) clean package -DskipTests

test: ## Menjalankan semua unit test
	$(MVNW) test

clean: ## Membersihkan folder target (hasil build)
	$(MVNW) clean

install: ## Menginstal semua dependensi Maven
	$(MVNW) install -DskipTests

stop: ## Menghentikan aplikasi yang berjalan di port 8080 (Mac/Linux ONLY)
	lsof -t -i:8080 | xargs kill -9 || true
