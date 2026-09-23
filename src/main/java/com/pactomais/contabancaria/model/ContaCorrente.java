package com.pactomais.contabancaria.model;

import javax.persistence.Entity;
import java.math.BigDecimal;
@Entity
public class ContaCorrente extends Conta {private BigDecimal limite;

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }
}
