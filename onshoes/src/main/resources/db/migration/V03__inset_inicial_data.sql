-- Inserção do user inical
INSERT INTO usuario(codigo, username, email, senha, nome, papel, status, data_criacao)
VALUES (nextval('usuario_codigo_seq'), 'admin', 'admin@onshoes.com.br', '$2a$10$iHKBsODntb24M.YatHohc.CPvDIwpniTcIgFAGi3r0Tmv2DLfIlsq', 'Admin do Sistema', 'ADMIN', 'ATIVO', '2025-07-09T13:24:46');


-- Inserção dos produtos iniciais
INSERT INTO produto (codigo, nome, descricao, marca, modelo, cor, preco, categoria, status, preco_promocional) VALUES
(nextval('produto_codigo_seq')  , 'Nike Air Force 1', 'Tênis clássico e atemporal da Nike', 'Nike', 'Air Force 1', 'Branco', 599.90, 'PRIMEIRA_LINHA', 'ATIVO', NULL),
(nextval('produto_codigo_seq'), 'Adidas Ultraboost', 'Tênis de corrida com tecnologia Boost', 'Adidas', 'Ultraboost 22', 'Preto', 799.90, 'PRIMEIRA_LINHA', 'ATIVO', NULL),
(nextval('produto_codigo_seq'), 'Jordan 1 Retro High', 'Lenda do basquete em versão retrô', 'Nike', 'Jordan 1', 'Chicago', 1299.90, 'PREMIUM', 'ATIVO', NULL),
(nextval('produto_codigo_seq'), 'Balenciaga Triple S', 'Sneaker de luxo com design futurista', 'Balenciaga', 'Triple S', 'Branco/Preto', 4999.90, 'IMPORTADO', 'ATIVO', NULL),
(nextval('produto_codigo_seq'), 'Gucci Ace', 'Tênis de couro com detalhes da marca', 'Gucci', 'Ace', 'Branco', 3999.90, 'IMPORTADO', 'ATIVO', NULL);