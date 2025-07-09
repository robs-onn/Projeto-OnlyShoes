package br.com.onshoes.model.Produto;

import java.io.Serializable;
import java.math.BigDecimal;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;

@Entity
@Table(name="produto")
@DynamicUpdate
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="gerador1", sequenceName="produto_codigo_seq", allocationSize=1)
	@GeneratedValue(generator="gerador1", strategy = GenerationType.SEQUENCE)
	private Long codigo;
	
	@NotBlank(message = "O nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "A descrição é obrigatória")
	private String descricao;
	
	@NotBlank(message = "A marca é obrigatória")
	private String marca;
	
	@NotBlank(message = "O modelo é obrigatório")
	private String modelo;
	
	private String cor;
	
	@NotNull(message = "O preço é obrigatório")
	@DecimalMin(value = "0.01", message = "O preço deve ser maior que zero")
	private BigDecimal preco;
	
	private BigDecimal precoPromocional;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "A categoria é obrigatória")
	private CategoriaProduto categoria;
	
	@Enumerated(EnumType.STRING)
	private StatusProduto status = StatusProduto.ATIVO;
	
	private String imagemPrincipal;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public BigDecimal getPrecoPromocional() {
		return precoPromocional;
	}

	public void setPrecoPromocional(BigDecimal precoPromocional) {
		this.precoPromocional = precoPromocional;
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

	public String getImagemPrincipal() {
		return imagemPrincipal;
	}

	public void setImagemPrincipal(String imagemPrincipal) {
		this.imagemPrincipal = imagemPrincipal;
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
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "codigo: " + codigo + "\nnome: " + nome + "\nmarca: " + marca + "\nmodelo: " + modelo;
	}
}

