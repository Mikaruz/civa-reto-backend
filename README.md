# 🚍 Reto Técnico Civa - Backend

API REST desarrollada con **Java 17** y **Spring Boot 3.4.4** para la consulta de buses.

Este proyecto forma parte de un reto técnico para practicante FullStack. Incluye endpoints para obtener la lista de buses y consultar un bus por ID, con una base de datos relacional y relaciones entre entidades.

---

## ✅ Requerimientos técnicos

- ☕ **Java 17 o superior**
- 🌱 **Spring Boot 3 o superior**
- 🐬 **MySQL** como base de datos relacional
- 🧱 Relación entre entidades (bus y marca)
- 🔗 Endpoints RESTful

---

## 📦 Endpoints disponibles

- `GET api/bus?page=1`  
  Devuelve la lista de todos los buses registrados con paginación.

- `GET api/bus/{id}`  
  Devuelve la información detallada de un bus por su ID.

---

## 🧾 Modelo de datos

### Bus

| Campo          | Tipo     | Descripción                           |
| -------------- | -------- | ------------------------------------- |
| `id`           | Long     | Autogenerado                          |
| `busNumber`    | String   | Número de bus                         |
| `licensePlate` | String   | Placa del bus                         |
| `createdAt`    | DateTime | Fecha de creación (autogenerada)      |
| `active`       | Boolean  | Estado del bus (activo/inactivo)      |
| `brand`        | Brand    | Relación Many-to-One con `Brand`      |
| `features`     | List     | Relación One-To-Many con `BusFeature` |

### Brand (Marca)

| Campo  | Tipo   | Descripción                                    |
| ------ | ------ | ---------------------------------------------- |
| `id`   | Long   | ID de la marca                                 |
| `name` | String | Nombre de la marca (Volvo, Scania, Fiat, etc.) |

---

### BusFeature (Característica)

| Campo  | Tipo   | Descripción                 |
| ------ | ------ | --------------------------- |
| `id`   | Long   | ID de la característica     |
| `name` | String | Nombre de la característica |

---

## 🚀 Ejecución del proyecto

### Pre-requisitos:

- Java 17
- MySQL
- Maven 3+

### Pasos:

1. Crear una base de datos en MySQL (por ejemplo `civa`)
2. Configurar las credenciales en `application.properties`
3. Ejecutar el proyecto:

```bash
./mvnw spring-boot:run
```

---

🔧 Variables de entorno

```bash
spring.datasource.url = jdbc:mysql://${DB_HOST}:${DB_PORT}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
```
