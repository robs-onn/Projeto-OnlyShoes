package br.com.onshoes.controller.client;

import br.com.onshoes.model.Produto.CategoriaProduto;
import br.com.onshoes.model.Produto.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import br.com.onshoes.service.client.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public String listarProdutos(
            @RequestParam(value = "categoria", required = false) CategoriaProduto categoria,
            @PageableDefault(size = 8, sort = "nome") Pageable pageable, 
            Model model) {

        Page<Produto> paginaDeProdutos = produtoService.findAtivosByCategoria(categoria, pageable);

        model.addAttribute("pagina", paginaDeProdutos);
        model.addAttribute("categoriaFiltro", categoria);

        return "client/produtos";
    }

    @GetMapping("/{codigo}")
    public String detalheProduto(@PathVariable("codigo") Long codigo, Model model) {

        Produto produto = produtoService.findById(codigo);

        if (produto == null) {
            return "error/404";
        }
        model.addAttribute("produto", produto);
        return "client/produto-detalhe";
    }
}