package br.com.onshoes.model.Pagamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.hibernate.annotations.DynamicUpdate;

import br.com.onshoes.model.Pedido.Pedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "pagamento")
@DynamicUpdate
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "gerador6", sequenceName = "pagamento_codigo_seq", allocationSize = 1)
    @GeneratedValue(generator = "gerador6", strategy = GenerationType.SEQUENCE)
    private Long codigo;

    @OneToOne(mappedBy = "pagamento", fetch = FetchType.LAZY)
    private Pedido pedido;

    @Column(name = "data_pagamento")
    private LocalDateTime dataPagamento;

    @NotNull(message = "O valor pago é obrigatório")
    @Column(name = "valor_pago", precision = 10, scale = 2)
    private BigDecimal valorPago;

    @NotNull(message = "O status do pagamento é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 50)
    private StatusPagamento status = StatusPagamento.PENDENTE;

    @NotNull(message = "O tipo de pagamento é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pagamento", length = 50)
    private TipoPagamento tipoPagamento;

    // Getters and Setters
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pagamento other = (Pagamento) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "codigo: " + codigo + "\ntipo: " + tipoPagamento + "\nstatus: " + status;
    }
}