package br.com.onshoes.model.Pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.DynamicUpdate;

import br.com.onshoes.model.Envio.Envio;
import br.com.onshoes.model.Pagamento.Pagamento;
import br.com.onshoes.model.Usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "pedido")
@DynamicUpdate
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "gerador3", sequenceName = "pedido_codigo_seq", allocationSize = 1)
    @GeneratedValue(generator = "gerador3", strategy = GenerationType.SEQUENCE)
    private Long codigo;

    @NotNull(message = "O usuário é obrigatório")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_codigo", referencedColumnName = "codigo", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ItemPedido> itens = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pagamento_codigo", referencedColumnName = "codigo", unique = true)
    private Pagamento pagamento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "envio_codigo", referencedColumnName = "codigo", unique = true)
    private Envio envio;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido = LocalDateTime.now();

    @Column(name = "data_entrega")
    private LocalDateTime dataEntrega;

    @NotNull(message = "O valor total é obrigatório")
    @Column(name = "valor_total", precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @NotNull(message = "O status do pedido é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 50)
    private StatusPedido status = StatusPedido.PENDENTE;

    // Getters and Setters
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
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
        Pedido other = (Pedido) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "codigo: " + codigo + "\nusuario: " + (usuario != null ? usuario.getNome() : "N/A") + "\nstatus: " + status;
    }
}