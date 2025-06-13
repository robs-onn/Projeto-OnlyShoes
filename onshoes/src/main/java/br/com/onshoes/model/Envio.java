package br.com.onshoes.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "envio")
public class Envio {

    public enum MetodoEnvio {
        CORREIOS,
        SEDEX,
        TRANSPORTADORA,
        RETIRADA_LOCAL
    }

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(mappedBy = "envio", fetch = FetchType.LAZY)
    private Pedido pedido;

    @Column(name = "endereco_entrega", length = 200) 
    private String enderecoEntrega;

    @Column(name = "data_envio") 
    private LocalDateTime dataEnvio;

    @Enumerated(EnumType.STRING) 
    @Column(name = "metodo", length = 50) 
    private MetodoEnvio metodo;

    @Column(name = "codigo_rastreamento", length = 100) 
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
