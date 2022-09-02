
DROP DATABASE IF EXISTS loja;
CREATE DATABASE loja;

USE loja;


CREATE TABLE produtos (
	id INTEGER NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(40) NOT NULL,
	preco DECIMAL(10, 2) NOT NULL,
	PRIMARY KEY (id)
);

INSERT INTO produtos (descricao, preco) VALUES ('Geladeira', 4600);
INSERT INTO produtos (descricao, preco) VALUES ('Máquina de lavar', 2300);
INSERT INTO produtos (descricao, preco) VALUES ('TV', 2700);


CREATE TABLE usuarios (
	id INTEGER NOT NULL AUTO_INCREMENT,
	username VARCHAR(10) NOT NULL,
	password VARCHAR(20) NOT NULL,
	PRIMARY KEY (id)
);


INSERT INTO usuarios (username, password) VALUES ('alice', 'abc123');
INSERT INTO usuarios (username, password) VALUES ('bob', '123qwe'); 
INSERT INTO usuarios (username, password) VALUES ('charlie', 'asdfg');
 


 