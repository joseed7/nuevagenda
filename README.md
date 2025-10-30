📱 Agenda App - Sistema de Gestión de Contactos
Una aplicación RESTful completa para gestionar contactos, desarrollada con Spring Boot y arquitectura en capas.

🚀 Características
✅ CRUD Completo de contactos

✅ API RESTful con mejores prácticas

✅ Validación de datos integrada

✅ Documentación automática con Swagger/OpenAPI

✅ Arquitectura en capas (Controller-Service-Repository)

✅ Base de datos H2 en memoria (Para desarrollo)

✅ DTOs para transferencia de datos

✅ Manejo global de excepciones

🛠️ Tecnologías Utilizadas
Java 17

Spring Boot 3.1.0

Spring Data JPA

H2 Database (En memoria)

SpringDoc OpenAPI (Swagger)

Lombok

Gradle

Bean Validation

📋 Prerrequisitos
Java 17 o superior

Gradle 7.0+

IDE (IntelliJ IDEA recomendado)

🏃‍♂️ Ejecutar la Aplicación
1. Clonar y compilar

   git clone <tu-repositorio>
cd agenda-app
./gradlew clean build

2. Ejecutar la aplicación
   ./gradlew bootRun


   3. Acceder a la aplicación
API REST: http://localhost:8080

Swagger UI: http://localhost:8080/swagger-ui.html

H2 Console: http://localhost:8080/h2-console

📚 Documentación de la API
Endpoints disponibles
Método	Endpoint	Descripción


GET	/api/contactos	Obtener todos los contactos

GET	/api/contactos/{id}	Obtener contacto por ID

POST	/api/contactos	Crear nuevo contacto

PUT	/api/contactos/{id}	Actualizar contacto existente

DELETE	/api/contactos/{id}	Eliminar contacto

GET	/api/contactos/buscar?nombre={nombre}	Buscar por nombre

GET	/api/contactos/buscar-termino?termino={termino}	Búsqueda general

Ejemplos de uso-----
Crear un contacto----
curl -X POST "http://localhost:8080/api/contactos" \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Juan",
    "apellido": "Pérez",
    "telefono": "+1234567890",
    "email": "juan@example.com",
    "direccion": "Calle Principal 123"
  }'
  Obtener todos los contactos---
  curl -X GET "http://localhost:8080/api/contactos"

  Buscar contactos por nombre----
  curl -X GET "http://localhost:8080/api/contactos/buscar?nombre=Juan"

  🗃️ Estructura del Proyecto

  src/main/java/com/agenda/
├── controller/          # Controladores REST
├── service/            # Lógica de negocio
├── repository/         # Acceso a datos
├── model/
│   ├── entity/         # Entidades JPA
│   └── dto/           # Objetos de transferencia
└── config/            # Configuraciones

📊 Modelo de Datos
Entidad Contacto
{
  "id": Long,
  "nombre": String (obligatorio),
  "apellido": String,
  "telefono": String,
  "email": String (validado),
  "direccion": String,
  "fechaCreacion": LocalDateTime,
  "fechaActualizacion": LocalDateTime
}

🔧 Configuración
Base de datos H2 (Desarrollo)
spring.datasource.url=jdbc:h2:mem:agendadb
spring.h2.console.enabled=true

🧪 Testing
Ejecutar tests unitarios:
./gradlew test

🎯 Próximas Características
Autenticación y autorización

Paginación de resultados

Búsqueda avanzada

Exportación a CSV/PDF

Integración con frontend
