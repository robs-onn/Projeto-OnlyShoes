package br.com.onshoes.controller.admin;

import br.com.onshoes.model.Produto.Produto;
import br.com.onshoes.model.Usuario.Usuario;
import br.com.onshoes.repository.ProdutoRepository;
import br.com.onshoes.repository.UsuarioRepository;
import br.com.onshoes.service.admin.ProdutoAdminService;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/produtos")
public class ProdutoAdminController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoAdminService produtoAdminService;

    @Autowired
    private final PasswordEncoder passwordEncoder = null;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "admin/produtos/produtos-listar";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("produto", new Produto());
        return "admin/produto-form";
    }

    @PostMapping
public String salvarUsuario(@ModelAttribute Usuario usuario) {
    usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
    usuario.setDataCriacao(LocalDateTime.now());
    usuarioRepository.save(usuario);
    return "redirect:/admin/usuarios";
}

    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {
        Produto produto = produtoAdminService.buscarPorId(id);
        if (produto == null) return "redirect:/admin/produtos";
        model.addAttribute("produto", produto);
        return "admin/produto-form";
    }

    @PostMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        produtoAdminService.excluir(id);
        return "redirect:/admin/produtos";
    }

    @PostMapping("/{id}/status")
    public String alterarStatus(@PathVariable Long id) {
        produtoAdminService.alterarStatus(id);
        return "redirect:/admin/produtos";
    }
}
