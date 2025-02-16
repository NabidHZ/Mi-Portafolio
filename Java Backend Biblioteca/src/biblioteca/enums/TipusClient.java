package biblioteca.enums;

/**
 * Enum per definir el tipus de client.
 */
public enum TipusClient {
    PRIVAT("Client Privat"),
    ESCOLA_MUSIC("Escola de Música");

    private String descripcio;

    private TipusClient(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getDescripcio() {
        return descripcio;
    }
}
