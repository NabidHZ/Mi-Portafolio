import { createServer } from 'http';
import { WebSocketServer } from 'ws';
import fetch from 'node-fetch';
import { readFile } from 'fs/promises';

// Servidor HTTP que sirve la página HTML
const server = createServer(async (req, res) => {
    try {
        let filePath = '';
        let contentType = '';

        if (req.url === '/' || req.url === '/index.html') {
            filePath = 'index.html';
            contentType = 'text/html';
        } else if (req.url === '/styles.css') {
            filePath = 'styles.css';
            contentType = 'text/css';
        } else if (req.url === '/script.js') {
            filePath = 'script.js';
            contentType = 'application/javascript';
        } else {
            res.writeHead(404);
            res.end('404 Not Found');
            return;
        }

        const content = await readFile(filePath, 'utf8');
        res.writeHead(200, { 'Content-Type': contentType });
        res.end(content);
    } catch (error) {
        res.writeHead(500);
        res.end('Error interno del servidor');
    }
});

// Servidor WebSocket
const wss = new WebSocketServer({ server });

wss.on('connection', ws => {
    console.log('Cliente conectado');

    ws.on('message', async message => {
        const { titulo, tipo } = JSON.parse(message);
        const apiKey = 'TU_API_KEY'; // Reemplaza con tu clave de OMDB
        const url = `https://www.omdbapi.com/?apikey=f9ff825d&s=${titulo}`;

        try {
            const response = await fetch(url);
            const data = await response.json();
            ws.send(JSON.stringify(data));
        } catch (error) {
            ws.send(JSON.stringify({ error: 'Error al obtener datos de OMDB' }));
        }
    });

    ws.on('close', () => {
        console.log('Cliente desconectado');
    });
});

server.listen(3000, () => {
    console.log('Servidor HTTP y WebSocket corriendo en http://localhost:3000');
});
