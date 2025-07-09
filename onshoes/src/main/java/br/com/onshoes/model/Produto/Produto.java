package br.com.onshoes.model.Produto;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name="produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;
    private String descricao;
    private String marca;
    private String modelo;
    private String cor;
    private BigDecimal preco;
    private BigDecimal precoPromocional;

    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoria;

    @Enumerated(EnumType.STRING)
    private StatusProduto status;

    private String imagemPrincipal;

    // --- GETTERS E SETTERS PÚBLICOS ---

    public Long getCodigo() { return codigo; }
    public void setCodigo(Long codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public BigDecimal getPrecoPromocional() { return precoPromocional; }
    public void setPrecoPromocional(BigDecimal precoPromocional) { this.precoPromocional = precoPromocional; }

    public CategoriaProduto getCategoria() { return categoria; }
    public void setCategoria(CategoriaProduto categoria) { this.categoria = categoria; }

    public StatusProduto getStatus() { return status; }
    public void setStatus(StatusProduto status) { this.status = status; }

    public String getImagemPrincipal() { return imagemPrincipal; }
    public void setImagemPrincipal(String imagemPrincipal) { this.imagemPrincipal = imagemPrincipal; }
}