package biblioteca.models;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe que gestiona la biblioteca.
 */
public class Biblioteca {
    private ArrayList<Client> clients;
    private ArrayList<Producte> productes;
    private ArrayList<Treballador> treballadors;

    private static final int MAX_TREBALLADORS = 10;
    private Treballador[] treballadorArray;
    private int indexTreballadors;

    public Biblioteca() {
        clients = new ArrayList<>();
        productes = new ArrayList<>();
        treballadors = new ArrayList<>();
        treballadorArray = new Treballador[MAX_TREBALLADORS];
        indexTreballadors = 0;
    }

    public void afegirClient(Client client) {
        clients.add(client);
    }

    public void afegirProducte(Producte producte) {
        productes.add(producte);
    }

    public void afegirTreballador(Treballador treballador) {
        if(indexTreballadors < MAX_TREBALLADORS) {
            treballadorArray[indexTreballadors++] = treballador;
            treballadors.add(treballador);
        } else {
            System.out.println("No es poden afegir més treballadors.");
        }
    }

    public void mostrarClients() {
        Iterator<Client> it = clients.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public void mostrarProductes() {
        for(Producte p : productes) {
            System.out.println(p);
        }
    }

    public void mostrarTreballadors() {
        for(int i = 0; i < indexTreballadors; i++){
            System.out.println(treballadorArray[i]);
        }
    }

    public Client cercarClientPerDNI(String dni) {
        for(Client c : clients) {
            if(c.getDni().equalsIgnoreCase(dni)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Producte> getProductes() {
        return productes;
    }
}
