package com.algaworks.cobranca.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Titulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotEmpty(message = "Descrição é obrigatória")
    @Size(max = 60, message = "A descrição não pode conter mais de 60 caracteres")
    private String descricao;

    @NotNull(message = "A data de vencimento é obrigatória")
    @DateTimeFormat(pattern = "dd/MM/yyy")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

    @NotNull(message = "O Valor é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor não pode ser menor que 0,01")
    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private StatusTitulo status;

    /**
     * @return Long return the codigo
     */
    public Long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    /**
     * @return String return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return Date return the dataVencimento
     */
    public Date getDataVencimento() {
        return dataVencimento;
    }

    /**
     * @param dataVencimento the dataVencimento to set
     */
    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    /**
     * @return BigDecimal return the valor
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    /**
     * @return StatusTitulo return the status
     */
    public StatusTitulo getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(StatusTitulo status) {
        this.status = status;
    }

    public boolean isPendente() {
        return StatusTitulo.PENDENTE.equals(this.status);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Titulo)) {
            return false;
        }
        Titulo titulo = (Titulo) o;
        return Objects.equals(codigo, titulo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

}
