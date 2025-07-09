package br.com.onshoes.model.Envio;

public enum MetodoEnvio {
    CORREIOS("Correios"),
    SEDEX("SEDEX"),
    TRANSPORTADORA("Transportadora"),
    RETIRADA_LOCAL("Retirada no Local");
    
    private String descricao;
	
    MetodoEnvio(String descricao) {
	this.descricao = descricao;
    }
	
    public String getDescricao() {
	return descricao;
    }
}