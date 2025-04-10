package com.havanarentalcars.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.havanarentalcars.model.Rental;
import com.havanarentalcars.util.DatabaseConnection;


public class RentalDAOImpl implements RentalDAO {

    @Override
    public void addRental(Rental rental) throws Exception {
        String sql = "INSERT INTO rentals (client_dni, car_matricula, fecha_prestamo, dias, precio_dia, lugar_devolucion, deposito_lleno, tipo_seguro, penalizacion, fecha_devolucion, devuelto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, rental.getClientDni());
            stmt.setString(2, rental.getCarMatricula());
            stmt.setDate(3, rental.getFechaPrestamo());
            stmt.setInt(4, rental.getDias());
            stmt.setDouble(5, rental.getPrecioDia());
            stmt.setString(6, rental.getLugarDevolucion());
            stmt.setBoolean(7, rental.isDepositoLleno());
            stmt.setString(8, rental.getTipoSeguro());
            stmt.setDouble(9, rental.getPenalizacion());
            stmt.setDate(10, rental.getFechaDevolucion());
            stmt.setBoolean(11, rental.isDevuelto());

            stmt.executeUpdate();
        }
    }

    @Override
    public void updateRental(Rental rental) throws Exception {
        String sql = "UPDATE rentals SET client_dni=?, car_matricula=?, fecha_prestamo=?, dias=?, precio_dia=?, lugar_devolucion=?, deposito_lleno=?, tipo_seguro=?, penalizacion=?, fecha_devolucion=?, devuelto=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, rental.getClientDni());
            stmt.setString(2, rental.getCarMatricula());
            stmt.setDate(3, rental.getFechaPrestamo());
            stmt.setInt(4, rental.getDias());
            stmt.setDouble(5, rental.getPrecioDia());
            stmt.setString(6, rental.getLugarDevolucion());
            stmt.setBoolean(7, rental.isDepositoLleno());
            stmt.setString(8, rental.getTipoSeguro());
            stmt.setDouble(9, rental.getPenalizacion());
            stmt.setDate(10, rental.getFechaDevolucion());
            stmt.setBoolean(11, rental.isDevuelto());
            stmt.setInt(12, rental.getId());

            stmt.executeUpdate();
        }
    }

    @Override
    public Rental getRental(int id) throws Exception {
        String sql = "SELECT * FROM rentals WHERE id=?";
        Rental rental = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                rental = new Rental(
                        rs.getInt("id"),
                        rs.getString("client_dni"),
                        rs.getString("car_matricula"),
                        rs.getDate("fecha_prestamo"),
                        rs.getInt("dias"),
                        rs.getDouble("precio_dia"),
                        rs.getString("lugar_devolucion"),
                        rs.getBoolean("deposito_lleno"),
                        rs.getString("tipo_seguro"),
                        rs.getDouble("penalizacion"),
                        rs.getDate("fecha_devolucion"),
                        rs.getBoolean("devuelto")
                );
            }
        }
        return rental;
    }

    @Override
    public List<Rental> getAllRentals() throws Exception {
        String sql = "SELECT * FROM rentals";
        List<Rental> rentals = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Rental rental = new Rental(
                        rs.getInt("id"),
                        rs.getString("client_dni"),
                        rs.getString("car_matricula"),
                        rs.getDate("fecha_prestamo"),
                        rs.getInt("dias"),
                        rs.getDouble("precio_dia"),
                        rs.getString("lugar_devolucion"),
                        rs.getBoolean("deposito_lleno"),
                        rs.getString("tipo_seguro"),
                        rs.getDouble("penalizacion"),
                        rs.getDate("fecha_devolucion"),
                        rs.getBoolean("devuelto")
                );
                rentals.add(rental);
            }
        }
        return rentals;
    }

    @Override
    public List<Rental> getActiveRentals() throws Exception {
        String sql = "SELECT * FROM rentals WHERE devuelto = false";
        List<Rental> rentals = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Rental rental = new Rental(
                        rs.getInt("id"),
                        rs.getString("client_dni"),
                        rs.getString("car_matricula"),
                        rs.getDate("fecha_prestamo"),
                        rs.getInt("dias"),
                        rs.getDouble("precio_dia"),
                        rs.getString("lugar_devolucion"),
                        rs.getBoolean("deposito_lleno"),
                        rs.getString("tipo_seguro"),
                        rs.getDouble("penalizacion"),
                        rs.getDate("fecha_devolucion"),
                        rs.getBoolean("devuelto")
                );
                rentals.add(rental);
            }
        }
        return rentals;
    }
}
