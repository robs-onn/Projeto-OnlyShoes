package br.com.onshoes.repository;

import br.com.onshoes.model.Pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
