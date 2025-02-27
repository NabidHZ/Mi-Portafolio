package biblioteca.models;

/**
 * Classe que representa la web proveïdora d'audiollibres.
 */
public class WebSupplier {
    private String nomWeb;
    private String nomEmpresa;
    private String idRegistre;
    private String domiciliSocial;
    private String telefon;

    public WebSupplier(String nomWeb, String nomEmpresa, String idRegistre, String domiciliSocial, String telefon) {
        this.nomWeb = nomWeb;
        this.nomEmpresa = nomEmpresa;
        this.idRegistre = idRegistre;
        this.domiciliSocial = domiciliSocial;
        this.telefon = telefon;
    }

    public String getNomWeb() {
        return nomWeb;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public String getIdRegistre() {
        return idRegistre;
    }

    public String getDomiciliSocial() {
        return domiciliSocial;
    }

    public String getTelefon() {
        return telefon;
    }
}
