# ClotFilms

ClotFilms es una aplicación web desarrollada con **Spring Boot**, **Thymeleaf**, **Maven**, y **Spring Security**. Su propósito es gestionar películas y usuarios, proporcionando una interfaz intuitiva para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre ambas entidades. Además, incluye autenticación mediante **OAuth2** con Google y un sistema de roles para gestionar permisos.

## Características principales

1. **Gestión de Películas**:
   - Listado de películas con detalles como título, descripción, género y año.
   - Creación de nuevas películas.
   - Edición de películas existentes.
   - Eliminación de películas.

2. **Gestión de Usuarios**:
   - Listado de usuarios con detalles como nombre, email y rol.
   - Creación de nuevos usuarios.
   - Edición de usuarios existentes.
   - Eliminación de usuarios.

3. **Autenticación y Seguridad**:
   - Inicio de sesión mediante **OAuth2** con Google.
   - Sistema de cierre de sesión.
   - Control de acceso a rutas según autenticación.

4. **Interfaz de Usuario**:
   - Diseño responsivo y estilizado con un archivo CSS centralizado.
   - Navegación intuitiva entre las diferentes secciones de la aplicación.

5. **Persistencia de Datos**:
   - **Películas**: Almacenadas en una base de datos relacional utilizando **JPA**.
   - **Usuarios**: Almacenados en una base de datos **MongoDB**.

---

## Estructura del Proyecto

### 1. **Controladores**
Los controladores gestionan las solicitudes HTTP y conectan las vistas con los servicios.

- `HomeController`: Controla las rutas principales (`/` e `/dashboard`).
- `PeliculaController`: Gestiona las operaciones relacionadas con las películas.
- `UsuarioController`: Gestiona las operaciones relacionadas con los usuarios.

### 2. **Modelos**
Definen las entidades del dominio.

- `Pelicula`: Representa una película con atributos como título, descripción, género y año.
- `Usuario`: Representa un usuario con atributos como nombre, email y rol.

### 3. **Repositorios**
Proveen acceso a las bases de datos.

- `PeliculaRepository`: Extiende `JpaRepository` para gestionar películas en una base de datos relacional.
- `UsuarioRepository`: Extiende `MongoRepository` para gestionar usuarios en MongoDB.

### 4. **Servicios**
Contienen la lógica de negocio.

- `PeliculaService`: Proporciona métodos para listar, guardar, obtener y eliminar películas.
- `UsuarioService`: Proporciona métodos para listar, guardar, obtener y eliminar usuarios.

### 5. **Configuración**
- `SecurityConfig`: Configura la seguridad de la aplicación, incluyendo las reglas de autorización y la integración con OAuth2.

### 6. **Vistas**
Las vistas están desarrolladas con **Thymeleaf** y se encuentran en la carpeta `src/main/resources/templates`.

- `index.html`: Página de inicio.
- `dashboard.html`: Página principal tras autenticarse.
- `peliculas/listado.html`: Listado de películas.
- `peliculas/formulario.html`: Formulario para crear o editar películas.
- `usuarios/listado.html`: Listado de usuarios.
- `usuarios/formulario.html`: Formulario para crear o editar usuarios.

### 7. **Recursos Estáticos**
- `style.css`: Archivo CSS ubicado en `src/main/resources/static/css` que define los estilos de la aplicación.

---

## Configuración de Seguridad

La seguridad está configurada en la clase `SecurityConfig`. Las principales características son:

- **Rutas públicas**: Las rutas `/`, `/login`, `/css/**` y `/js/**` son accesibles sin autenticación.
- **Autenticación OAuth2**: Los usuarios pueden iniciar sesión con Google.
- **Cierre de sesión**: Redirige a la página de inicio tras cerrar sesión.

---

## Configuración del Proyecto

### Requisitos previos
- **Java 17** o superior.
- **Maven**.
- **MongoDB** y una base de datos relacional compatible con JPA (por ejemplo, MySQL o H2).

### Pasos para ejecutar el proyecto

1. Clona el repositorio:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd ClotFilms
   ```

2. Configura las propiedades de la base de datos en `src/main/resources/application.properties`:
   ```properties
   # Configuración de la base de datos relacional
   spring.datasource.url=jdbc:mysql://localhost:3306/clotfilms
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña

   # Configuración de MongoDB
   spring.data.mongodb.uri=mongodb://localhost:27017/clotfilms

   # Configuración de OAuth2
   spring.security.oauth2.client.registration.google.client-id=tu_client_id
   spring.security.oauth2.client.registration.google.client-secret=tu_client_secret
   ```

3. Ejecuta el proyecto:
   ```bash
   mvn spring-boot:run
   ```

4. Accede a la aplicación en [http://localhost:8080](http://localhost:8080).

---

## Tecnologías Utilizadas

- **Spring Boot**: Framework principal para el desarrollo de la aplicación.
- **Thymeleaf**: Motor de plantillas para las vistas.
- **Spring Security**: Gestión de autenticación y autorización.
- **OAuth2**: Integración con Google para el inicio de sesión.
- **JPA**: Persistencia de datos relacionales.
- **MongoDB**: Persistencia de datos no relacionales.
- **Maven**: Gestión de dependencias y construcción del proyecto.

---

## Capturas de Pantalla

1. **Página de Inicio**:
   - Bienvenida al usuario con opción de iniciar sesión.

2. **Dashboard**:
   - Navegación hacia la gestión de películas y usuarios.

3. **Gestión de Películas**:
   - Listado, creación, edición y eliminación de películas.

4. **Gestión de Usuarios**:
   - Listado, creación, edición y eliminación de usuarios.

---

## Autor

Este proyecto fue desarrollado por **Nahaza2425** como parte de su portafolio profesional.