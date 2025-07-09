package br.com.onshoes.model.Usuario;

import java.io.Serializable;
import java.time.LocalDateTime;
import org.hibernate.annotations.DynamicUpdate;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="usuario")
@DynamicUpdate
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="gerador2", sequenceName="usuario_codigo_seq", allocationSize=1)
	@GeneratedValue(generator="gerador2", strategy = GenerationType.SEQUENCE)
	private Long codigo;
	
	@NotBlank(message = "O username é obrigatório")
	private String username;
	
	@NotBlank(message = "O email é obrigatório")
	@Email(message = "Email deve ter um formato válido")
	private String email;
	
	@NotBlank(message = "A senha é obrigatória")
	private String senha;
	
	@NotBlank(message = "O nome é obrigatório")
	private String nome;
	
	private String telefone;
	
	@Enumerated(EnumType.STRING)
	private TipoUsuario papel = TipoUsuario.CLIENTE;
	
	@Enumerated(EnumType.STRING)
	private StatusUsuario status = StatusUsuario.ATIVO;
	
	private LocalDateTime dataCriacao = LocalDateTime.now();

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public TipoUsuario getPapel() {
		return papel;
	}

	public void setPapel(TipoUsuario papel) {
		this.papel = papel;
	}

	public StatusUsuario getStatus() {
		return status;
	}

	public void setStatus(StatusUsuario status) {
		this.status = status;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "codigo: " + codigo + "\nusername: " + username + "\nnome: " + nome + "\nemail: " + email;
	}
}