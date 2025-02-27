package ServerSoapp;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService(serviceName = "ServerSoapp")
public class ServerSoapp {
    private final Partida partida;

    public ServerSoapp() {
        this.partida = new Partida();
    }

    @WebMethod
    public String iniciarPartida() {
        partida.reiniciarPartida();
        return "Nueva partida iniciada. ¡Esperando a los jugadores!";
    }

    @WebMethod
    public String registrarJugada(String jugador, String jugada) {
        if (!jugada.equals("piedra") && !jugada.equals("papel") && !jugada.equals("tijera")) {
            return "Error: La jugada debe ser 'piedra', 'papel' o 'tijera'.";
        }

        if (partida.getResultado() != null) {
            return "La partida ya terminó. Reinicia para comenzar una nueva.";
        }

        if (partida.getJugador1() == null) {
            partida.setJugador1(jugador);
            partida.setJugada1(jugada);
            return jugador + " ha hecho su jugada. Esperando al otro jugador.";
        } else if (partida.getJugador2() == null) {
            partida.setJugador2(jugador);
            partida.setJugada2(jugada);

            // Ya tenemos las dos jugadas, determinamos el ganador
            return "Jugada registrada para " + jugador + ". Resultado: " + partida.determinarGanador();
        }

        return "Ambos jugadores ya han hecho sus jugadas. Resultado: " + partida.getResultado();
    }

    @WebMethod
    public String obtenerResultado() {
        if (partida.getResultado() == null) {
            return "La partida aún no ha terminado. Esperando a que ambos jugadores realicen sus jugadas.";
        }
        return "El resultado de la partida es: " + partida.getResultado();
    }

    @WebMethod
    public String reiniciarPartida() {
        partida.reiniciarPartida();
        return "La partida ha sido reiniciada. ¡Esperando a los jugadores!";
    }
}
