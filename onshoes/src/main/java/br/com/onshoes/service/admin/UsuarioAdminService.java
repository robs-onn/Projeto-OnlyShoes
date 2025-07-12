package br.com.onshoes.service.admin;

import br.com.onshoes.model.Usuario.StatusUsuario;
import br.com.onshoes.model.Usuario.TipoUsuario;
import br.com.onshoes.model.Usuario.Usuario;
import br.com.onshoes.repository.admin.UsuarioAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioAdminService {

    @Autowired
    private UsuarioAdminRepository usuarioRepository;

    public Page<Usuario> listarTodosClientes(int page, int size) {
        return usuarioRepository.findByPapel(TipoUsuario.CLIENTE, PageRequest.of(page, size));
    }
  
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }

    public void salvar(Usuario usuario) {
        
    usuarioRepository.save(usuario);
}

public void alterarStatus(Long id) {
    Optional<Usuario> usuario = usuarioRepository.findById(id);
    usuario.ifPresent(u -> {
        if (u.getStatus() == StatusUsuario.ATIVO) {
            u.setStatus(StatusUsuario.INATIVO);
        } else {
            u.setStatus(StatusUsuario.ATIVO);
        }
        usuarioRepository.save(u);
    });
}

}
