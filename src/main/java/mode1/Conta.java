package mode1;

import java.math.BigDecimal;

public class Conta {private String numero;
    private BigDecimal saldo;
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
