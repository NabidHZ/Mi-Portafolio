package biblioteca.models;

import java.util.Calendar;

/**
 * Classe abstracta per representar un producte de la biblioteca.
 */
public abstract class Producte implements Comparable<Producte>, Cloneable {
    protected String titol;
    protected Calendar dataPublicacio;
    protected boolean prestat;

    public Producte(String titol, Calendar dataPublicacio) {
        this.titol = titol;
        this.dataPublicacio = dataPublicacio;
        this.prestat = false;
    }

    public String getTitol() {
        return titol;
    }

    public Calendar getDataPublicacio() {
        return dataPublicacio;
    }

    public boolean isPrestat() {
        return prestat;
    }

    public abstract boolean prestar();
    public abstract boolean retornar();

    @Override
    public int compareTo(Producte other) {
        return this.titol.compareTo(other.titol);
    }

    @Override
    public Object clone() {
        try {
            Producte cloned = (Producte) super.clone();
            if(this.dataPublicacio != null){
                cloned.dataPublicacio = (Calendar) this.dataPublicacio.clone();
            }
            return cloned;
        } catch(CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Producte)) return false;
        Producte other = (Producte) obj;
        return this.titol.equals(other.titol);
    }

    @Override
    public String toString() {
        return "Títol: " + titol;
    }
}
