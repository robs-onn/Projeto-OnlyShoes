package br.com.onshoes.model.Produto;

public enum CategoriaProduto {
    IMPORTADO("Linha de Importados"),
    PREMIUM("Linha Premium"),
    PRIMEIRA_LINHA("Primeira Linha");

    private String descricao;

    CategoriaProduto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}