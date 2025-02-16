package biblioteca.models;

/**
 * Classe que representa un treballador de la biblioteca.
 */
public class Treballador extends Persona {
    private String posicio;

    public Treballador(String dni, String nom, String cognom, String posicio) {
        super(dni, nom, cognom);
        this.posicio = posicio;
    }

    public String getPosicio() {
        return posicio;
    }

    @Override
    public String toString() {
        return "Treballador: " + super.toString() + " (" + posicio + ")";
    }
}
