package br.com.onshoes.filter;

import java.time.LocalDate;
import br.com.onshoes.model.Pagamento.StatusPagamento;
import br.com.onshoes.model.Pagamento.TipoPagamento;

public class PagamentoFilter {

    private Long pedidoCodigo;
    private StatusPagamento status;
    private TipoPagamento tipoPagamento;
    private LocalDate dataPagamentoInicio;
    private LocalDate dataPagamentoFim;

    // Getters and Setters
    public Long getPedidoCodigo() {
        return pedidoCodigo;
    }

    public void setPedidoCodigo(Long pedidoCodigo) {
        this.pedidoCodigo = pedidoCodigo;
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

    public LocalDate getDataPagamentoInicio() {
        return dataPagamentoInicio;
    }

    public void setDataPagamentoInicio(LocalDate dataPagamentoInicio) {
        this.dataPagamentoInicio = dataPagamentoInicio;
    }

    public LocalDate getDataPagamentoFim() {
        return dataPagamentoFim;
    }

    public void setDataPagamentoFim(LocalDate dataPagamentoFim) {
        this.dataPagamentoFim = dataPagamentoFim;
    }
}