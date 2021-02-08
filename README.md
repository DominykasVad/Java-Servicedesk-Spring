# CodeAcademy end of course project

## Getting Started

### Prerequisites

 - Docker
 - docker-compose

### Installing

Using sample docker-compose.yaml file here or in repository

```
---
version: "3.7"
services:
  # Application service
  app:
    image: dominykasvad/ca-java-servicedesk:latest
    container_name: ca_app
    environment:
      - APP_DATABASE_HOST=db
      - APP_DATABASE_PORT=3306
      # Same as MYSQL_DATABASE
      - APP_DATABASE_NAME=sample_database
      # Same as MYSQL_USER
      - APP_DATABASE_USERNAME=sample_username
      # Same as MYSQL_PASSWORD
      - APP_DATABASE_PASSWORD=sample_password
    ports:
      - 8080:8080
    depends_on:
      - db
    # Restart policy
    restart: unless-stopped

  # Database service
  db:
    image: ghcr.io/linuxserver/mariadb
    container_name: ca_mariadb
    environment:
      - PUID=1000
      - PGID=1000
      - TZ=Europe/Vilnius
      # Change MYSQL_ variables
      - MYSQL_ROOT_PASSWORD=sample_rootpassword
      - MYSQL_DATABASE=sampla_database
      - MYSQL_USER=sample_user
      - MYSQL_PASSWORD=sample_password
    volumes:
      # MariaDB volume mounted in docker-compose file location
      - ./database/config:/config
    restart: unless-stopped # Restart policy
```

And in same directory as docker-compose.yaml file

```
mkdir config
docker-compose up -d
```

Default admin user credentials:
```
Username: admin
Password: Password
```

