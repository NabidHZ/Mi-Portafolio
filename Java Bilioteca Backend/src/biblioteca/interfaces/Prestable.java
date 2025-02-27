package biblioteca.interfaces;

/**
 * Interfície que defineix mètodes per a productes prestables.
 */
public interface Prestable {
    /**
     * Presta un producte.
     * @return true si el producte s'ha prestat correctament, false en cas contrari.
     */
    boolean prestar();

    /**
     * Retorna un producte prestat.
     * @return true si el producte s'ha retornat correctament, false en cas contrari.
     */
    boolean retornar();
}
