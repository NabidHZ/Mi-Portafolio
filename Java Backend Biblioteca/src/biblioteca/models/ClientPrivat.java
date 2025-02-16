package biblioteca.models;

import biblioteca.enums.TipusClient;

/**
 * Classe que representa un client privat.
 */
public class ClientPrivat extends Client {
    public ClientPrivat(String dni, String nom, String cognom, String email) {
        super(dni, nom, cognom, email, TipusClient.PRIVAT);
    }
}
