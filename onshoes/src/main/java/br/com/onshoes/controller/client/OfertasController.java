package br.com.onshoes.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.onshoes.model.Produto.Produto;

import br.com.onshoes.service.client.ProdutoService;

@Controller
@RequestMapping("/ofertas")
public class OfertasController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public String listarOfertas(
            @PageableDefault(size = 8, sort = "nome") Pageable pageable, 
            Model model) {

        Page<Produto> paginaDeOfertas = produtoService.findOfertas(pageable);

        model.addAttribute("pagina", paginaDeOfertas);

        return "client/ofertas";
    }
}