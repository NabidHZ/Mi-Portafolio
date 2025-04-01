package com.havanarentalcars.model;

public class Car {

    // La clase Car representa un coche y contiene atributos según los requerimientos.
    private String matricula;
    private String numeroBastidor;
    private String marca;
    private String modelo;
    private String color;
    private String tipoCoche;
    private int numPlazas;
    private int numPuertas;
    private String tipoCombustible;


    // Constructor de la clase Car para inicializar los atributos
    public Car(String matricula, String numeroBastidor, String marca, String modelo, String color,
               String tipoCoche, int numPlazas, int numPuertas, String tipoCombustible) {
        this.matricula = matricula;
        this.numeroBastidor = numeroBastidor;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tipoCoche = tipoCoche;
        this.numPlazas = numPlazas;
        this.numPuertas = numPuertas;
        this.tipoCombustible = tipoCombustible;
    }


    // Métodos getters y setters para acceder y modificar los atributos privados
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getNumeroBastidor() {
        return numeroBastidor;
    }
    public void setNumeroBastidor(String numeroBastidor) {
        this.numeroBastidor = numeroBastidor;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getTipoCoche() {
        return tipoCoche;
    }
    public void setTipoCoche(String tipoCoche) {
        this.tipoCoche = tipoCoche;
    }
    public int getNumPlazas() {
        return numPlazas;
    }
    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }
    public int getNumPuertas() {
        return numPuertas;
    }
    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }
    public String getTipoCombustible() {
        return tipoCombustible;
    }
    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }


    // Métodos getters y setters para acceder y modificar los atributos privados
    @Override
    public String toString() {
        return "Car{" +
                "matricula='" + matricula + '\'' +
                ", numeroBastidor='" + numeroBastidor + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", tipoCoche='" + tipoCoche + '\'' +
                ", numPlazas=" + numPlazas +
                ", numPuertas=" + numPuertas +
                ", tipoCombustible='" + tipoCombustible + '\'' +
                '}';
    }
}

