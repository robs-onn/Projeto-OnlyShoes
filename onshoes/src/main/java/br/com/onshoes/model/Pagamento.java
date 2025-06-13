package br.com.onshoes.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity 
@Table(name = "pagamento") 
public class Pagamento {

    public enum StatusPagamento {
        PENDENTE,
        CONCLUIDO,
        FALHOU
    }
    public enum TipoPagamento {
        PIX,
        DEBITO,
        CREDITO, 
        BOLETO
    }

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "pagamento", fetch = FetchType.LAZY)
    private Pedido pedido;

    @Column(name = "data_pagamento")
    private LocalDateTime dataPagamento;

    @Column(name = "valor_pago", precision = 10, scale = 2) 
    private BigDecimal valorPago;

    @Enumerated(EnumType.STRING) 
    @Column(name = "status", length = 50) 
    private StatusPagamento status;

    @Enumerated(EnumType.STRING) 
    @Column(name = "tipo_pagamento", length = 50) 
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
