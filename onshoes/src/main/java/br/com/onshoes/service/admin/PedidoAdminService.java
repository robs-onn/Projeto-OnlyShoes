package br.com.onshoes.service.admin;

import br.com.onshoes.model.Pedido.Pedido;
import br.com.onshoes.model.Pedido.StatusPedido;
import br.com.onshoes.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoAdminService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public void atualizarStatus(Long id, String novoStatus) {
        Pedido pedido = buscarPorId(id);
        if (pedido != null) {
            pedido.setStatus(StatusPedido.valueOf(novoStatus));
            pedidoRepository.save(pedido);
        }
    }
}
