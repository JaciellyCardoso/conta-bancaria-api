package com.pactomais.contabancaria.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
public class Transacao {@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipo;
    private BigDecimal valor;
    private LocalDateTime data;
    @ManyToOne
    @JoinColumn(name ="conta_origem_id")
    private Conta contaOrigem;

    public TipoTransacao getTipo() {
        return tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;

    }
}
