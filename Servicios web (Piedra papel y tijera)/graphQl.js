const express = require('express'); // Importa Express.
const { graphqlHTTP } = require('express-graphql'); // Importa el middleware de GraphQL.
const { GraphQLObjectType, GraphQLSchema, GraphQLString } = require('graphql'); // Importa las clases necesarias para crear el esquema de GraphQL.

const app = express(); // Crea la aplicación Express.

let jugadas = []; // Array para almacenar las jugadas de los jugadores (máximo dos).

// Definición del esquema GraphQL.
const JugadaType = new GraphQLObjectType({
  name: 'Jugada',
  fields: () => ({
    jugador: { type: GraphQLString },
    jugada: { type: GraphQLString },
  }),
});

const ResultadoType = new GraphQLObjectType({
  name: 'Resultado',
  fields: () => ({
    jugador1: { type: JugadaType },
    jugador2: { type: JugadaType },
    resultado: { type: GraphQLString },
  }),
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

// Definición de las consultas GraphQL.
const RootQueryType = new GraphQLObjectType({
  name: 'RootQueryType',
  fields: {
    jugar: {
      type: ResultadoType,
      args: {
        jugador: { type: GraphQLString },
        jugada: { type: GraphQLString },
      },
      resolve(parent, args) {
        const { jugador, jugada } = args;

        // Validación de entrada
        if (!jugador || !jugada) {
          throw new Error('Se requiere un nombre de jugador y una jugada (piedra, papel o tijera).');
        }

        if (!['piedra', 'papel', 'tijera'].includes(jugada.toLowerCase())) {
          throw new Error('La jugada debe ser "piedra", "papel" o "tijera".');
        }

        // Almacena la jugada del jugador
        jugadas.push({ jugador, jugada: jugada.toLowerCase() });

        // Si ya hay dos jugadas, determina el ganador
        if (jugadas.length === 2) {
          const resultado = determinarGanador(jugadas[0], jugadas[1]);
          const partida = { jugador1: jugadas[0], jugador2: jugadas[1], resultado };
          jugadas = []; // Reinicia las jugadas para la siguiente partida.
          return partida;
        }

        return { jugador1: jugadas[0], jugador2: null, resultado: 'Esperando al otro jugador.' };
      },
    },
  },
});

// Crear el esquema GraphQL
const schema = new GraphQLSchema({
  query: RootQueryType, // Usamos el tipo "query" para manejar las jugadas
});

// Usar GraphQL en la ruta '/graphql'
app.use(
  '/graphql',
  graphqlHTTP({
    schema,
    graphiql: true, // Habilita la interfaz gráfica de GraphiQL para probar consultas.
  })
);

// Inicia el servidor en el puerto 3000
app.listen(3000, () => console.log('Servidor GraphQL iniciado en http://localhost:3000/graphql'));
