package biblioteca.models;

import java.util.Calendar;
import biblioteca.interfaces.Prestable;

/**
 * Classe que representa un llibre en paper.
 */
public class Llibre extends Producte implements Prestable {
    private String isbn;
    private String autor;
    private int fulles;
    private Calendar dataImpressio;

    public Llibre(String titol, Calendar dataPublicacio, String isbn, String autor, int fulles, Calendar dataImpressio) {
        super(titol, dataPublicacio);
        this.isbn = isbn;
        this.autor = autor;
        this.fulles = fulles;
        this.dataImpressio = dataImpressio;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAutor() {
        return autor;
    }

    public int getFulles() {
        return fulles;
    }

    public Calendar getDataImpressio() {
        return dataImpressio;
    }

    @Override
    public boolean prestar() {
        if(!prestat) {
            prestat = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean retornar() {
        if(prestat) {
            prestat = false;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Llibre: " + titol + ", Autor: " + autor;
    }
}
