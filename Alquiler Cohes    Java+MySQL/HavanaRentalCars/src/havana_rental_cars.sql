-- ====================================================
-- SCRIPT DE CREACIÓN DE LA BASE DE DATOS Y SUS TABLAS
-- ====================================================

-- Crea la base de datos "havana_rental_cars" si no existe y la selecciona
CREATE DATABASE IF NOT EXISTS havana_rental_cars;
USE havana_rental_cars;

-- ====================================================
-- CREACIÓN DE TABLAS
-- ====================================================

-- CREACIÓN DE LA TABLA "clients" para almacenar la información de los clientes
CREATE TABLE IF NOT EXISTS clients (
                                       dni VARCHAR(15) PRIMARY KEY,        -- Clave primaria: identificador único del cliente
    nombre VARCHAR(100) NOT NULL,         -- Nombre del cliente
    apellidos VARCHAR(100) NOT NULL,      -- Apellidos del cliente
    edad INT NOT NULL,                    -- Edad del cliente
    telefono VARCHAR(20),                 -- Teléfono del cliente
    direccion VARCHAR(255),               -- Dirección física
    email VARCHAR(100),                   -- Correo electrónico
    num_permiso VARCHAR(50)               -- Número del permiso de conducción
    );

-- CREACIÓN DE LA TABLA "cars" para almacenar la información de los coches
CREATE TABLE IF NOT EXISTS cars (
                                    matricula VARCHAR(20) PRIMARY KEY,    -- Clave primaria: matrícula del coche
    numero_bastidor VARCHAR(50),          -- Número de bastidor
    marca VARCHAR(50),                    -- Marca del coche
    modelo VARCHAR(50),                   -- Modelo del coche
    color VARCHAR(50),                    -- Color del coche
    tipo_coche VARCHAR(50),               -- Tipo de coche (por ejemplo, descapotable, deportivo, etc.)
    num_plazas INT,                       -- Número de plazas
    num_puertas INT,                      -- Número de puertas
    tipo_combustible VARCHAR(50)          -- Tipo de combustible (gasolina, diésel, eléctrico, etc.)
    );

-- CREACIÓN DE LA TABLA "rentals" para registrar los alquileres
CREATE TABLE IF NOT EXISTS rentals (
                                       id INT AUTO_INCREMENT PRIMARY KEY,  -- Clave primaria autoincrementable para identificar cada alquiler
                                       client_dni VARCHAR(15),             -- DNI del cliente que realiza el alquiler (clave foránea)
    car_matricula VARCHAR(20),          -- Matrícula del coche alquilado (clave foránea)
    fecha_prestamo DATE,                -- Fecha en la que se realiza el alquiler
    dias INT,                           -- Número de días del alquiler
    precio_dia DECIMAL(10,2),           -- Precio por día del alquiler
    lugar_devolucion VARCHAR(255),      -- Lugar donde se realizará la devolución del coche
    deposito_lleno BOOLEAN,             -- Indica si el coche se devuelve con depósito lleno (true/false)
    tipo_seguro VARCHAR(50),            -- Tipo de seguro (con o sin franquicia)
    penalizacion DECIMAL(10,2),         -- Penalización en caso de retraso en la devolución
    fecha_devolucion DATE,              -- Fecha prevista para la devolución
    devuelto BOOLEAN DEFAULT false,     -- Estado de devolución (false si aún no se ha devuelto, true si ya se devolvió)
    FOREIGN KEY (client_dni) REFERENCES clients(dni),
    FOREIGN KEY (car_matricula) REFERENCES cars(matricula)
    );

-- ====================================================
-- CONSULTAS DML (INSERT, UPDATE, DELETE, SELECT)
-- ====================================================

-- ------------------------------
-- CONSULTAS SOBRE LA TABLA "clients"
-- ------------------------------

-- INSERT: Agrega un nuevo cliente a la tabla.
INSERT INTO clients (dni, nombre, apellidos, edad, telefono, direccion, email, num_permiso)
VALUES ('12345678A', 'Juan', 'Pérez Gómez', 30, '600123456', 'Calle Falsa 123', 'juan@example.com', 'LIC123456');

-- UPDATE: Actualiza la información de un cliente existente (por ejemplo, cambiar el teléfono).
UPDATE clients
SET telefono = '600987654'
WHERE dni = '12345678A';

-- DELETE: Elimina un cliente de la base de datos mediante su DNI.
DELETE FROM clients
WHERE dni = '12345678A';

-- SELECT: Muestra todos los clientes existentes.
SELECT * FROM clients;

-- SELECT: Busca un cliente específico por DNI.
SELECT * FROM clients
WHERE dni = '12345678A';

-- ------------------------------
-- CONSULTAS SOBRE LA TABLA "cars"
-- ------------------------------

-- INSERT: Agrega un nuevo coche a la tabla.
INSERT INTO cars (matricula, numero_bastidor, marca, modelo, color, tipo_coche, num_plazas, num_puertas, tipo_combustible)
VALUES ('ABC123', 'BAS123456789', 'Ford', 'Mustang', 'Rojo', 'Deportivo', 4, 2, 'gasolina');

-- UPDATE: Actualiza la información de un coche existente (por ejemplo, cambiar el color).
UPDATE cars
SET color = 'Azul'
WHERE matricula = 'ABC123';

-- DELETE: Elimina un coche de la tabla mediante su matrícula.
DELETE FROM cars
WHERE matricula = 'ABC123';

-- SELECT: Muestra todos los coches disponibles.
SELECT * FROM cars;

-- SELECT: Busca un coche por su matrícula.
SELECT * FROM cars
WHERE matricula = 'ABC123';

-- SELECT: Busca coches por tipo.
SELECT * FROM cars
WHERE tipo_coche = 'Deportivo';

-- SELECT: Busca coches por marca.
SELECT * FROM cars
WHERE marca = 'Ford';

-- ------------------------------
-- CONSULTAS SOBRE LA TABLA "rentals"
-- ------------------------------

-- INSERT: Registra un nuevo alquiler.
INSERT INTO rentals (client_dni, car_matricula, fecha_prestamo, dias, precio_dia, lugar_devolucion, deposito_lleno, tipo_seguro, penalizacion, fecha_devolucion, devuelto)
VALUES ('12345678A', 'ABC123', '2025-04-15', 5, 80.00, 'Aeropuerto', true, 'amb franquícia', 0.00, '2025-04-20', false);

-- UPDATE: Actualiza la información de un alquiler (por ejemplo, marcar como devuelto y actualizar penalización si se retrasa).
UPDATE rentals
SET devuelto = true, penalizacion = 20.00
WHERE id = 1;

-- DELETE: Elimina un alquiler de la tabla mediante su ID.
DELETE FROM rentals
WHERE id = 1;

-- SELECT: Muestra todos los alquileres.
SELECT * FROM rentals;

-- SELECT: Busca un alquiler por su ID.
SELECT * FROM rentals
WHERE id = 1;

-- SELECT: Obtén todos los alquileres activos (no devueltos).
SELECT * FROM rentals
WHERE devuelto = false;

-- ====================================================
-- CONSULTAS CON JOINS (CONSULTAS MULTI-TABLA)
-- ====================================================

-- Consulta que muestra información de los alquileres activos junto con datos del cliente y del coche.
SELECT
    r.id,
    r.fecha_prestamo,
    r.dias,
    c.nombre,
    c.apellidos,
    c.telefono,
    ca.marca,
    ca.modelo,
    ca.matricula
FROM rentals r
         JOIN clients c ON r.client_dni = c.dni
         JOIN cars ca ON r.car_matricula = ca.matricula
WHERE r.devuelto = false;

-- ====================================================
-- CONSULTAS AVANZADAS (EJEMPLOS)
-- ====================================================

-- Consulta para calcular el precio final de un alquiler (precio_dia * dias) para cada alquiler.
SELECT
    id,
    (precio_dia * dias) AS precio_final
FROM rentals;

-- Consulta para obtener el número total de alquileres por cliente.
SELECT
    client_dni,
    COUNT(*) AS total_alquileres
FROM rentals
GROUP BY client_dni;

-- Consulta para listar los coches que nunca han sido alquilados.
SELECT *
FROM cars
WHERE matricula NOT IN (
    SELECT DISTINCT car_matricula FROM rentals
);

-- ====================================================
-- FIN DEL SCRIPT
-- ====================================================
