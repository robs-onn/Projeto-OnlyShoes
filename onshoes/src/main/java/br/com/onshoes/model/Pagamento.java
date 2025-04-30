package br.com.onshoes.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pagamento {
    
    public enum StatusPagamento {
        PENDENTE,
        CONCLUIDO,
        FALHOU
    }
    public enum TipoPagamento {
        PIX,
        DEBITO,
        CREDITO,//possivelmente parcelado
        BOLETO
    }

    private Long id;
    private Pedido pedido;
    private LocalDateTime dataPagamento;
    private BigDecimal valorPago;
    private StatusPagamento status;
    private TipoPagamento tipoPagamento;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public boolean isParcelado() {
        return this.tipoPagamento == TipoPagamento.CREDITO;
    }

}
