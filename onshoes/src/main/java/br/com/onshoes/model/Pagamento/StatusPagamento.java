package br.com.onshoes.model.Pagamento;

public enum StatusPagamento {
    PENDENTE("Pendente"),
    CONCLUIDO("Concluído"),
    FALHOU("Falhou");
    
    private String descricao;
	
    StatusPagamento(String descricao) {
	this.descricao = descricao;
    }
	
    public String getDescricao() {
	return descricao;
    }
}