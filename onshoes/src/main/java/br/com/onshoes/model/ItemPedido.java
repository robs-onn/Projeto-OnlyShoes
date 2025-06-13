package br.com.onshoes.model;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity 
@Table(name = "item_pedido") 
public class ItemPedido {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "produto_id", referencedColumnName = "id", nullable = false)
    private Produto produto;

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "pedido_id", referencedColumnName = "id", nullable = false) 
    private Pedido pedido;

    @Column(name = "quantidade") 
    private Integer quantidade;

    @Column(name = "preco_unitario", precision = 10, scale = 2) 
    private BigDecimal precoUnitario;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

}
