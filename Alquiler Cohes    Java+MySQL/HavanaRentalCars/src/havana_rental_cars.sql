-- Crear la base de datos y usarla
CREATE DATABASE IF NOT EXISTS havana_rental_cars;
USE havana_rental_cars;

-- Tabla de CLIENTES
CREATE TABLE IF NOT EXISTS clients (
    dni VARCHAR(15) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    telefono VARCHAR(20),
    direccion VARCHAR(255),
    email VARCHAR(100),
    num_permiso VARCHAR(50)
);

-- Tabla de COTXES
CREATE TABLE IF NOT EXISTS cars (
    matricula VARCHAR(20) PRIMARY KEY,
    numero_bastidor VARCHAR(50),
    marca VARCHAR(50),
    modelo VARCHAR(50),
    color VARCHAR(50),
    tipo_coche VARCHAR(50),
    num_plazas INT,
    num_puertas INT,
    tipo_combustible VARCHAR(50)
);

-- Tabla de LLOGUER (RENTALS)
-- Registra cada alquiler, relacionando un cliente y un coche,además de los detalles del alquiler y de la devolución.
CREATE TABLE IF NOT EXISTS rentals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_dni VARCHAR(15),
    car_matricula VARCHAR(20),
    fecha_prestamo DATE,
    dias INT,
    precio_dia DECIMAL(10,2),
    lugar_devolucion VARCHAR(255),
    deposito_lleno BOOLEAN,
    tipo_seguro VARCHAR(50),
    penalizacion DECIMAL(10,2),
    fecha_devolucion DATE,
    devuelto BOOLEAN DEFAULT false,
    FOREIGN KEY (client_dni) REFERENCES clients(dni),
    FOREIGN KEY (car_matricula) REFERENCES cars(matricula)
);

