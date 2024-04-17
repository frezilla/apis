package eu.frezilla.buckfast.accounting;

import java.math.BigDecimal;

public abstract class GenericPayment {
    
    private BigDecimal amount;
    
    public final BigDecimal getAmount() {
        return this.amount;
    }
    
}
