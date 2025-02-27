package biblioteca.models;

import biblioteca.enums.TipusClient;

/**
 * Classe que representa una escola de música.
 */
public class ClientEscolaMusica extends Client {
    public ClientEscolaMusica(String dni, String nom, String cognom, String email) {
        super(dni, nom, cognom, email, TipusClient.ESCOLA_MUSIC);
    }
}
