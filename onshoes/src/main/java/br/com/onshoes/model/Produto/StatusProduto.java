package br.com.onshoes.model.Produto;

public enum StatusProduto {
    ATIVO("Ativo"),
    INATIVO("Inativo");

    private String descricao;

    StatusProduto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}