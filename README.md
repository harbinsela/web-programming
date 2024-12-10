SPRINGBOOT LABORATORY EXERCISES
-

Lab 3B requires setting up a PostgreSQL database for data storage.

1. Install PostgreSQL: Download and install PostgreSQL.

2. Create Database: Create a database named music.

3. Configure Application: Update the application-prod.properties file with your PostgreSQL details:
spring.datasource.url=jdbc:postgresql://localhost:5432/music
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update

