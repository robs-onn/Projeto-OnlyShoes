--SEQUÊNCIAS
CREATE SEQUENCE usuario_codigo_seq START 1 INCREMENT 1;
CREATE SEQUENCE produto_codigo_seq START 1 INCREMENT 1;
CREATE SEQUENCE pedido_codigo_seq START 1 INCREMENT 1;
CREATE SEQUENCE item_pedido_codigo_seq START 1 INCREMENT 1;
CREATE SEQUENCE pagamento_codigo_seq START 1 INCREMENT 1;
CREATE SEQUENCE envio_codigo_seq START 1 INCREMENT 1;

--TABELAS
CREATE TABLE usuario (
    codigo BIGINT NOT NULL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(20),
    papel VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL,
    data_criacao TIMESTAMP NOT NULL
);

CREATE TABLE produto (
    codigo BIGINT NOT NULL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL,
    marca VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    cor VARCHAR(100),
    preco DECIMAL(10, 2) NOT NULL,
    preco_promocional DECIMAL(10, 2),
    categoria VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL,
    imagem_principal VARCHAR(255)
);

CREATE TABLE pagamento (
    codigo BIGINT NOT NULL PRIMARY KEY,
    data_pagamento TIMESTAMP,
    valor_pago DECIMAL(10, 2) NOT NULL,
    status VARCHAR(50) NOT NULL,
    tipo_pagamento VARCHAR(50) NOT NULL
);

CREATE TABLE envio (
    codigo BIGINT NOT NULL PRIMARY KEY,
    endereco_entrega VARCHAR(255) NOT NULL,
    data_envio TIMESTAMP,
    metodo VARCHAR(50) NOT NULL,
    codigo_rastreamento VARCHAR(100)
);

CREATE TABLE pedido (
    codigo BIGINT NOT NULL PRIMARY KEY,
    usuario_codigo BIGINT NOT NULL,
    pagamento_codigo BIGINT UNIQUE,
    envio_codigo BIGINT UNIQUE,
    data_pedido TIMESTAMP NOT NULL,
    data_entrega TIMESTAMP,
    valor_total DECIMAL(10, 2) NOT NULL,
    status VARCHAR(50) NOT NULL
);

CREATE TABLE item_pedido (
    codigo BIGINT NOT NULL PRIMARY KEY,
    produto_codigo BIGINT NOT NULL,
    pedido_codigo BIGINT NOT NULL,
    quantidade INTEGER NOT NULL,
    preco_unitario DECIMAL(10, 2) NOT NULL
);