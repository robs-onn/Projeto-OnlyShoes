--Pedido -> Usuario
ALTER TABLE pedido ADD CONSTRAINT fk_pedido_usuario
FOREIGN KEY (usuario_codigo) REFERENCES usuario(codigo);

--Pedido -> Pagamento
ALTER TABLE pedido ADD CONSTRAINT fk_pedido_pagamento
FOREIGN KEY (pagamento_codigo) REFERENCES pagamento(codigo);

--Pedido -> Envio
ALTER TABLE pedido ADD CONSTRAINT fk_pedido_envio
FOREIGN KEY (envio_codigo) REFERENCES envio(codigo);

--ItemPedido -> Produto
ALTER TABLE item_pedido ADD CONSTRAINT fk_item_pedido_produto
FOREIGN KEY (produto_codigo) REFERENCES produto(codigo);

--ItemPedido -> Pedido
ALTER TABLE item_pedido ADD CONSTRAINT fk_item_pedido_pedido
FOREIGN KEY (pedido_codigo) REFERENCES pedido(codigo);