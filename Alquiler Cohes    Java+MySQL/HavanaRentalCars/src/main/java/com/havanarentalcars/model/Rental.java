package com.havanarentalcars.model;

import java.sql.Date;


/*La clase Rental representa un alquiler y contiene atributos tanto del préstamo como de la devolución.*/



//Atributos de la clase Rental
public class Rental {
    private int id;
    private String clientDni;
    private String carMatricula;
    private Date fechaPrestamo;
    private int dias;
    private double precioDia;
    private String lugarDevolucion;
    private boolean depositoLleno;
    private String tipoSeguro;
    private double penalizacion;
    private Date fechaDevolucion;
    private boolean devuelto;

    // Constructor principal que inicializa todos los atributos
    public Rental(int id, String clientDni, String carMatricula, Date fechaPrestamo, int dias, double precioDia,
                  String lugarDevolucion, boolean depositoLleno, String tipoSeguro, double penalizacion,
                  Date fechaDevolucion, boolean devuelto) {
        this.id = id;
        this.clientDni = clientDni;
        this.carMatricula = carMatricula;
        this.fechaPrestamo = fechaPrestamo;
        this.dias = dias;
        this.precioDia = precioDia;
        this.lugarDevolucion = lugarDevolucion;
        this.depositoLleno = depositoLleno;
        this.tipoSeguro = tipoSeguro;
        this.penalizacion = penalizacion;
        this.fechaDevolucion = fechaDevolucion;
        this.devuelto = devuelto;
    }

    // Constructor sin id para inserciones (auto_increment)
    //La base de datos ya genera un id unico automaticamente, eso recibe todo los parametros excepto el id
    //Por eso se le asigna con un-1 lo que indica que no es real
    //De esta manera, el objeto se crea sin un id definido y más tarde se puede actualizar cuando la base de datos asigne uno
    public Rental(String clientDni, String carMatricula, Date fechaPrestamo, int dias, double precioDia,
                  String lugarDevolucion, boolean depositoLleno, String tipoSeguro, double penalizacion,
                  Date fechaDevolucion, boolean devuelto) {
        this(-1, clientDni, carMatricula, fechaPrestamo, dias, precioDia, lugarDevolucion, depositoLleno,
                tipoSeguro, penalizacion, fechaDevolucion, devuelto);
    }

    // Métodos getters y setters para acceder y modificar los atributos
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getClientDni() {
        return clientDni;
    }
    public void setClientDni(String clientDni) {
        this.clientDni = clientDni;
    }
    public String getCarMatricula() {
        return carMatricula;
    }
    public void setCarMatricula(String carMatricula) {
        this.carMatricula = carMatricula;
    }
    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    public int getDias() {
        return dias;
    }
    public void setDias(int dias) {
        this.dias = dias;
    }
    public double getPrecioDia() {
        return precioDia;
    }
    public void setPrecioDia(double precioDia) {
        this.precioDia = precioDia;
    }
    public String getLugarDevolucion() {
        return lugarDevolucion;
    }
    public void setLugarDevolucion(String lugarDevolucion) {
        this.lugarDevolucion = lugarDevolucion;
    }
    public boolean isDepositoLleno() {
        return depositoLleno;
    }
    public void setDepositoLleno(boolean depositoLleno) {
        this.depositoLleno = depositoLleno;
    }
    public String getTipoSeguro() {
        return tipoSeguro;
    }
    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }
    public double getPenalizacion() {
        return penalizacion;
    }
    public void setPenalizacion(double penalizacion) {
        this.penalizacion = penalizacion;
    }
    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }
    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    public boolean isDevuelto() {
        return devuelto;
    }
    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }


    // Método toString() para representar el objeto como una cadena de texto
    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", clientDni='" + clientDni + '\'' +
                ", carMatricula='" + carMatricula + '\'' +
                ", fechaPrestamo=" + fechaPrestamo +
                ", dias=" + dias +
                ", precioDia=" + precioDia +
                ", lugarDevolucion='" + lugarDevolucion + '\'' +
                ", depositoLleno=" + depositoLleno +
                ", tipoSeguro='" + tipoSeguro + '\'' +
                ", penalizacion=" + penalizacion +
                ", fechaDevolucion=" + fechaDevolucion +
                ", devuelto=" + devuelto +
                '}';
    }
}
