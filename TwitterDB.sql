CREATE DATABASE TWITTER;

USE TWITTER;

CREATE TABLE usuario(
	correoE varchar(200) Primary Key Not null,
	Nombre varchar(200),
	foto varbinary(1000),
	contrasena varchar(100),
	NoTweets int,
	NoSeguidores int
);

insert into usuario values('amrkratos@hotmail.com', 'Alejandro Martinez', null, 'hola1', 0, 0);

SELECT * FROM USUARIOS;