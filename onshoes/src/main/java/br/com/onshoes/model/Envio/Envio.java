package br.com.onshoes.model.Envio;

import java.io.Serializable;
import java.time.LocalDateTime;
import org.hibernate.annotations.DynamicUpdate;

import br.com.onshoes.model.Pedido.Pedido;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "envio")
@DynamicUpdate
public class Envio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "gerador5", sequenceName = "envio_codigo_seq", allocationSize = 1)
    @GeneratedValue(generator = "gerador5", strategy = GenerationType.SEQUENCE)
    private Long codigo;

    @OneToOne(mappedBy = "envio", fetch = FetchType.LAZY)
    private Pedido pedido;

    @NotBlank(message = "O endereço de entrega é obrigatório")
    @Column(name = "endereco_entrega", length = 200)
    private String enderecoEntrega;

    @Column(name = "data_envio")
    private LocalDateTime dataEnvio;

    @NotNull(message = "O método de envio é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name = "metodo", length = 50)
    private MetodoEnvio metodo;

    @Column(name = "codigo_rastreamento", length = 100)
    private String codigoRastreamento;

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