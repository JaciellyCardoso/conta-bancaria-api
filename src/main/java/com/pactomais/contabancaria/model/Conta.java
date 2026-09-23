package com.pactomais.contabancaria.model;

import javax.persistence.*;

import java.math.BigDecimal;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_conta")
public class Conta {@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
    private String numero;
    private BigDecimal saldo;
    @ManyToOne
    @JoinColumn(name = "correntista_id")
    private Correntista correntista;

    public String getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Correntista getCorrentista() {
        return correntista;
    }

    public void setCorrentista(Correntista correntista) {
        this.correntista = correntista;
    }

    public void setNumero(String numero) {
        this.numero = numero;



    }
}
