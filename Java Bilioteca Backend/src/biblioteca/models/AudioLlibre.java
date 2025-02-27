package biblioteca.models;

import java.util.Calendar;
import biblioteca.interfaces.Prestable;
import biblioteca.interfaces.Reservable;

/**
 * Classe que representa un audiollibre.
 */
public class AudioLlibre extends Producte implements Prestable, Reservable {
    private String isbn;
    private String autor;
    private WebSupplier supplier;

    public AudioLlibre(String titol, Calendar dataPublicacio, String isbn, String autor, WebSupplier supplier) {
        super(titol, dataPublicacio);
        this.isbn = isbn;
        this.autor = autor;
        this.supplier = supplier;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAutor() {
        return autor;
    }

    public WebSupplier getSupplier() {
        return supplier;
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
    public void reservar() {
        System.out.println("Audiollibre reservat.");
    }

    @Override
    public String toString() {
        return "AudioLlibre: " + titol + ", Autor: " + autor + ", Proveït per: " + supplier.getNomWeb();
    }
}
