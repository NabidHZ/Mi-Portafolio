# Requerimientos Funcionales

## 1. Gestión de Películas
- Listar todas las películas almacenadas en la base de datos.
- Crear una nueva película proporcionando título, descripción, género y año.
- Editar una película existente seleccionándola por su ID.
- Eliminar una película existente seleccionándola por su ID.

## 2. Gestión de Usuarios
- Listar todos los usuarios almacenados en la base de datos MongoDB.
- Crear un nuevo usuario proporcionando nombre, email y rol.
- Editar un usuario existente seleccionándolo por su ID.
- Eliminar un usuario existente seleccionándolo por su ID.

## 3. Autenticación y Autorización
- Permitir el acceso público a las siguientes rutas:
    - `/` (Página de inicio).
    - `/login` (Página de inicio de sesión).
    - Archivos estáticos como CSS y JavaScript (`/css/**`, `/js/**`).
- Requerir autenticación para acceder a cualquier otra ruta.
- Implementar inicio de sesión mediante OAuth2 (Google).
- Redirigir al usuario autenticado al dashboard (`/dashboard`) tras un inicio de sesión exitoso.
- Permitir el cierre de sesión y redirigir al usuario a la página de inicio (`/`).

## 4. Dashboard
- Mostrar un panel principal tras autenticarse, con enlaces para:
    - Gestionar películas.
    - Gestionar usuarios.
    - Cerrar sesión.

## 5. Persistencia de Datos
- Almacenar las películas en una base de datos MySQL.
- Almacenar los usuarios en una base de datos MongoDB.

## 6. Interfaz de Usuario
- Proveer vistas HTML con Thymeleaf para las siguientes funcionalidades:
    - Página de inicio (`index.html`) con opción para iniciar sesión con Google.
    - Dashboard (`dashboard.html`) con enlaces a las secciones de gestión.
    - Listado de películas y usuarios.
    - Formularios para crear o editar películas y usuarios.

## 7. Configuración del Sistema
- Configurar el servidor para ejecutarse en el puerto `8080`.
- Configurar la conexión a MySQL para la gestión de películas.
- Configurar la conexión a MongoDB para la gestión de usuarios.
- Configurar las credenciales de OAuth2 para Google.