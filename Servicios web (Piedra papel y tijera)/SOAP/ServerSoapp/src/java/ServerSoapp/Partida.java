package ServerSoapp;

public class Partida {
    private String jugador1;
    private String jugador2;
    private String jugada1;
    private String jugada2;
    private String resultado;

    public Partida() {
        this.jugador1 = null;
        this.jugador2 = null;
        this.jugada1 = null;
        this.jugada2 = null;
        this.resultado = null;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    public void setJugada1(String jugada1) {
        this.jugada1 = jugada1;
    }

    public void setJugada2(String jugada2) {
        this.jugada2 = jugada2;
    }

    public String getJugador1() {
        return jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public String getResultado() {
        return resultado;
    }

    public String determinarGanador() {
        if (jugada1 == null || jugada2 == null) {
            return "Faltan jugadas para determinar el resultado.";
        }

        if (jugada1.equals(jugada2)) {
            resultado = "Empate";
        } else if (
            (jugada1.equals("piedra") && jugada2.equals("tijera")) ||
            (jugada1.equals("papel") && jugada2.equals("piedra")) ||
            (jugada1.equals("tijera") && jugada2.equals("papel"))
        ) {
            resultado = jugador1 + " gana";
        } else {
            resultado = jugador2 + " gana";
        }

        return resultado;
    }

    public void reiniciarPartida() {
        this.jugador1 = null;
        this.jugador2 = null;
        this.jugada1 = null;
        this.jugada2 = null;
        this.resultado = null;
    }
}
