DROP DATABASE IF EXISTS locadoraDeJogos;
CREATE DATABASE locadoraDeJogos;
USE locadoraDeJogos;

CREATE TABLE jogo(
	id int auto_increment primary key,
    nome varchar(30) not null,
    desenvolvedor varchar(30) not null,
    dataLancamento varchar(10) not null,
    plataforma varchar(30) not null,
    preco float not null,
    alugado boolean 
);

CREATE TABLE cliente(
	id int auto_increment primary key,
    nome varchar(30) not null,
    idade int not null,
    endereco varchar(50),
    telefone varchar(15),
    email varchar(30)
);

CREATE TABLE alugado(
	id int auto_increment primary key,
	data_alugado varchar(10) not null,
    data_devolucao varchar(10) not null,
    cliente_id int,
    jogo_id int,
    CONSTRAINT fk_cliente
    FOREIGN KEY (cliente_id) REFERENCES cliente(id) 
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	CONSTRAINT fk_jogo
    FOREIGN KEY (jogo_id) REFERENCES jogo(id) 
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);

select * from jogo;
select * from cliente;
select * from alugado;