package br.com.onshoes.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import br.com.onshoes.model.Carrinho.Carrinho;
import br.com.onshoes.model.Produto.Produto;
import br.com.onshoes.repository.client.queries.ProdutoRepository;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    private Carrinho getOrCreateCarrinho(HttpSession session) {
        Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
        if (carrinho == null) {
            carrinho = new Carrinho();
            session.setAttribute("carrinho", carrinho);
        }
        return carrinho;
    }

    @GetMapping
    public String exibirCarrinho(HttpSession session, Model model) {
        model.addAttribute("carrinho", getOrCreateCarrinho(session));
        return "client/carrinho";
    }

    @PostMapping("/adicionar")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> adicionarAoCarrinho(
            @RequestParam("codigo") Long codigo,
            @RequestParam(value = "quantidade", defaultValue = "1") Integer quantidade,
            @RequestParam(value = "tamanho", required = false) Integer tamanho,
            HttpSession session) {
        
        if (tamanho == null) {
            throw new IllegalArgumentException("O tamanho deve ser selecionado.");
        }

        Produto produto = produtoRepository.findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Produto inválido: " + codigo));

        Carrinho carrinho = getOrCreateCarrinho(session);

        carrinho.adicionarItem(produto, tamanho, quantidade);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("quantidadeTotal", carrinho.getQuantidadeTotalDeItens());

        return ResponseEntity.ok(response);
    }
    @PostMapping("/remover")
    public String removerDoCarrinho(@RequestParam("codigo") Long codigo, 
                                      @RequestParam("tamanho") Integer tamanho, 
                                      HttpSession session) {
                                        
        Carrinho carrinho = getOrCreateCarrinho(session);
        carrinho.removerItem(codigo, tamanho);
        
        return "redirect:/carrinho";
    }
}