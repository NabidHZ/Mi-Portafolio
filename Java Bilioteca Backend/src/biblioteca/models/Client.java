package biblioteca.models;

import biblioteca.enums.TipusClient;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa un client de la biblioteca.
 */
public class Client extends Persona implements Comparable<Client>, Cloneable {
    private String email;
    private TipusClient tipus;
    private List<Producte> productesPrestats; // Lista para almacenar los productos prestados

    public Client(String dni, String nom, String cognom, String email, TipusClient tipus) {
        super(dni, nom, cognom);
        this.email = email;
        this.tipus = tipus;
        this.productesPrestats = new ArrayList<>(); // Inicializar la lista
    }

    public String getEmail() {
        return email;
    }

    public TipusClient getTipus() {
        return tipus;
    }

    // Método para agregar un producto prestado a la lista del cliente
    public boolean prestarProducte(Producte producte) {
        // Verificar si el producto ya está prestado
        if (producte != null && !productesPrestats.contains(producte) && producte.prestar()) {
            productesPrestats.add(producte);
            return true;
        }
        return false;
    }

    // Método para obtener la lista de productos prestados
    public List<Producte> getProductesPrestats() {
        return productesPrestats;
    }

    // Nuevo método para mostrar los productos prestados
    public void mostrarProductesPrestats() {
        if (productesPrestats.isEmpty()) {
            System.out.println("No hi ha productes prestats.");
        } else {
            System.out.println("Productes prestats per " + this.toString() + ":");
            for (Producte p : productesPrestats) {
                System.out.println(p);
            }
        }
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
