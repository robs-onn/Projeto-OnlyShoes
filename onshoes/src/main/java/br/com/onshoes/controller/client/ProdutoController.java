package br.com.onshoes.controller.client;

import br.com.onshoes.model.Produto.Produto;
import br.com.onshoes.model.Produto.StatusProduto;
import br.com.onshoes.repository.client.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoRepository.findByStatus(StatusProduto.ATIVO);
        model.addAttribute("produtos", produtos);
        return "client/produtos";
    }

    @GetMapping("/{codigo}")
    public String detalheProduto(@PathVariable("codigo") Long codigo, Model model) {
        // Busca o produto no banco pelo código fornecido na URL
        Optional<Produto> produtoOpt = produtoRepository.findById(codigo);

        // Se o produto não for encontrado, redireciona para a página de erro 404
        if (produtoOpt.isEmpty()) {
            return "error/404";
        }

        // Se encontrou, adiciona o produto ao modelo e renderiza a página de detalhe
        model.addAttribute("produto", produtoOpt.get());
        return "client/produto-detalhe";
    }
}