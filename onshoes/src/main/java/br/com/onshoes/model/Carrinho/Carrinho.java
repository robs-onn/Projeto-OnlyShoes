package br.com.onshoes.model.Carrinho;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import br.com.onshoes.model.Produto.Produto;

public class Carrinho {

    private List<ItemCarrinho> itens = new ArrayList<>();

    public void adicionarItem(Produto produto, Integer tamanho, Integer quantidade) {
        ItemCarrinho novoItem = new ItemCarrinho(produto, tamanho);
        int indice = itens.indexOf(novoItem); // Agora usa o novo equals()

        if (indice != -1) {
            ItemCarrinho itemExistente = itens.get(indice);
            itemExistente.setQuantidade(itemExistente.getQuantidade() + quantidade);
        } else {
            novoItem.setQuantidade(quantidade);
            itens.add(novoItem);
        }
    }

    public void removerItem(Long codigoProduto, Integer tamanho) {
        itens.removeIf(item -> 
            item.getProduto().getCodigo().equals(codigoProduto) && 
            item.getTamanho().equals(tamanho)
        );
    }


    public BigDecimal getValorTotal() {
        return itens.stream()
                .map(ItemCarrinho::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Integer getQuantidadeTotalDeItens() {
        return itens.stream()
                .mapToInt(ItemCarrinho::getQuantidade)
                .sum();
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

}