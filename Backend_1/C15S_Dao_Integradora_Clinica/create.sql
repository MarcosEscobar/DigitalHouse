CREATE TABLE IF NOT EXISTS domicilios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    calle VARCHAR(50) NOT NULL,
    numero INT NOT NULL,
    localidad VARCHAR(50) NOT NULL,
    provincia VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS pacientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    dni INT NOT NULL,
    fechaIngreso DATE,
    domicilioID INT,
    FOREIGN KEY (domicilioID) REFERENCES domicilios(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

INSERT INTO domicilios (calle, numero, localidad, provincia) VALUES ('Calle Falsa', 123, 'Springfield', 'Springfield');