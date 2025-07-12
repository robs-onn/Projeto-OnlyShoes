package br.com.onshoes.controller.admin;

import br.com.onshoes.model.Usuario.Usuario;
import br.com.onshoes.model.Usuario.StatusUsuario;
import br.com.onshoes.model.Usuario.TipoUsuario;
import br.com.onshoes.repository.UsuarioRepository;
import br.com.onshoes.service.admin.UsuarioAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin/usuarios")
public class UsuarioAdminController {

    @Autowired
    private UsuarioAdminService usuarioService;

    @Autowired
    private final PasswordEncoder passwordEncoder = null;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "admin/usuarios/listar"; // Caminho relativo dentro de templates
    }

    @PostMapping
    public String salvar(@ModelAttribute Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuario.setStatus(StatusUsuario.ATIVO);
        usuarioRepository.save(usuario);
        return "redirect:/admin/usuarios";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("papeis", TipoUsuario.values());
        model.addAttribute("statusList", StatusUsuario.values());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "admin/usuarios/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            model.addAttribute("tipos", TipoUsuario.values());
            return "admin/usuarios/formulario";
        } else {
            return "redirect:/admin/usuarios";
        }
    }

    @GetMapping("/excluir/{id}")
    public String excluirUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return "redirect:/admin/usuarios";
    }

    @GetMapping("/status/{id}")
    public String alterarStatus(@PathVariable Long id) {
        usuarioService.alterarStatus(id);
        return "redirect:/admin/usuarios";
    }
}
