package com.havanarentalcars.dao;

import java.util.List;
import com.havanarentalcars.model.Car;

public interface CarDAO {
    void addCar(Car car) throws Exception;
    void updateCar(Car car) throws Exception;
    void deleteCar(String matricula) throws Exception;
    Car getCar(String matricula) throws Exception;
    List<Car> getAllCars() throws Exception;
    List<Car> searchCarsByType(String tipoCoche) throws Exception;
    List<Car> searchCarsByBrand(String marca) throws Exception;
}
