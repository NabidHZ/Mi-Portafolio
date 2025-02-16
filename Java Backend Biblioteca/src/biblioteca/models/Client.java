package biblioteca.models;

import biblioteca.enums.TipusClient;

/**
 * Classe que representa un client de la biblioteca.
 */
public class Client extends Persona implements Comparable<Client>, Cloneable {
    private String email;
    private TipusClient tipus;

    public Client(String dni, String nom, String cognom, String email, TipusClient tipus) {
        super(dni, nom, cognom);
        this.email = email;
        this.tipus = tipus;
    }

    public String getEmail() {
        return email;
    }

    public TipusClient getTipus() {
        return tipus;
    }

    @Override
    public int compareTo(Client other) {
        return this.dni.compareTo(other.dni);
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch(CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Client)) return false;
        Client other = (Client) obj;
        return this.dni.equals(other.dni);
    }

    @Override
    public String toString() {
        return "Client: " + super.toString() + " - " + tipus.getDescripcio();
    }
}
