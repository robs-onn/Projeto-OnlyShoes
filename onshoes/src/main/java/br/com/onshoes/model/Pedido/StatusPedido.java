package br.com.onshoes.model.Pedido;

public enum StatusPedido {
    PENDENTE("Pendente"),
    PAGO("Pago"),
    ENVIADO("Enviado"),
    ENTREGUE("Entregue"),
    CANCELADO("Cancelado");
    
    private String descricao;
	
    StatusPedido(String descricao) {
	this.descricao = descricao;
    }
	
    public String getDescricao() {
	return descricao;
    }
}