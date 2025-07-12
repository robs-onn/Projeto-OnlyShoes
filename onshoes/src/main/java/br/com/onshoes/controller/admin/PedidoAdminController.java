package br.com.onshoes.controller.admin;

import br.com.onshoes.model.Pedido.Pedido;
import br.com.onshoes.repository.PedidoRepository;
import br.com.onshoes.service.admin.PedidoAdminService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/pedidos")
public class PedidoAdminController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoAdminService pedidoService;

    @GetMapping
    public String listarPedidos(Model model) {
        List<Pedido> pedidos = pedidoRepository.findAll();
        model.addAttribute("pedidos", pedidos);
        return "admin/pedidos/listar";
    }

    @GetMapping("/{id}")
    public String visualizar(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoService.buscarPorId(id);
        if (pedido == null) return "redirect:/admin/pedidos";
        model.addAttribute("pedido", pedido);
        return "admin/pedido-detalhe";
    }

    @PostMapping("/{id}/status")
    public String alterarStatus(@PathVariable Long id, @RequestParam String status) {
        pedidoService.atualizarStatus(id, status);
        return "redirect:/admin/pedidos";
    }
}
