package com.havanarentalcars.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.havanarentalcars.model.Car;
import com.havanarentalcars.util.DatabaseConnection;


public class CarDAOImpl implements CarDAO {

    @Override
    public void addCar(Car car) throws Exception {
        String sql = "INSERT INTO cars (matricula, numero_bastidor, marca, modelo, color, tipo_coche, num_plazas, num_puertas, tipo_combustible) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, car.getMatricula());
            stmt.setString(2, car.getNumeroBastidor());
            stmt.setString(3, car.getMarca());
            stmt.setString(4, car.getModelo());
            stmt.setString(5, car.getColor());
            stmt.setString(6, car.getTipoCoche());
            stmt.setInt(7, car.getNumPlazas());
            stmt.setInt(8, car.getNumPuertas());
            stmt.setString(9, car.getTipoCombustible());

            stmt.executeUpdate();
        }
    }

    @Override
    public void updateCar(Car car) throws Exception {
        String sql = "UPDATE cars SET numero_bastidor=?, marca=?, modelo=?, color=?, tipo_coche=?, num_plazas=?, num_puertas=?, tipo_combustible=? WHERE matricula=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, car.getNumeroBastidor());
            stmt.setString(2, car.getMarca());
            stmt.setString(3, car.getModelo());
            stmt.setString(4, car.getColor());
            stmt.setString(5, car.getTipoCoche());
            stmt.setInt(6, car.getNumPlazas());
            stmt.setInt(7, car.getNumPuertas());
            stmt.setString(8, car.getTipoCombustible());
            stmt.setString(9, car.getMatricula());

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteCar(String matricula) throws Exception {
        String sql = "DELETE FROM cars WHERE matricula=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, matricula);
            stmt.executeUpdate();
        }
    }

    @Override
    public Car getCar(String matricula) throws Exception {
        String sql = "SELECT * FROM cars WHERE matricula=?";
        Car car = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, matricula);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                car = new Car(
                        rs.getString("matricula"),
                        rs.getString("numero_bastidor"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("color"),
                        rs.getString("tipo_coche"),
                        rs.getInt("num_plazas"),
                        rs.getInt("num_puertas"),
                        rs.getString("tipo_combustible")
                );
            }
        }
        return car;
    }

    @Override
    public List<Car> getAllCars() throws Exception {
        String sql = "SELECT * FROM cars";
        List<Car> cars = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Car car = new Car(
                        rs.getString("matricula"),
                        rs.getString("numero_bastidor"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("color"),
                        rs.getString("tipo_coche"),
                        rs.getInt("num_plazas"),
                        rs.getInt("num_puertas"),
                        rs.getString("tipo_combustible")
                );
                cars.add(car);
            }
        }
        return cars;
    }

    @Override
    public List<Car> searchCarsByType(String tipoCoche) throws Exception {
        String sql = "SELECT * FROM cars WHERE tipo_coche=?";
        List<Car> cars = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tipoCoche);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Car car = new Car(
                        rs.getString("matricula"),
                        rs.getString("numero_bastidor"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("color"),
                        rs.getString("tipo_coche"),
                        rs.getInt("num_plazas"),
                        rs.getInt("num_puertas"),
                        rs.getString("tipo_combustible")
                );
                cars.add(car);
            }
        }
        return cars;
    }

    @Override
    public List<Car> searchCarsByBrand(String marca) throws Exception {
        String sql = "SELECT * FROM cars WHERE marca=?";
        List<Car> cars = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, marca);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Car car = new Car(
                        rs.getString("matricula"),
                        rs.getString("numero_bastidor"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("color"),
                        rs.getString("tipo_coche"),
                        rs.getInt("num_plazas"),
                        rs.getInt("num_puertas"),
                        rs.getString("tipo_combustible")
                );
                cars.add(car);
            }
        }
        return cars;
    }
}
