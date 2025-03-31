package com.havanarentalcars.model;



//a clase Client representa a un cliente y contiene atributos según los requerimientos.
public class Client {

    // Declaración de atributos privados para encapsular la información del cliente.
    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;
    private String telefono;
    private String direccion;
    private String email;
    private String numPermiso;


    // Constructor de la clase que inicializa todos los atributos del cliente.
    public Client(String dni, String nombre, String apellidos, int edad, String telefono, String direccion, String email, String numPermiso) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.numPermiso = numPermiso;
    }




    // Métodos getters y setters para acceder y modificar los atributos de forma controlada.

    // Obtiene el DNI del cliente.
    public String getDni() {
        return dni;
    }

    // Establece o actualiza el DNI del cliente.
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNumPermiso() {
        return numPermiso;
    }
    public void setNumPermiso(String numPermiso) {
        this.numPermiso = numPermiso;
    }


    // Método toString que devuelve una representación en forma de cadena de la información del cliente.
    @Override
    public String toString() {
        return "Client{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", numPermiso='" + numPermiso + '\'' +
                '}';
    }
}
