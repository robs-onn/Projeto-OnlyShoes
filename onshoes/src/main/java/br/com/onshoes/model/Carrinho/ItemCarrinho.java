package br.com.onshoes.model.Carrinho;

import java.math.BigDecimal;
import java.util.Objects; // Importe Objects
import br.com.onshoes.model.Produto.Produto;

public class ItemCarrinho {

    private Produto produto;
    private Integer quantidade;
    private Integer tamanho; // NOVO CAMPO

    // Construtor agora recebe o tamanho
    public ItemCarrinho(Produto produto, Integer tamanho) {
        this.produto = produto;
        this.tamanho = tamanho;
        this.quantidade = 1; 
    }

    public BigDecimal getSubtotal() {
        return produto.getPreco().multiply(new BigDecimal(this.quantidade));
    }

    // Getters e Setters (incluindo para o novo campo tamanho)
    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public Integer getTamanho() { return tamanho; }
    public void setTamanho(Integer tamanho) { this.tamanho = tamanho; }

    // --- MÉTODOS ATUALIZADOS ---
    // Agora, dois itens são iguais se o produto E o tamanho forem iguais.
    @Override
    public int hashCode() {
        return Objects.hash(produto, tamanho);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ItemCarrinho that = (ItemCarrinho) obj;
        return Objects.equals(produto, that.produto) && Objects.equals(tamanho, that.tamanho);
    }
}