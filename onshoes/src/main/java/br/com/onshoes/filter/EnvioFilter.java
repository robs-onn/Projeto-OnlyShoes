package br.com.onshoes.filter;

import java.time.LocalDate;
import br.com.onshoes.model.Envio.MetodoEnvio;

public class EnvioFilter {

    private Long pedidoCodigo;
    private MetodoEnvio metodo;
    private String codigoRastreamento;
    private LocalDate dataEnvioInicio;
    private LocalDate dataEnvioFim;

    // Getters and Setters
    public Long getPedidoCodigo() {
        return pedidoCodigo;
    }

    public void setPedidoCodigo(Long pedidoCodigo) {
        this.pedidoCodigo = pedidoCodigo;
    }

    public MetodoEnvio getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoEnvio metodo) {
        this.metodo = metodo;
    }

    public String getCodigoRastreamento() {
        return codigoRastreamento;
    }

    public void setCodigoRastreamento(String codigoRastreamento) {
        this.codigoRastreamento = codigoRastreamento;
    }

    public LocalDate getDataEnvioInicio() {
        return dataEnvioInicio;
    }

    public void setDataEnvioInicio(LocalDate dataEnvioInicio) {
        this.dataEnvioInicio = dataEnvioInicio;
    }

    public LocalDate getDataEnvioFim() {
        return dataEnvioFim;
    }

    public void setDataEnvioFim(LocalDate dataEnvioFim) {
        this.dataEnvioFim = dataEnvioFim;
    }
}