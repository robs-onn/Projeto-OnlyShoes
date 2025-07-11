package br.com.onshoes.controller.client;

import br.com.onshoes.model.Produto.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import br.com.onshoes.service.client.ProdutoService;

@Controller
public class BuscarController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/buscar")
    public String buscarProdutos(
            @RequestParam(value = "q", required = false) String query,
            @PageableDefault(size = 8, sort = "nome") Pageable pageable,
            Model model) {

        Page<Produto> paginaDeResultados = produtoService.search(query, pageable);

        model.addAttribute("pagina", paginaDeResultados);
        model.addAttribute("query", query);

        return "client/resultado-busca";
    }
}