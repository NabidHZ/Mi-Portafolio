package com.havanarentalcars;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.havanarentalcars.dao.CarDAO;
import com.havanarentalcars.dao.ClientDAO;
import com.havanarentalcars.dao.ClientDAOImpl;
import com.havanarentalcars.dao.CarDAOImpl;
import com.havanarentalcars.dao.RentalDAO;
import com.havanarentalcars.dao.RentalDAOImpl;
import com.havanarentalcars.model.Car;
import com.havanarentalcars.model.Client;
import com.havanarentalcars.model.Rental;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ClientDAO clientDAO = new ClientDAOImpl();
    private static CarDAO carDAO = new CarDAOImpl();
    private static RentalDAO rentalDAO = new RentalDAOImpl();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("===== HAVANA RENTAL CARS =====");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Cotxes");
            System.out.println("3. Gestión del Lloguer");
            System.out.println("4. Gestió de la Devolució");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    menuClientes();
                    break;
                case 2:
                    menuCoches();
                    break;
                case 3:
                    gestionarLloguer();
                    break;
                case 4:
                    gestionarDevolucion();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void menuClientes() {
        int op;
        do {
            System.out.println("----- Gestión de Clientes -----");
            System.out.println("1. Alta de Cliente");
            System.out.println("2. Modificar Cliente");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Buscar Cliente (por DNI)");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            op = Integer.parseInt(scanner.nextLine());

            try {
                switch (op) {
                    case 1:
                        addCliente();
                        break;
                    case 2:
                        updateCliente();
                        break;
                    case 3:
                        deleteCliente();
                        break;
                    case 4:
                        listClientes();
                        break;
                    case 5:
                        buscarCliente();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (op != 0);
    }

    private static void addCliente() throws Exception {
        System.out.println("Introduce DNI:");
        String dni = scanner.nextLine();
        System.out.println("Introduce Nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce Apellidos:");
        String apellidos = scanner.nextLine();
        System.out.println("Introduce Edad:");
        int edad = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce Teléfono:");
        String telefono = scanner.nextLine();
        System.out.println("Introduce Dirección:");
        String direccion = scanner.nextLine();
        System.out.println("Introduce Email:");
        String email = scanner.nextLine();
        System.out.println("Introduce Número de Permiso:");
        String numPermiso = scanner.nextLine();

        Client client = new Client(dni, nombre, apellidos, edad, telefono, direccion, email, numPermiso);
        clientDAO.addClient(client);
        System.out.println("Cliente añadido correctamente.");
    }

    private static void updateCliente() throws Exception {
        System.out.println("Introduce DNI del cliente a modificar:");
        String dni = scanner.nextLine();
        Client client = clientDAO.getClient(dni);
        if (client == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        System.out.println("Introduce nuevo Nombre (actual: " + client.getNombre() + "):");
        String nombre = scanner.nextLine();
        System.out.println("Introduce nuevos Apellidos (actual: " + client.getApellidos() + "):");
        String apellidos = scanner.nextLine();
        System.out.println("Introduce nueva Edad (actual: " + client.getEdad() + "):");
        int edad = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce nuevo Teléfono (actual: " + client.getTelefono() + "):");
        String telefono = scanner.nextLine();
        System.out.println("Introduce nueva Dirección (actual: " + client.getDireccion() + "):");
        String direccion = scanner.nextLine();
        System.out.println("Introduce nuevo Email (actual: " + client.getEmail() + "):");
        String email = scanner.nextLine();
        System.out.println("Introduce nuevo Número de Permiso (actual: " + client.getNumPermiso() + "):");
        String numPermiso = scanner.nextLine();

        client.setNombre(nombre);
        client.setApellidos(apellidos);
        client.setEdad(edad);
        client.setTelefono(telefono);
        client.setDireccion(direccion);
        client.setEmail(email);
        client.setNumPermiso(numPermiso);

        clientDAO.updateClient(client);
        System.out.println("Cliente actualizado correctamente.");
    }

    private static void deleteCliente() throws Exception {
        System.out.println("Introduce DNI del cliente a eliminar:");
        String dni = scanner.nextLine();
        clientDAO.deleteClient(dni);
        System.out.println("Cliente eliminado correctamente.");
    }

    private static void listClientes() throws Exception {
        List<Client> clients = clientDAO.getAllClients();
        System.out.println("----- Lista de Clientes -----");
        for (Client c : clients) {
            System.out.println(c);
        }
    }

    private static void buscarCliente() throws Exception {
        System.out.println("Introduce DNI del cliente a buscar:");
        String dni = scanner.nextLine();
        Client client = clientDAO.getClient(dni);
        if (client != null) {
            System.out.println(client);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void menuCoches() {
        int op;
        do {
            System.out.println("----- Gestión de Cotxes -----");
            System.out.println("1. Alta de Cotxe");
            System.out.println("2. Modificar Cotxe");
            System.out.println("3. Eliminar Cotxe");
            System.out.println("4. Listar Cotxes");
            System.out.println("5. Buscar Cotxe (por Matrícula)");
            System.out.println("6. Buscar Cotxe (por Tipo)");
            System.out.println("7. Buscar Cotxe (por Marca)");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            op = Integer.parseInt(scanner.nextLine());

            try {
                switch (op) {
                    case 1:
                        addCoche();
                        break;
                    case 2:
                        updateCoche();
                        break;
                    case 3:
                        deleteCoche();
                        break;
                    case 4:
                        listCoches();
                        break;
                    case 5:
                        buscarCochePorMatricula();
                        break;
                    case 6:
                        buscarCochePorTipo();
                        break;
                    case 7:
                        buscarCochePorMarca();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (op != 0);
    }

    private static void addCoche() throws Exception {
        System.out.println("Introduce Matrícula:");
        String matricula = scanner.nextLine();
        System.out.println("Introduce Número de Bastidor:");
        String numBastidor = scanner.nextLine();
        System.out.println("Introduce Marca:");
        String marca = scanner.nextLine();
        System.out.println("Introduce Modelo:");
        String modelo = scanner.nextLine();
        System.out.println("Introduce Color:");
        String color = scanner.nextLine();
        System.out.println("Introduce Tipo de Cotxe:");
        String tipoCoche = scanner.nextLine();
        System.out.println("Introduce Número de Plazas:");
        int numPlazas = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce Número de Puertas:");
        int numPuertas = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce Tipo de Combustible:");
        String tipoCombustible = scanner.nextLine();

        Car car = new Car(matricula, numBastidor, marca, modelo, color, tipoCoche, numPlazas, numPuertas, tipoCombustible);
        carDAO.addCar(car);
        System.out.println("Cotxe añadido correctamente.");
    }

    private static void updateCoche() throws Exception {
        System.out.println("Introduce Matrícula del cotxe a modificar:");
        String matricula = scanner.nextLine();
        Car car = carDAO.getCar(matricula);
        if (car == null) {
            System.out.println("Cotxe no encontrado.");
            return;
        }
        System.out.println("Introduce nuevo Número de Bastidor (actual: " + car.getNumeroBastidor() + "):");
        String numBastidor = scanner.nextLine();
        System.out.println("Introduce nueva Marca (actual: " + car.getMarca() + "):");
        String marca = scanner.nextLine();
        System.out.println("Introduce nuevo Modelo (actual: " + car.getModelo() + "):");
        String modelo = scanner.nextLine();
        System.out.println("Introduce nuevo Color (actual: " + car.getColor() + "):");
        String color = scanner.nextLine();
        System.out.println("Introduce nuevo Tipo de Cotxe (actual: " + car.getTipoCoche() + "):");
        String tipoCoche = scanner.nextLine();
        System.out.println("Introduce nuevo Número de Plazas (actual: " + car.getNumPlazas() + "):");
        int numPlazas = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce nuevo Número de Puertas (actual: " + car.getNumPuertas() + "):");
        int numPuertas = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce nuevo Tipo de Combustible (actual: " + car.getTipoCombustible() + "):");
        String tipoCombustible = scanner.nextLine();

        car.setNumeroBastidor(numBastidor);
        car.setMarca(marca);
        car.setModelo(modelo);
        car.setColor(color);
        car.setTipoCoche(tipoCoche);
        car.setNumPlazas(numPlazas);
        car.setNumPuertas(numPuertas);
        car.setTipoCombustible(tipoCombustible);

        carDAO.updateCar(car);
        System.out.println("Cotxe actualizado correctamente.");
    }

    private static void deleteCoche() throws Exception {
        System.out.println("Introduce Matrícula del cotxe a eliminar:");
        String matricula = scanner.nextLine();
        carDAO.deleteCar(matricula);
        System.out.println("Cotxe eliminado correctamente.");
    }

    private static void listCoches() throws Exception {
        List<Car> cars = carDAO.getAllCars();
        System.out.println("----- Lista de Cotxes -----");
        for (Car c : cars) {
            System.out.println(c);
        }
    }

    private static void buscarCochePorMatricula() throws Exception {
        System.out.println("Introduce Matrícula del cotxe a buscar:");
        String matricula = scanner.nextLine();
        Car car = carDAO.getCar(matricula);
        if (car != null) {
            System.out.println(car);
        } else {
            System.out.println("Cotxe no encontrado.");
        }
    }

    private static void buscarCochePorTipo() throws Exception {
        System.out.println("Introduce Tipo de Cotxe a buscar:");
        String tipoCoche = scanner.nextLine();
        List<Car> cars = carDAO.searchCarsByType(tipoCoche);
        if (cars.isEmpty()) {
            System.out.println("No se encontraron cotxes del tipo especificado.");
        } else {
            for (Car c : cars) {
                System.out.println(c);
            }
        }
    }

    private static void buscarCochePorMarca() throws Exception {
        System.out.println("Introduce Marca a buscar:");
        String marca = scanner.nextLine();
        List<Car> cars = carDAO.searchCarsByBrand(marca);
        if (cars.isEmpty()) {
            System.out.println("No se encontraron cotxes de la marca especificada.");
        } else {
            for (Car c : cars) {
                System.out.println(c);
            }
        }
    }

    private static void gestionarLloguer() {
        try {
            System.out.println("----- Gestión del Lloguer -----");
            System.out.println("Introduce DNI del cliente:");
            String dni = scanner.nextLine();
            System.out.println("Introduce Matrícula del cotxe:");
            String matricula = scanner.nextLine();
            System.out.println("Introduce Fecha de Préstamo (YYYY-MM-DD):");
            Date fechaPrestamo = Date.valueOf(scanner.nextLine());
            System.out.println("Introduce Número de Días:");
            int dias = Integer.parseInt(scanner.nextLine());
            System.out.println("Introduce Precio por Día:");
            double precioDia = Double.parseDouble(scanner.nextLine());
            System.out.println("Introduce Lugar de Devolución:");
            String lugarDevolucion = scanner.nextLine();
            System.out.println("¿Depósito con dipòsit ple? (true/false):");
            boolean depositoLleno = Boolean.parseBoolean(scanner.nextLine());
            System.out.println("Introduce Tipo de Seguro (amb franquícia / sense franquícia):");
            String tipoSeguro = scanner.nextLine();
            System.out.println("Introduce Penalización por retraso (si aplica, sino 0):");
            double penalizacion = Double.parseDouble(scanner.nextLine());
            System.out.println("Introduce Fecha de Devolución (YYYY-MM-DD):");
            Date fechaDevolucion = Date.valueOf(scanner.nextLine());

            Rental rental = new Rental(dni, matricula, fechaPrestamo, dias, precioDia,
                    lugarDevolucion, depositoLleno, tipoSeguro, penalizacion,
                    fechaDevolucion, false);
            rentalDAO.addRental(rental);
            System.out.println("Lloguer registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error en la gestión del lloguer: " + e.getMessage());
        }
    }

    private static void gestionarDevolucion() {
        try {
            System.out.println("----- Gestió de la Devolució -----");
            List<Rental> rentals = rentalDAO.getActiveRentals();
            if (rentals.isEmpty()) {
                System.out.println("No hay cotxes actualmente llogats.");
                return;
            }
            System.out.println("Lista de alquileres activos:");
            for (Rental r : rentals) {
                System.out.println(r);
            }
            System.out.println("Introduce el ID del lloguer a marcar como devuelto:");
            int id = Integer.parseInt(scanner.nextLine());
            Rental rental = rentalDAO.getRental(id);
            if (rental == null) {
                System.out.println("Lloguer no encontrado.");
                return;
            }
            rental.setDevuelto(true);
            rentalDAO.updateRental(rental);
            System.out.println("Lloguer marcado como devuelto.");
        } catch (Exception e) {
            System.out.println("Error en la gestión de la devolución: " + e.getMessage());
        }
    }
}
