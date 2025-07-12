package br.com.onshoes.repository.admin;

import br.com.onshoes.model.Usuario.Usuario;
import br.com.onshoes.model.Usuario.TipoUsuario;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioAdminRepository extends JpaRepository<Usuario, Long> {
    Page<Usuario> findByPapel(TipoUsuario papel, Pageable pageable);

    Optional<Usuario> findByUsername(String username);

}
