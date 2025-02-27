package biblioteca.models;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Client> clients;
    private List<Producte> productes;
    private List<Prestamo> prestamos;

    public Biblioteca() {
        this.clients = new ArrayList<>();
        this.productes = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public void afegirClient(Client client) {
        clients.add(client);
    }

    public void afegirProducte(Producte producte) {
        productes.add(producte);
    }

    public void afegirTreballador(Treballador treballador) {
        // Añadir trabajador a la lista de trabajadores
    }

    public void mostrarClients() {
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    public void mostrarProductes() {
        for (Producte producte : productes) {
            System.out.println(producte);
        }
    }

    public void mostrarTreballadors() {
        // Mostrar trabajadores
    }

    public Client cercarClientPerDNI(String dni) {
        for (Client client : clients) {
            if (client.getDni().equals(dni)) {
                return client;
            }
        }
        return null;
    }

    public boolean eliminarClient(String dni) {
        Client client = cercarClientPerDNI(dni);
        if (client != null) {
            clients.remove(client);
            return true;
        }
        return false;
    }

    public boolean eliminarLlibre(String titol) {
        for (Producte p : productes) {
            if (p instanceof Llibre && p.getTitol().equals(titol)) {
                productes.remove(p);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarVinil(String titol) {
        for (Producte p : productes) {
            if (p instanceof Vinil && p.getTitol().equals(titol)) {
                productes.remove(p);
                return true;
            }
        }
        return false;
    }

    // Método para prestar productos a clientes
    public boolean prestarProducteAlClient(String dni, String titolProducte) {
        Client client = cercarClientPerDNI(dni);
        if (client != null) {
            for (Producte p : productes) {
                if (p.getTitol().equalsIgnoreCase(titolProducte) && p.prestar()) {
                    Prestamo prestamo = new Prestamo(client, p);
                    prestamos.add(prestamo);
                    System.out.println("Producte prestat a " + client.getNom());
                    return true;
                }
            }
        }
        System.out.println("No es pot prestar el producte.");
        return false;
    }

    // Método para retornar productos
    public boolean retornarProducte(String titolProducte) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getProducte().getTitol().equalsIgnoreCase(titolProducte)) {
                if (prestamo.getProducte().retornar()) {
                    prestamos.remove(prestamo);
                    System.out.println("Producte retornat correctament.");
                    return true;
                }
            }
        }
        System.out.println("El producte no estava prestat o no existeix.");
        return false;
    }

    public List<Producte> getProductes() {
        return productes;
    }

    // Nueva clase Prestamo
    private class Prestamo {
        private Client client;
        private Producte producte;

        public Prestamo(Client client, Producte producte) {
            this.client = client;
            this.producte = producte;
        }

        public Client getClient() {
            return client;
        }

        public Producte getProducte() {
            return producte;
        }
    }
}
