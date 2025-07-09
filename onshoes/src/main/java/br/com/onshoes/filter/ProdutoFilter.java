package br.com.onshoes.filter;

import br.com.onshoes.model.Produto.CategoriaProduto;
import br.com.onshoes.model.Produto.StatusProduto;

public class ProdutoFilter {

	private String nome;
	private String marca;
	private CategoriaProduto categoria;
	private StatusProduto status;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public CategoriaProduto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProduto categoria) {
		this.categoria = categoria;
	}

	public StatusProduto getStatus() {
		return status;
	}

	public void setStatus(StatusProduto status) {
		this.status = status;
	}
}

