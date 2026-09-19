CREATE DATABASE IF NOT EXISTS uc11;
USE uc11;

DROP TABLE IF EXISTS produtos;

CREATE TABLE IF NOT EXISTS produtos (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome TEXT,
    valor INT,
    status TEXT,
    PRIMARY KEY (id)
);

INSERT INTO produtos (id, nome, valor, status) VALUES
    (2, 'PS4', 1500, 'Vendido'),
    (3, 'Xbox 360', 800, 'Vendido'),
    (4, 'Iphone 12', 4800, 'Vendido'),
    (5, 'PS2', 400, 'A Venda');
