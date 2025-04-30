package br.com.onshoes.model;

import java.time.LocalDateTime;

public class Envio {

    public enum MetodoEnvio {
        Metodo1,
        Metodo2,
        Metodo3
    }

    private Long id;
    private Pedido pedido;
    private String enderecoEntrega;
    private LocalDateTime dataEnvio;
    private MetodoEnvio metodo;
    private String codigoRastreamento;

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

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
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

}
