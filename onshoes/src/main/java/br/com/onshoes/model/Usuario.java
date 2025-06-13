package br.com.onshoes.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "senha", length = 100)
    private String senha;

    @Column(name = "cpf", length = 14, unique = true)
    private String cpf;

    @Column(name = "endereco", length = 100)
    private String endereco;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
        name = "produtos_carrinho", 
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtosCarrinho = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
        name = "produtos_favoritos_usuario", 
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtosFavoritos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pedido> produtosComprados = new ArrayList<>();

    // --- Getters e Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public List<Produto> getProdutosCarrinho() { return produtosCarrinho; }
    public void setProdutosCarrinho(List<Produto> produtosCarrinho) { this.produtosCarrinho = produtosCarrinho; }
    public List<Produto> getProdutosFavoritos() { return produtosFavoritos; }
    public void setProdutosFavoritos(List<Produto> produtosFavoritos) { this.produtosFavoritos = produtosFavoritos; }
    public List<Pedido> getProdutosComprados() { return produtosComprados; }
    public void setProdutosComprados(List<Pedido> produtosComprados) { this.produtosComprados = produtosComprados; }
}