package br.com.onshoes.model.Produto;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "estoque")
public class Estoque implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="gerador_estoque", sequenceName="estoque_codigo_seq", allocationSize=1)
    @GeneratedValue(generator="gerador_estoque", strategy = GenerationType.SEQUENCE)
    private Long codigo;

    @NotNull(message = "O tamanho é obrigatório")
    private Integer tamanho;

    @NotNull(message = "A quantidade é obrigatória")
    @Min(value = 0, message = "A quantidade não pode ser negativa")
    private Integer quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_codigo", nullable = false)
    private Produto produto;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Estoque other = (Estoque) obj;
        if (codigo == null) {
            if (other.codigo != null) return false;
        } else if (!codigo.equals(other.codigo)) return false;
        return true;
    }
}