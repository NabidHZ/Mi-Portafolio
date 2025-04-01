package com.havanarentalcars.dao;

import com.havanarentalcars.model.Client;
import java.util.List;


//Esta interfaz declara los métodos que se utilizarán para realizar operaciones CRUD sobre la entidad Client
public interface ClientDAO {
    void addClient(Client client) throws Exception;
    void updateClient(Client client) throws Exception;
    void deleteClient(String dni) throws Exception;
    Client getClient(String dni) throws Exception;
    List<Client> getAllClients() throws Exception;
}
