package br.com.onshoes.model.Usuario;

public enum TipoUsuario {
	ADMIN("Administrador"),
	CLIENTE("Cliente");
	
	private String descricao;
	
	TipoUsuario(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}

