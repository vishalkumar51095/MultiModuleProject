# MultiModuleProject

## Description
**MultiModuleProject** is a Spring Boot multi-module application designed to manage multiple independent modules with separate PostgreSQL databases. It currently contains two modules:

### 1. IVR Module (`ivrimpds`)
- Handles IVR-related records.
- Uses its own PostgreSQL database (`ivrimpds`).
- Provides REST APIs to create, retrieve, and manage IVR records.

### 2. ONORCS Module (`onorcs`)
- Manages ONORCS-related records.
- Uses its own PostgreSQL database (`onorcs`).
- Provides REST APIs for CRUD operations on ONORCS records.

---

## Key Features
- Separate **DataSource, EntityManager, and TransactionManager** for each module.
- Uses **Spring Data JPA** for database operations.
- Fully **RESTful APIs** for both modules.
- Ready for **multi-module deployment** with isolated module databases.
- Designed for easy expansion — new modules can be added independently.

---

## Technologies Used
- Java 11+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven (multi-module project)
- HikariCP (connection pooling)

---

## Project Structure
```

MultiModuleProject
│
├── pom.xml                # Parent Maven POM
├── ivrimpds               # IVR Module
│   ├── src/main/java
│   │   └── com.nic.ivrimpds
│   │       ├── controller
│   │       ├── model
│   │       └── service
│   └── pom.xml
├── onorcs                 # ONORCS Module
│   ├── src/main/java
│   │   └── com.nic.onorcs
│   │       ├── controller
│   │       ├── model
│   │       └── service
│   └── pom.xml
└── README.md

````

---

## Configuration

**Database URLs (PostgreSQL):**
```properties
# IVR Module
jdbc:postgresql://localhost:5432/ivrimpds

# ONORCS Module
jdbc:postgresql://localhost:5432/onorcs
````

* Each module has its own `DataSource`, `EntityManager`, and `TransactionManager`.
* Entities are scanned per module to avoid cross-module conflicts.

---

## API Endpoints

### IVR Module

| Method | Endpoint          | Description             |
| ------ | ----------------- | ----------------------- |
| GET    | /ivr/records      | Get all IVR records     |
| POST   | /ivr/records      | Add a new IVR record    |
| GET    | /ivr/records/{id} | Get IVR record by ID    |
| DELETE | /ivr/records/{id} | Delete IVR record by ID |

### ONORCS Module

| Method | Endpoint             | Description                |
| ------ | -------------------- | -------------------------- |
| GET    | /onorcs/records      | Get all ONORCS records     |
| POST   | /onorcs/records      | Add a new ONORCS record    |
| GET    | /onorcs/records/{id} | Get ONORCS record by ID    |
| DELETE | /onorcs/records/{id} | Delete ONORCS record by ID |

---

## How to Run

1. **Clone the repository**

```bash
git clone https://github.com/<your-username>/MultiModuleProject.git
cd MultiModuleProject
```

2. **Set up PostgreSQL databases**

```sql
CREATE DATABASE ivrimpds;
CREATE DATABASE onorcs;
```

3. **Update database credentials** in the respective configuration files or `DynamicDataSourceFactory`.

4. **Build the project**

```bash
mvn clean install
```

5. **Run the application**

```bash
mvn spring-boot:run
```

6. **Test endpoints**

* Use Postman or curl:

```bash
GET http://localhost:8080/ivr/records
GET http://localhost:8080/onorcs/records
```

---

## Notes

* Make sure your **controllers are in packages scanned by Spring Boot**.
* IVR module is marked as `@Primary` to resolve any ambiguity in JPA configurations.
* DynamicDataSourceFactory is used to create separate DataSources for each module.

---

## License

This project is licensed under the MIT License.
Do you want me to do that?
```
