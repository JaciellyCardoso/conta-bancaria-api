package mode1;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {private BigDecimal limite;

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }
}
