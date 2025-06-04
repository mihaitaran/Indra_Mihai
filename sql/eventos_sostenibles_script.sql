CREATE DATABASE eventos_sostenibles;
USE eventos_sostenibles;


CREATE TABLE Organizador (
    Id_organizador CHAR(5) NOT NULL,
    Nombre VARCHAR(100) NOT NULL,
    Telefono CHAR(13) NOT NULL CHECK (Telefono REGEXP '^\\+[0-9]{2} [0-9]{9}$'),
    Correo VARCHAR(100) NOT NULL,
    PRIMARY KEY (Id_organizador)
);


CREATE TABLE Evento (
    Id_organizador VARCHAR(5) NOT NULL,
    Id_evento CHAR(5) NOT NULL,
    Nombre VARCHAR(100) NOT NULL,
    Duracion INT NOT NULL,
    Tipo VARCHAR(20) NOT NULL CHECK (Tipo IN ('conferencia', 'taller', 'actividad')),
    Fecha DATETIME NOT NULL,
    PRIMARY KEY (Id_organizador, Id_evento),
    FOREIGN KEY (Id_organizador) REFERENCES Organizador(Id_organizador)
);


CREATE TABLE Fisico (
    Id_organizador CHAR(5) NOT NULL,
    Id_evento CHAR(5) NOT NULL,
    Id_fisico CHAR(5) NOT NULL,
    Lugar VARCHAR(300) NOT NULL,
    Ciudad VARCHAR(100) NOT NULL,
    Provincia VARCHAR(100) NOT NULL,
    PRIMARY KEY (Id_organizador, Id_evento, Id_fisico),
    FOREIGN KEY (Id_organizador, Id_evento) REFERENCES Evento(Id_organizador, Id_evento)
);


CREATE TABLE Online (
    Id_organizador CHAR(5) NOT NULL,
    Id_evento CHAR(5) NOT NULL,
    Id_online CHAR(5) NOT NULL,
    Sitio_web VARCHAR(200) NOT NULL,
    PRIMARY KEY (Id_organizador, Id_evento, Id_online),
    FOREIGN KEY (Id_organizador, Id_evento) REFERENCES Evento(Id_organizador, Id_evento)
);


CREATE TABLE Usuario (
    Id_usuario CHAR(5) NOT NULL,
    Nombre VARCHAR(100) NOT NULL,
    Correo VARCHAR(200) NOT NULL,
    Contrasena VARCHAR(100) NOT NULL,
    PRIMARY KEY (Id_usuario)
);


CREATE TABLE Registrarse (
    Id_usuario CHAR(5) NOT NULL,
    Id_organizador CHAR(5) NOT NULL,
    Id_evento CHAR(5) NOT NULL,
    PRIMARY KEY (Id_usuario, Id_organizador, Id_evento),
    FOREIGN KEY (Id_usuario) REFERENCES Usuario(Id_usuario),
    FOREIGN KEY (Id_organizador, Id_evento) REFERENCES Evento(Id_organizador, Id_evento)
);
