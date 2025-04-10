package com.havanarentalcars.dao;

import java.util.List;
import com.havanarentalcars.model.Rental;


public interface RentalDAO {
    void addRental(Rental rental) throws Exception;
    void updateRental(Rental rental) throws Exception;
    Rental getRental(int id) throws Exception;
    List<Rental> getAllRentals() throws Exception;
    List<Rental> getActiveRentals() throws Exception; // Alquileres no devueltos
}
