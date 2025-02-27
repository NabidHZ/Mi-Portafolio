package biblioteca.main;

import biblioteca.models.*;
import biblioteca.enums.TipusClient;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe principal per executar l'aplicació.
 */
public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        // Creació de clients amb tipus ClientPrivat i ClientEscolaMusica
        Client c1 = new ClientPrivat("12345678A", "Joan", "Garcia", "joan@example.com");
        Client c2 = new ClientEscolaMusica("87654321B", "Escola", "Música", "escola@example.com");
        biblioteca.afegirClient(c1);
        biblioteca.afegirClient(c2);

        // Creació de productes
        Calendar dataPublicacio = new GregorianCalendar(2000, Calendar.JANUARY, 1);
        Calendar dataImpressio = new GregorianCalendar(2001, Calendar.FEBRUARY, 1);

        Llibre llibre = new Llibre("El Quixot", dataPublicacio, "ISBN123456", "Cervantes", 500, dataImpressio);
        WebSupplier supplier = new WebSupplier("AudiobookWeb", "Audiobooks S.L.", "REG1234", "C/ Exemple, 1", "123456789");
        AudioLlibre audioLlibre = new AudioLlibre("El Quixot (Audio)", dataPublicacio, "ISBN123456", "Cervantes", supplier);
        Vinil vinil = new Vinil("Simfonies Clàssiques", dataPublicacio, "Simfonia n.5", "Beethoven");

        biblioteca.afegirProducte(llibre);
        biblioteca.afegirProducte(audioLlibre);
        biblioteca.afegirProducte(vinil);

        // Creació de treballador
        Treballador t1 = new Treballador("11111111X", "Anna", "Pérez", "Bibliotecària");
        biblioteca.afegirTreballador(t1);

        int opcio = 0;  // Inicialitzem opcio en 0

        do {
            System.out.println("----- Menú Biblioteca -----");
            System.out.println("1. Afegir client");
            System.out.println("2. Mostrar clients");
            System.out.println("3. Afegir llibre");
            System.out.println("4. Afegir audiollibre");
            System.out.println("5. Afegir vinil");
            System.out.println("6. Mostrar productes");
            System.out.println("7. Mostrar treballadors");
            System.out.println("8. Cercar client per DNI i veure productes prestats");
            System.out.println("9. Prestar producte a un client");
            System.out.println("10. Retornar producte");
            System.out.println("11. Eliminar client");
            System.out.println("12. Eliminar llibre");
            System.out.println("13. Eliminar vinil");
            System.out.println("14. Sortir");
            System.out.print("Escull una opció: ");

            try {
                opcio = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no vàlida.");
                continue;
            }

            switch (opcio) {
                case 1:
                    // Afegir client amb tipus
                    System.out.print("Introdueix DNI: ");
                    String dni = scanner.nextLine();
                    System.out.print("Introdueix nom: ");
                    String nom = scanner.nextLine();
                    System.out.print("Introdueix cognom: ");
                    String cognom = scanner.nextLine();
                    System.out.print("Introdueix email: ");
                    String email = scanner.nextLine();
                    System.out.print("Tipus (1- Privat, 2- Escola de Música): ");
                    int tipus = Integer.parseInt(scanner.nextLine());
                    if (tipus == 1) {
                        biblioteca.afegirClient(new ClientPrivat(dni, nom, cognom, email));
                    } else {
                        biblioteca.afegirClient(new ClientEscolaMusica(dni, nom, cognom, email));
                    }
                    break;
                case 2:
                    biblioteca.mostrarClients();
                    break;
                case 3:
                    // Afegir llibre
                    System.out.print("Introdueix títol: ");
                    String titol = scanner.nextLine();
                    System.out.print("Introdueix ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Introdueix autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Introdueix número de fulles: ");
                    int fulles = Integer.parseInt(scanner.nextLine());
                    Calendar pub = new GregorianCalendar();
                    Calendar imp = new GregorianCalendar();
                    biblioteca.afegirProducte(new Llibre(titol, pub, isbn, autor, fulles, imp));
                    break;
                case 4:
                    // Afegir audiollibre
                    System.out.print("Introdueix títol: ");
                    titol = scanner.nextLine();
                    System.out.print("Introdueix ISBN: ");
                    isbn = scanner.nextLine();
                    System.out.print("Introdueix autor: ");
                    autor = scanner.nextLine();
                    pub = new GregorianCalendar();
                    System.out.println("Introdueix dades del supplier");
                    System.out.print("Nom de la web: ");
                    String nomWeb = scanner.nextLine();
                    System.out.print("Nom de l'empresa: ");
                    String nomEmpresa = scanner.nextLine();
                    System.out.print("ID registre: ");
                    String idRegistre = scanner.nextLine();
                    System.out.print("Domicili social: ");
                    String domicili = scanner.nextLine();
                    System.out.print("Telèfon: ");
                    String telefon = scanner.nextLine();
                    WebSupplier ws = new WebSupplier(nomWeb, nomEmpresa, idRegistre, domicili, telefon);
                    biblioteca.afegirProducte(new AudioLlibre(titol, pub, isbn, autor, ws));
                    break;
                case 5:
                    // Afegir vinil
                    System.out.print("Introdueix títol: ");
                    titol = scanner.nextLine();
                    System.out.print("Introdueix nom d'àlbum: ");
                    String nomAlbum = scanner.nextLine();
                    System.out.print("Introdueix artista: ");
                    String artista = scanner.nextLine();
                    pub = new GregorianCalendar();
                    biblioteca.afegirProducte(new Vinil(titol, pub, nomAlbum, artista));
                    break;
                case 6:
                    biblioteca.mostrarProductes();
                    break;
                case 7:
                    biblioteca.mostrarTreballadors();
                    break;
                case 8:
                    // Cercar client per DNI i, si trobat, mostrar els productes prestats
                    System.out.print("Introdueix DNI per cercar: ");
                    String searchDNI = scanner.nextLine();
                    Client found = biblioteca.cercarClientPerDNI(searchDNI);
                    if (found != null) {
                        System.out.println("Client trobat: " + found);
                        System.out.print("Vols veure els productes prestats d'aquest client? (S/N): ");
                        String resp = scanner.nextLine();
                        if (resp.equalsIgnoreCase("S")) {
                            found.mostrarProductesPrestats();
                        }
                    } else {
                        System.out.println("Client no trobat.");
                    }
                    break;
                case 9:
                    // Prestar producte a un client
                    System.out.print("Introdueix el DNI del client: ");
                    String dniClient = scanner.nextLine();
                    Client client = biblioteca.cercarClientPerDNI(dniClient);
                    if (client == null) {
                        System.out.println("Client no trobat.");
                        break;
                    }
                    biblioteca.mostrarProductes();
                    System.out.print("Introdueix el títol del producte a prestar: ");
                    String t = scanner.nextLine();
                    Producte producteToPrestar = null;
                    for (Producte p : biblioteca.getProductes()) {
                        if (p.getTitol().equalsIgnoreCase(t)) {
                            producteToPrestar = p;
                            break;
                        }
                    }
                    if (producteToPrestar != null) {
                        if (client.prestarProducte(producteToPrestar)) {
                            System.out.println("Producte prestat correctament al client " + client.getNom());
                        } else {
                            System.out.println("El producte ja està prestat o no es pot prestar.");
                        }
                    } else {
                        System.out.println("Producte no trobat.");
                    }
                    break;
                case 10:
                    // Retornar producte
                    System.out.println("Retornar producte");
                    biblioteca.mostrarProductes();
                    System.out.print("Introdueix el títol del producte a retornar: ");
                    t = scanner.nextLine();
                    Producte producteToRetornar = null;
                    for (Producte p : biblioteca.getProductes()) {
                        if (p.getTitol().equalsIgnoreCase(t)) {
                            producteToRetornar = p;
                            break;
                        }
                    }
                    if (producteToRetornar != null) {
                        if (producteToRetornar.retornar()) {
                            System.out.println("Producte retornat correctament.");
                        } else {
                            System.out.println("El producte no estava prestat.");
                        }
                    } else {
                        System.out.println("Producte no trobat.");
                    }
                    break;
                case 11:
                    // Eliminar client
                    System.out.print("Introdueix el DNI del client a eliminar: ");
                    String dniElim = scanner.nextLine();
                    if(biblioteca.eliminarClient(dniElim)){
                        System.out.println("Client eliminat correctament.");
                    } else {
                        System.out.println("No s'ha trobat el client.");
                    }
                    break;
                case 12:
                    // Eliminar llibre
                    System.out.print("Introdueix el títol del llibre a eliminar: ");
                    String titolLlibre = scanner.nextLine();
                    if(biblioteca.eliminarLlibre(titolLlibre)){
                        System.out.println("Llibre eliminat correctament.");
                    } else {
                        System.out.println("No s'ha trobat el llibre.");
                    }
                    break;
                case 13:
                    // Eliminar vinil
                    System.out.print("Introdueix el títol del vinil a eliminar: ");
                    String titolVinil = scanner.nextLine();
                    if(biblioteca.eliminarVinil(titolVinil)){
                        System.out.println("Vinil eliminat correctament.");
                    } else {
                        System.out.println("No s'ha trobat el vinil.");
                    }
                    break;
                case 14:
                    System.out.println("Sortint...");
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }
        } while (opcio != 14);

        scanner.close();
    }
}
