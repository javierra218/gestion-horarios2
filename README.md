# Gestión de Horarios - Universidad del Cauca

Este proyecto es una API REST para la **gestión de horarios** de cursos, profesores y espacios físicos en la Universidad del Cauca, construida usando **Spring Boot**. El sistema permite gestionar franjas horarias, asignar cursos a profesores, reservar espacios físicos y controlar los periodos académicos.

## Tabla de Contenidos

1. [Descripción](#descripción)
2. [Características](#características)
3. [Tecnologías Utilizadas](#tecnologías-utilizadas)
4. [Requisitos Previos](#requisitos-previos)
5. [Configuración del Proyecto](#configuración-del-proyecto)
6. [Pruebas con Postman](#pruebas-con-postman)
7. [Patrones de Diseño Aplicados](#patrones-de-diseño-aplicados)

## Descripción

La API permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre las franjas horarias asignadas a los cursos en la universidad. Las entidades principales son `Curso`, `Profesor`, `EspacioFisico`, `PeriodoAcademico`, y `FranjaHoraria`.

## Características

- Gestión de franjas horarias para cursos.
- Validación de solapamientos de franjas horarias.
- Relación entre cursos, profesores, espacios físicos y periodos académicos.
- Operaciones CRUD para todas las entidades.
- Transferencia de datos mediante **DTOs**.
- Pruebas de API utilizando **Postman** o **Thunder Client**.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL** como base de datos
- **Postman** o **Thunder Client** para pruebas de API
- **Maven** para la gestión de dependencias

## Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener lo siguiente instalado en tu máquina:

- **Java 17** o superior
- **MySQL** (o Docker con MySQL)
- **Maven** (si no está integrado en tu IDE)
- **Postman** o **Thunder Client** (para pruebas de API)

## Configuración del Proyecto

### 1. Clonar el Repositorio

```bash
git clone https://github.com/tu-usuario/gestion-horarios.git
cd gestion-horarios
