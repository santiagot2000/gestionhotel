# Documentación del Proyecto

---

## 📘 MANUAL DE USUARIO

### 1. Introducción

Bienvenido/a al sistema de **[Nombre de tu Aplicación]**. Este manual tiene como objetivo guiarte en el uso de la aplicación, explicando de manera sencilla cómo interactuar con las diferentes opciones y pantallas disponibles.

### 2. Acceso a la Aplicación

Para acceder al sistema, asegúrate de que el administrador haya iniciado el servidor.

1. Abre tu navegador web de preferencia (Google Chrome, Firefox, Edge, etc.).
2. En la barra de direcciones, ingresa la siguiente URL: `http://localhost:8080` *(o la ruta específica que te asigne el administrador)*.
3. Se mostrará la pantalla principal de la aplicación.

### 3. Navegación Principal

Al ingresar, encontrarás un menú de navegación que te permitirá acceder a las siguientes secciones principales:

* **Inicio:** Pantalla de bienvenida y resumen.
* **Gestión de [Entidad Principal, ej. Usuarios/Productos]:** Módulo para administrar los registros.
* **Ayuda:** Enlace a este manual.

### 4. Operaciones Básicas

El sistema te permite realizar las siguientes acciones comunes:

* **Ver registros:** Al entrar al módulo de [Entidad], verás una tabla o lista con toda la información guardada.
* **Crear (Nuevo):** Haz clic en el botón "Nuevo" o "Crear". Llena el formulario con los datos solicitados y presiona "Guardar".
* **Editar (Actualizar):** En la lista de registros, busca el elemento que deseas modificar y haz clic en el botón "Editar". Realiza los cambios en el formulario y presiona "Actualizar".
* **Eliminar:** En la lista de registros, selecciona el botón "Eliminar" junto al elemento correspondiente. El sistema te pedirá confirmación antes de borrarlo definitivamente.

*(Nota: Consulta la carpeta `/img/` del proyecto para ver las capturas de pantalla con ejemplos visuales de cada una de estas ventanas).*

---

## 🛠️ MANUAL TÉCNICO

### 1. Introducción y Arquitectura

Este documento describe los detalles técnicos, la arquitectura y los procedimientos de configuración para el proyecto **[Nombre de tu Aplicación]**.

El proyecto está desarrollado utilizando arquitectura basada en capas (Controlador, Servicio, Repositorio, Modelo) y construido sobre el framework **Spring Boot**.

**Stack Tecnológico:**

* **Lenguaje:** Java [Versión de Java, ej. 17]
* **Framework Principal:** Spring Boot
* **Persistencia de Datos:** Spring Data JPA
* **Base de Datos:** H2 (Base de datos en memoria)
* **Gestor de Dependencias:** Maven / Gradle
* **Pruebas:** JUnit / Spring Boot Test

### 2. Estructura del Proyecto

El código fuente sigue la estructura estándar de Spring Boot:

* `src/main/java/[paquete.base]/`:

* `controllers/`: Controladores REST/MVC que manejan las peticiones HTTP.
* `services/`: Lógica de negocio de la aplicación.
* `repositories/`: Interfaces de Spring Data JPA para la interacción con la BD.
* `models/` (o `entities/`): Clases que representan las tablas de la base de datos.
* `src/main/resources/`:
* `application.properties` (o `.yml`): Configuración de la aplicación (puerto, credenciales H2, propiedades JPA).
* `templates/` o `static/`: Archivos de interfaz de usuario (HTML, CSS, JS).
* `src/test/java/`: Pruebas automatizadas y unitarias.
* `img/`: Carpeta en la raíz que contiene las capturas de pantalla de evidencia.

### 3. Requisitos Previos (Instalación)

Para ejecutar el proyecto en un entorno local, el desarrollador debe tener instalado:

* Java Development Kit (JDK) 11 o superior.
* IDE compatible (IntelliJ IDEA, Eclipse, VS Code).
* Maven o Gradle (generalmente integrado en el IDE o a través del *wrapper* incluido en el proyecto).

### 4. Configuración de la Base de Datos (H2)

Al utilizar **H2** en memoria, no es necesaria una instalación externa de base de datos. La aplicación creará la base de datos automáticamente al arrancar.

Se puede acceder a la consola de H2 (si está habilitada) en:

* **URL:** `http://localhost:8080/h2-console`
* **JDBC URL:** `jdbc:h2:mem:testdb` *(Revisar application.properties para la URL exacta)*.

### 5. Ejecución del Proyecto

Para ejecutar la aplicación localmente:

1. Abre una terminal en la raíz del directorio del proyecto.
2. Ejecuta el siguiente comando (si usas Maven):

```bash
    ./mvnw spring-boot:run
    ```
    *(Si usas Gradle: `./gradlew bootRun`)*
3. Espera a que la consola muestre el mensaje `Started [NombreAplicacion]Application in X seconds`.
4. La aplicación estará disponible en `http://localhost:8080`.

### 6. Ejecución de Pruebas Automatizadas

El proyecto incluye un conjunto de pruebas para garantizar el correcto funcionamiento del sistema.
Para ejecutar las pruebas:

1. Abre una terminal en la raíz del proyecto.
2. Ejecuta el comando:

```bash
    ./mvnw test
    ```
*(Si usas Gradle: `./gradlew test`)*
3. Los resultados de los tests se imprimirán en la consola, indicando cuántas pruebas pasaron satisfactoriamente y si hubo algún fallo.