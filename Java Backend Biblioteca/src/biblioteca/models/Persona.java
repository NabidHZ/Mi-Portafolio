package biblioteca.models;

/**
 * Classe abstracta que representa una persona.
 */
public abstract class Persona {
    protected String dni;
    protected String nom;
    protected String cognom;

    public Persona(String dni, String nom, String cognom) {
        this.dni = dni;
        this.nom = nom;
        this.cognom = cognom;
    }

    public String getDni() {
        return dni;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    @Override
    public String toString() {
        return nom + " " + cognom + " (" + dni + ")";
    }
}
