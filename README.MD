# Reto 01 - Taller de Estudiantes y Profesores

## Descripción General del Taller

Este proyecto es un sistema de gestión de estudiantes y profesores desarrollado en **Spring Boot**. Su objetivo principal es implementar y probar funcionalidades básicas como listar, filtrar y ordenar estudiantes, aplicando buenas prácticas de desarrollo y pruebas unitarias.

El taller incluye:

- Modelos de datos como `Persona`, `Estudiante`, y `Profesor`.
- Repositorios para manejar datos en memoria.
- Servicios para la lógica de negocio.
- Controladores REST para exponer las funcionalidades.
- Pruebas unitarias y de integración para garantizar la calidad del código.

### Diagrama de Clases

El diagrama de clases que describe las relaciones y atributos de las principales entidades se encuentra en la carpeta `docs`.

- **Ruta**: `docs/diagrama.puml`
![Diagrama de Clases](docs/diagrama.puml)
- Herramienta recomendada para visualizar: [PlantUML](https://plantuml.com/)

## Librerías Utilizadas

A continuación, una lista de las librerías y dependencias clave utilizadas en el proyecto:

### Spring Boot

- **spring-boot-starter-web**: Para construir controladores REST.
- **spring-boot-starter-test**: Para pruebas unitarias e integradas.

### Lombok

- **lombok**: Para reducir el código repetitivo (getters, setters, constructores, etc.).

### Mockito

- **mockito-core**: Para crear mocks y aislar pruebas.
- **mockito-junit-jupiter**: Integración de Mockito con JUnit 5.

### Herramientas de Análisis

- **jacoco-maven-plugin**: Para medir la cobertura de las pruebas.
- **junit-jupiter**: Framework de pruebas unitarias.

## Cómo Correr el Proyecto

Para ejecutar el proyecto en tu máquina local, sigue estos pasos:

1. **Clonar el Repositorio**:

   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd RETO01-V2
   ```

2. **Ejecutar el Proyecto**:

   ```bash
   mvn spring-boot:run
   ```

   El proyecto estará disponible en `http://localhost:8080`.

3. **Probar los Endpoints**:
   Usa herramientas como Postman, Insomnia o cURL para interactuar con los siguientes endpoints:
   - **GET** `/api/estudiantes`: Lista todos los estudiantes.
   - **GET** `/api/estudiantes/filtrar?nombre={nombre}`: Filtra estudiantes por nombre.
   - **GET** `/api/estudiantes/filtrar-celular?numeroCelular={numero}`: Filtra estudiantes por número de celular.
   - **GET** `/api/estudiantes/ordenar-promedio`: Ordena estudiantes por promedio de notas.

## Cómo Correr las Pruebas

Este proyecto incluye pruebas unitarias e integradas para garantizar la funcionalidad correcta de todos los componentes.

1. **Ejecutar Todas las Pruebas**:

   ```bash
   mvn test
   ```

2. **Verificar la Cobertura de Pruebas**:
   - Ejecuta:

     ```bash
     mvn clean verify
     ```

   - Abre el archivo de reporte generado en `target/site/jacoco/index.html` para revisar la cobertura de las pruebas.

3. **Detalles de las Pruebas**:
   - Las pruebas están organizadas en los siguientes paquetes:
     - `model`: Pruebas para las clases de modelo (`Persona`, `Estudiante`, `Profesor`).
     - `service`: Pruebas para los servicios, como `ServiceEstudiante`.
     - `controller`: Pruebas de integración para los controladores REST.

## Autor

Este proyecto forma parte del taller **Master Microservices with Java & Spring Boot**.
