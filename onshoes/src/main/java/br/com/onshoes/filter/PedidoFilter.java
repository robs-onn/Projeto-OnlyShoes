package br.com.onshoes.filter;

import java.math.BigDecimal;
import java.time.LocalDate;
import br.com.onshoes.model.Pedido.StatusPedido;

public class PedidoFilter {

    private Long usuarioCodigo;
    private StatusPedido status;
    private LocalDate dataPedidoInicio;
    private LocalDate dataPedidoFim;
    private BigDecimal valorMinimo;
    private BigDecimal valorMaximo;

    // Getters and Setters
    public Long getUsuarioCodigo() {
        return usuarioCodigo;
    }

    public void setUsuarioCodigo(Long usuarioCodigo) {
        this.usuarioCodigo = usuarioCodigo;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public LocalDate getDataPedidoInicio() {
        return dataPedidoInicio;
    }

    public void setDataPedidoInicio(LocalDate dataPedidoInicio) {
        this.dataPedidoInicio = dataPedidoInicio;
    }

    public LocalDate getDataPedidoFim() {
        return dataPedidoFim;
    }

    public void setDataPedidoFim(LocalDate dataPedidoFim) {
        this.dataPedidoFim = dataPedidoFim;
    }

    public BigDecimal getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(BigDecimal valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public BigDecimal getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(BigDecimal valorMaximo) {
        this.valorMaximo = valorMaximo;
    }
}