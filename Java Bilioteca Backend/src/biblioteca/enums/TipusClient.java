package biblioteca.enums;

/**
 * Enum per definir el tipus de client.
 */
public enum TipusClient {
    /** Client privat. */
    PRIVAT("Client Privat"),

    /** Escola de música. */
    ESCOLA_MUSIC("Escola de Música");

    /** Descripció del tipus de client. */
    private String descripcio;

    /**
     * Constructor del tipus de client.
     * @param descripcio La descripció del tipus de client.
     */
    private TipusClient(String descripcio) {
        this.descripcio = descripcio;
    }

    /**
     * Obté la descripció del tipus de client.
     * @return La descripció del tipus de client.
     */
    public String getDescripcio() {
        return descripcio;
    }
}
