package br.com.onshoes.model.Pagamento;

public enum TipoPagamento {
    PIX("PIX"),
    DEBITO("Débito"),
    CREDITO("Crédito"),
    BOLETO("Boleto");
    
    private String descricao;
	
    TipoPagamento(String descricao) {
	this.descricao = descricao;
    }
	
    public String getDescricao() {
	return descricao;
    }
}