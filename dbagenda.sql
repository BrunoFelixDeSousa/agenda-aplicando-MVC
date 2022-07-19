create database dbagenda;

show databases;

use dbagenda;

create table contato(
	idcon int primary key auto_increment,
    nome varchar(50) not null,
    fone varchar(15) not null,
    email varchar(50)
);

show tables;

describe contato;