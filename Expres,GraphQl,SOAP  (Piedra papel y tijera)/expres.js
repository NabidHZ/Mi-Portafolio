const express = require('express'); // Importa el framework Express.
const app = express(); // Crea la aplicación Express.

app.use(express.json()); // Middleware para procesar datos en formato JSON.

let jugadas = []; // Array para almacenar las jugadas de los jugadores (máximo dos).

// Ruta principal
app.get('/', (req, res) => res.send('Juego de Piedra, Papel o Tijera'));

// Ruta para que un jugador haga su jugada
app.post('/jugar', (req, res) => {
    const { jugador, jugada } = req.body; // Obtiene el nombre del jugador y su jugada.

    // Validación de entrada
    if (!jugador || !jugada) {
        return res.status(400).send('Se requiere un nombre de jugador y una jugada (piedra, papel o tijera).');
    }

    if (!['piedra', 'papel', 'tijera'].includes(jugada.toLowerCase())) {
        return res.status(400).send('La jugada debe ser "piedra", "papel" o "tijera".');
    }

    // Almacena la jugada del jugador
    jugadas.push({ jugador, jugada: jugada.toLowerCase() });

    // Si ya hay dos jugadas, determina el ganador
    if (jugadas.length === 2) {
        const resultado = determinarGanador(jugadas[0], jugadas[1]);
        const partida = { jugador1: jugadas[0], jugador2: jugadas[1], resultado };
        jugadas = []; // Reinicia las jugadas para la siguiente partida.
        return res.send(partida);
    }

    res.send(`Jugada recibida de ${jugador}. Esperando al otro jugador.`);
});

// Función para determinar el ganador
function determinarGanador(jugada1, jugada2) {
    const { jugador: jugador1, jugada: opcion1 } = jugada1;
    const { jugador: jugador2, jugada: opcion2 } = jugada2;

    if (opcion1 === opcion2) return 'Empate';

    if (
        (opcion1 === 'piedra' && opcion2 === 'tijera') ||
        (opcion1 === 'papel' && opcion2 === 'piedra') ||
        (opcion1 === 'tijera' && opcion2 === 'papel')
    ) {
        return `${jugador1} gana`;
    }

    return `${jugador2} gana`;
}

// Inicia el servidor en el puerto 3000
app.listen(3000, () => console.log('Servidor iniciado en http://localhost:3000'));
