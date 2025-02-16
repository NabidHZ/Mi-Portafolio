package biblioteca.models;

import java.util.Calendar;
import biblioteca.interfaces.Prestable;

/**
 * Classe que representa un disc de vinil.
 */
public class Vinil extends Producte implements Prestable {
    private String nomAlbum;
    private String artista;

    public Vinil(String titol, Calendar dataPublicacio, String nomAlbum, String artista) {
        super(titol, dataPublicacio);
        this.nomAlbum = nomAlbum;
        this.artista = artista;
    }

    public String getNomAlbum() {
        return nomAlbum;
    }

    public String getArtista() {
        return artista;
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
        return "Vinil: " + titol + ", Àlbum: " + nomAlbum + ", Artista: " + artista;
    }
}
