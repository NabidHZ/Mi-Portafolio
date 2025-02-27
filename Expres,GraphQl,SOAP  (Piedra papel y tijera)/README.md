@Autor : Nabid Hassan

# Juego de Piedra, Papel o Tijera con SOAP, XHR y Express

Este proyecto implementa un juego básico de **Piedra, Papel o Tijera** utilizando **Express** como servidor backend y **XMLHttpRequest (XHR)** para la comunicación entre el cliente y el servidor. El juego permite a dos jugadores hacer sus jugadas desde diferentes dispositivos, con el servidor procesando las jugadas y determinando al ganador.

## Descripción

El juego permite a dos jugadores realizar sus jugadas (Piedra, Papel o Tijera) a través de una interfaz web. El servidor en **Express** recibe las jugadas mediante peticiones HTTP y determina el ganador según las reglas del juego.

### Reglas del Juego:
1. Piedra vence a Tijera.
2. Tijera vence a Papel.
3. Papel vence a Piedra.
4. Si ambos jugadores eligen la misma jugada, el resultado es un empate.

## Estructura del Proyecto

El proyecto se divide en dos partes:
1. **Backend (Servidor en Express):** Maneja las solicitudes de las jugadas, valida las entradas y determina al ganador.
2. **Frontend (Cliente):** Una página HTML que utiliza JavaScript (con XHR) para enviar las jugadas al servidor y mostrar los resultados.

### Archivos principales:
- **server.js:** Archivo principal del servidor, que utiliza Express para gestionar las peticiones y calcular el resultado.
- **index.html:** Página web que proporciona una interfaz para que los jugadores realicen sus jugadas.
- **script.js:** Archivo de JavaScript que utiliza XHR para enviar las jugadas al servidor y recibir el resultado.

## Instalación

### Requisitos:
- **Node.js** (versión 12 o superior)
