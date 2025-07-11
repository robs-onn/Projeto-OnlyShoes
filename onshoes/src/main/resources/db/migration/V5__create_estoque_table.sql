

CREATE SEQUENCE estoque_codigo_seq START 1 INCREMENT 1;

CREATE TABLE estoque (
    codigo BIGINT NOT NULL PRIMARY KEY,
    tamanho INTEGER NOT NULL,
    quantidade INTEGER NOT NULL,
    produto_codigo BIGINT NOT NULL,
    CONSTRAINT fk_estoque_produto FOREIGN KEY (produto_codigo) REFERENCES produto(codigo)
);

INSERT INTO estoque (codigo, tamanho, quantidade, produto_codigo) VALUES
(nextval('estoque_codigo_seq'), 40, 10, 1),
(nextval('estoque_codigo_seq'), 41, 15, 1),
(nextval('estoque_codigo_seq'), 42, 5, 1);

INSERT INTO estoque (codigo, tamanho, quantidade, produto_codigo) VALUES
(nextval('estoque_codigo_seq'), 39, 8, 2),
(nextval('estoque_codigo_seq'), 40, 12, 2);

INSERT INTO estoque (codigo, tamanho, quantidade, produto_codigo) VALUES
(nextval('estoque_codigo_seq'), 42, 7, 3),
(nextval('estoque_codigo_seq'), 43, 3, 3);

INSERT INTO estoque (codigo, tamanho, quantidade, produto_codigo) VALUES
(nextval('estoque_codigo_seq'), 38, 2, 4),
(nextval('estoque_codigo_seq'), 40, 3, 4);

INSERT INTO estoque (codigo, tamanho, quantidade, produto_codigo) VALUES
(nextval('estoque_codigo_seq'), 41, 5, 5);

INSERT INTO estoque (codigo, tamanho, quantidade, produto_codigo) VALUES
(nextval('estoque_codigo_seq'), 39, 20, 6),
(nextval('estoque_codigo_seq'), 40, 25, 6),
(nextval('estoque_codigo_seq'), 41, 18, 6);

INSERT INTO estoque (codigo, tamanho, quantidade, produto_codigo) VALUES
(nextval('estoque_codigo_seq'), 38, 30, 7),
(nextval('estoque_codigo_seq'), 39, 35, 7),
(nextval('estoque_codigo_seq'), 40, 0, 7), -- Tamanho 40 sem estoque
(nextval('estoque_codigo_seq'), 41, 10, 7),
(nextval('estoque_codigo_seq'), 42, 20, 7);

INSERT INTO estoque (codigo, tamanho, quantidade, produto_codigo) VALUES
(nextval('estoque_codigo_seq'), 40, 11, 8),
(nextval('estoque_codigo_seq'), 41, 9, 8);

INSERT INTO estoque (codigo, tamanho, quantidade, produto_codigo) VALUES
(nextval('estoque_codigo_seq'), 42, 14, 9),
(nextval('estoque_codigo_seq'), 43, 8, 9);

INSERT INTO estoque (codigo, tamanho, quantidade, produto_codigo) VALUES
(nextval('estoque_codigo_seq'), 40, 22, 10);

INSERT INTO estoque (codigo, tamanho, quantidade, produto_codigo) VALUES
(nextval('estoque_codigo_seq'), 41, 6, 11),
(nextval('estoque_codigo_seq'), 42, 4, 11);

INSERT INTO estoque (codigo, tamanho, quantidade, produto_codigo) VALUES
(nextval('estoque_codigo_seq'), 37, 18, 12),
(nextval('estoque_codigo_seq'), 38, 15, 12);

INSERT INTO estoque (codigo, tamanho, quantidade, produto_codigo) VALUES
(nextval('estoque_codigo_seq'), 42, 1, 13);