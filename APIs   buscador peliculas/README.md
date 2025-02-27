@Autor: Nabid Hassan

# Proyecto OMDB - Películas

Este proyecto permite buscar películas usando la API de OMDB (https://www.omdbapi.com) implementando tres tecnologías: `XHR`, `fetch` y `WebSockets`.

## Tecnologías utilizadas

1. **XHR (XMLHttpRequest)**
   - Realiza solicitudes a la API de OMDB de forma asíncrona para obtener información sobre las películas.

2. **Fetch API**
   - Utiliza `fetch` para realizar solicitudes a la API, utilizando promesas para manejar las respuestas de forma más sencilla.

3. **WebSockets**
   - Usa WebSockets para establecer una comunicación bidireccional entre el cliente y el servidor, con un servidor proxy que realiza las solicitudes a OMDB.

## Requisitos

- Node.js y npm instalados.
- Clave de API de OMDB (obténla en [OMDB API](https://www.omdbapi.com)).

## Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/Nahaza2425
   cd omdb-project
