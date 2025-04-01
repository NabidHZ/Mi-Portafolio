package com.havanarentalcars.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.havanarentalcars.model.Client;
import com.havanarentalcars.util.DatabaseConnection;


//La clase ClientDAOImpl implementa ClientDAO y define el funcionamiento concreto de cada método.
public class ClientDAOImpl implements ClientDAO {



    //Inserta un nuevo registro en la tabla clients usando los datos del objeto Client
    @Override
    public void addClient(Client client) throws Exception {

        //consulta SQL para insertar un nuevo cliente
        String sql = "INSERT INTO clients (dni, nombre, apellidos, edad, telefono, direccion, email, num_permiso) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        //intenta establecer una conexión a la base de datos y preparar la consulta
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            //asigna los valores del objeto Client a la consulta
            stmt.setString(1, client.getDni());
            stmt.setString(2, client.getNombre());
            stmt.setString(3, client.getApellidos());
            stmt.setInt(4, client.getEdad());
            stmt.setString(5, client.getTelefono());
            stmt.setString(6, client.getDireccion());
            stmt.setString(7, client.getEmail());
            stmt.setString(8, client.getNumPermiso());

            stmt.executeUpdate();
        }
    }


    //Actualiza un registro existente en la tabla clients usando los datos del objeto Client
    @Override
    public void updateClient(Client client) throws Exception {

        //consulta SQL para actualizar un cliente existente
        String sql = "UPDATE clients SET nombre=?, apellidos=?, edad=?, telefono=?, direccion=?, email=?, num_permiso=? WHERE dni=?";
        //intenta establecer una conexión a la base de datos
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            //asigna los valores del objeto Client a la consulta
            stmt.setString(1, client.getNombre());
            stmt.setString(2, client.getApellidos());
            stmt.setInt(3, client.getEdad());
            stmt.setString(4, client.getTelefono());
            stmt.setString(5, client.getDireccion());
            stmt.setString(6, client.getEmail());
            stmt.setString(7, client.getNumPermiso());
            stmt.setString(8, client.getDni());

            stmt.executeUpdate();
        }
    }

    //Elimina un registro de la tabla clients usando el DNI del cliente
    @Override
    public void deleteClient(String dni) throws Exception {
        //consulta SQL para eliminar un cliente
        String sql = "DELETE FROM clients WHERE dni=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            //asigna el DNI del cliente a la consulta
            stmt.setString(1, dni);
            stmt.executeUpdate();
        }
    }

    //Recupera un registro de la tabla clients usando el DNI del cliente
    @Override
    public Client getClient(String dni) throws Exception {
        //consulta SQL para obtener un cliente con DNI
        String sql = "SELECT * FROM clients WHERE dni=?";
        Client client = null;

        //intenta establecer una conexión a la base de datos
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();

            //si hay resultados, crea un objeto Client con los datos obtenidos
            if (rs.next()) {
                client = new Client(
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getInt("edad"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("email"),
                        rs.getString("num_permiso")
                );
            }
        }
        //si no se encuentra el cliente, lanza una excepción
        return client;
    }


    //Recupera todos los registros de la tabla clients
    @Override
    public List<Client> getAllClients() throws Exception {
        //consulta SQL para obtener todos los clientes
        String sql = "SELECT * FROM clients";
        List<Client> clients = new ArrayList<>();

        //intenta establecer una conexión a la base de datos
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            //ejecuta la consulta y obtiene los resultados
            ResultSet rs = stmt.executeQuery();

            //itera sobre los resultados y crea objetos Client
            //Por cada registro, se crea un objeto Client y se añade a la lista clients.
            while (rs.next()) {
                Client client = new Client(
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getInt("edad"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("email"),
                        rs.getString("num_permiso")
                );
                clients.add(client);
            }
        }
        return clients;
    }
}
