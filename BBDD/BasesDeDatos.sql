DROP DATABASE IF EXISTS schema_bbdd;
CREATE DATABASE IF NOT EXISTS schema_bbdd;
USE schema_bbdd;


-- Tabla Consola
CREATE TABLE Consola (
    ID 						INT AUTO_INCREMENT PRIMARY KEY,
    Nombre 					VARCHAR(50) NOT NULL,
    Empresa_desarrolladora 	VARCHAR(100) NOT NULL
);

-- Tabla Usuario
CREATE TABLE Usuario (
    ID 						INT AUTO_INCREMENT PRIMARY KEY,
    Nombre 					VARCHAR(50) NOT NULL,
    Apellidos 				VARCHAR(100) NOT NULL,
    Usuario 				VARCHAR(30) NOT NULL UNIQUE,
    Contasena				VARCHAR(30) NOT NULL,
    Correo 					VARCHAR(100) NOT NULL UNIQUE,
    Fecha_Nacimiento 		DATE NOT NULL
);

CREATE TABLE Empresa (
    CIF 					INT AUTO_INCREMENT PRIMARY KEY,
	Nombre					VARCHAR(50) NOT NULL,
    Contasena				VARCHAR(30) NOT NULL,
    Correo 					VARCHAR(100) NOT NULL UNIQUE
);

-- Tabla Videojuegos
CREATE TABLE Videojuegos (
    ID 						INT AUTO_INCREMENT PRIMARY KEY,
    Consola_ID 				INT NOT NULL,
    Nombre 					VARCHAR(100) NOT NULL,
    Genero 					ENUM('ACCION', 'AVENTURA', 'CATASTROFE', 'CIENCIA_FICCION', 'COMEDIA', 'DOCUMENTALES', 'DRAMA', 'FANTASIA'),
    Desarrollador 			VARCHAR(100) NOT NULL,
    Precio 					DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (Consola_ID) REFERENCES Consola(ID)
);

-- Tabla Valoracion_usuario
CREATE TABLE Valoracion_Usuario (
    ID 						INT AUTO_INCREMENT PRIMARY KEY,
    Videojuego_ID 			INT NOT NULL,
    Usuario_ID 				INT NOT NULL,
    Puntuacion 				TINYINT NOT NULL CHECK (Puntuacion BETWEEN 1 AND 100),
    Comentario 				TEXT,
    Fecha_valoracion 		TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (Videojuego_ID) REFERENCES Videojuegos(ID),
    FOREIGN KEY (Usuario_ID) REFERENCES Usuario(ID),
    UNIQUE KEY (Videojuego_ID, Usuario_ID) -- Para que un usuario solo pueda valorar un juego una vez
);

-- Tabla Valoracion_empresa
CREATE TABLE Valoracion_Empresa (
    ID 						INT AUTO_INCREMENT PRIMARY KEY,
    Videojuego_ID 			INT NOT NULL,
    Empresa_CIF				INT NOT NULL,
    Puntuacion 				TINYINT NOT NULL CHECK (Puntuacion BETWEEN 1 AND 100),
    Comentario 				TEXT,
    Fecha_valoracion 		TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (Videojuego_ID) REFERENCES Videojuegos(ID),
    FOREIGN KEY (Empresa_CIF) REFERENCES Empresa(CIF),
    UNIQUE KEY (Videojuego_ID, Empresa_CIF) -- Para que un usuario solo pueda valorar un juego una vez
);

INSERT INTO Consola (Nombre, Empresa_desarrolladora) VALUES 
('PlayStation 5', 'Sony Interactive Entertainment'),
('Xbox Series X', 'Microsoft'),
('Nintendo Switch', 'Nintendo'),
('PC', 'Varios'),
('PlayStation 4', 'Sony Interactive Entertainment');

INSERT INTO Usuario (Nombre, Apellidos, Usuario, Contasena, Correo, Fecha_Nacimiento) VALUES 
('Juan', 'Pérez García', 'juanpg', 'password123', 'juan.perez@email.com', '1990-05-15'),
('María', 'López Martínez', 'marialm', 'securepass', 'maria.lopez@email.com', '1985-08-22'),
('Carlos', 'González Ruiz', 'carlosgr', 'mypass123', 'carlos.gonzalez@email.com', '1995-03-10'),
('Ana', 'Martín Sánchez', 'anams', 'anapass', 'ana.martin@email.com', '1992-11-30'),
('David', 'Fernández Castro', 'davidfc', 'davidpass', 'david.fernandez@email.com', '1988-07-18');

INSERT INTO Empresa (Nombre, Contasena, Correo) VALUES 
('Electronic Arts', 'eapassword', 'contact@ea.com'),
('Ubisoft', 'ubipass123', 'info@ubisoft.com'),
('Activision Blizzard', 'actipass', 'contact@activision.com'),
('Square Enix', 'squarepass', 'info@squareenix.com'),
('Capcom', 'cappass', 'contact@capcom.com');

INSERT INTO Videojuegos (Consola_ID, Nombre, Genero, Desarrollador, Precio) VALUES 
(1, 'God of War Ragnarök', 'ACCION', 'Santa Monica Studio', 69.99),
(2, 'Halo Infinite', 'CIENCIA_FICCION', '343 Industries', 59.99),
(3, 'The Legend of Zelda: Breath of the Wild', 'AVENTURA', 'Nintendo EPD', 59.99),
(4, 'Cyberpunk 2077', 'CIENCIA_FICCION', 'CD Projekt Red', 49.99),
(5, 'The Last of Us Part II', 'DRAMA', 'Naughty Dog', 39.99);

INSERT INTO Valoracion_Usuario (Videojuego_ID, Usuario_ID, Puntuacion, Comentario) VALUES 
(1, 1, 95, 'Increíble experiencia de juego, gráficos asombrosos'),
(1, 2, 90, 'Muy buena historia pero algo corto'),
(2, 3, 85, 'Multiplayer excelente, campaña regular'),
(3, 4, 100, 'La mejor aventura que he jugado en años'),
(4, 5, 75, 'Buen RPG pero con muchos bugs al lanzamiento');

INSERT INTO Valoracion_Empresa (Videojuego_ID, Empresa_CIF, Puntuacion, Comentario) VALUES 
(1, 2, 90, 'Excelente trabajo de Santa Monica Studio'),
(1, 3, 92, 'Referente en juegos de acción para PS5'),
(2, 1, 85, 'Buen shooter pero necesita más contenido'),
(2, 4, 88, '343 Industries hizo un gran trabajo'),
(3, 5, 100, 'Obra maestra que redefine el género');


