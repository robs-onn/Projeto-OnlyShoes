    CREATE TABLE usuario (
        id BIGSERIAL PRIMARY KEY,
        nome VARCHAR(100),
        email VARCHAR(100) UNIQUE,
        senha VARCHAR(100),
        cpf VARCHAR(14) UNIQUE,
        endereco VARCHAR(100)
    );

    CREATE TABLE produto (
        id BIGSERIAL PRIMARY KEY,
        nome VARCHAR(100),
        descricao TEXT,
        categoria VARCHAR(100),
        preco NUMERIC(10,2),
        estoque INTEGER
    );

    CREATE TABLE pagamento (
        id BIGSERIAL PRIMARY KEY,
        data_pagamento TIMESTAMP,
        valor_pago NUMERIC(10,2),
        status VARCHAR(50),
        tipo_pagamento VARCHAR(50)
    );

    CREATE TABLE envio (
        id BIGSERIAL PRIMARY KEY,
        endereco_entrega VARCHAR(200),
        status VARCHAR(50),
        data_envio TIMESTAMP,
        metodo VARCHAR(50),
        codigo_rastreamento VARCHAR(100)
    );

    CREATE TABLE pedido (
        id BIGSERIAL PRIMARY KEY,
        data_hora TIMESTAMP,
        data_entrega TIMESTAMP,
        valor_total NUMERIC(10,2),
        status VARCHAR(50),

        usuario_id BIGINT REFERENCES usuario(id),
        pagamento_id BIGINT UNIQUE REFERENCES pagamento(id),
        envio_id BIGINT UNIQUE REFERENCES envio(id)
    );

    CREATE TABLE item_pedido (
        id BIGSERIAL PRIMARY KEY,
        quantidade INTEGER,
        preco_unitario NUMERIC(10,2),

        pedido_id BIGINT REFERENCES pedido(id),
        produto_id BIGINT REFERENCES produto(id)
    );

    -- Tabela de junção para produtos no carrinho do usuário (Many-to-Many)
    CREATE TABLE produtos_carrinho ( 
        usuario_id BIGINT NOT NULL,
        produto_id BIGINT NOT NULL,
        PRIMARY KEY (usuario_id, produto_id),
        FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE,
        FOREIGN KEY (produto_id) REFERENCES produto(id) ON DELETE CASCADE
    );

    -- Tabela de junção para produtos favoritos do usuário (Many-to-Many)
    CREATE TABLE produtos_favoritos_usuario (
        usuario_id BIGINT NOT NULL,
        produto_id BIGINT NOT NULL,
        PRIMARY KEY (usuario_id, produto_id),
        FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE,
        FOREIGN KEY (produto_id) REFERENCES produto(id) ON DELETE CASCADE
    );
    