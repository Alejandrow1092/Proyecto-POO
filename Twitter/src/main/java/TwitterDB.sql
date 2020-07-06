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

CREATE TABLE tweet(
    Fecha date,
    Usuario1 varchar (200),
    NoTweet int,
    primary key(Usuario1, NoTweet),
    foreign key (Usuario1) references usuario(correoE)
);

CREATE TABLE seguidor(
    CorreoE1 varchar (100),
    CorreoE2 varchar (100),
    primary key (CorreoE1, CorreoE2),
    foreign key (CorreoE1) references usuario (correoE),
    foreign key (CorreoE2) references usuario (correoE)
);



insert into usuario values('amrkratos@hotmail.com', 'Alejandro Martinez', null, 'hola1', 0, 0);
insert into usuario values('juanito@hotmail.com', 'Juan Alvarez', null, 'hola12', 0, 0);
insert into usuario values('lopez@hotmail.com', 'Lopez Eliot', null, 'hola13', 0, 0);
insert into usuario values('pedro@hotmail.com', 'Pedro Emilio', null, 'hola14', 0, 0);
insert into usuario values('axxx@hotmail.com', 'Andrea Morones', null, 'hola15', 0, 0);




SELECT * FROM USUARIOS;
