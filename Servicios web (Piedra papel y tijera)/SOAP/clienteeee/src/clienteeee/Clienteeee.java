package clienteeee;

import java.util.Scanner;

/**
 *
 * @author miste
 */
public class Clienteeee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Iniciar Partida");
            System.out.println("2. Registrar Jugada");
            System.out.println("3. Obtener Resultado");
            System.out.println("4. Reiniciar Partida");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println(iniciarPartida());
                    break;
                case 2:
                    System.out.print("Ingrese el jugador: ");
                    String jugador = scanner.nextLine();
                    System.out.print("Ingrese la jugada: ");
                    String jugada = scanner.nextLine();
                    System.out.println(registrarJugada(jugador, jugada));
                    break;
                case 3:
                    System.out.println(obtenerResultado());
                    break;
                case 4:
                    System.out.println(reiniciarPartida());
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static String iniciarPartida() {
        clienteeee.ServerSoapp_Service service = new clienteeee.ServerSoapp_Service();
        clienteeee.ServerSoapp port = service.getServerSoappPort();
        return port.iniciarPartida();
    }

    private static String obtenerResultado() {
        clienteeee.ServerSoapp_Service service = new clienteeee.ServerSoapp_Service();
        clienteeee.ServerSoapp port = service.getServerSoappPort();
        return port.obtenerResultado();
    }

    private static String registrarJugada(java.lang.String arg0, java.lang.String arg1) {
        clienteeee.ServerSoapp_Service service = new clienteeee.ServerSoapp_Service();
        clienteeee.ServerSoapp port = service.getServerSoappPort();
        return port.registrarJugada(arg0, arg1);
    }

    private static String reiniciarPartida() {
        clienteeee.ServerSoapp_Service service = new clienteeee.ServerSoapp_Service();
        clienteeee.ServerSoapp port = service.getServerSoappPort();
        return port.reiniciarPartida();
    }
}