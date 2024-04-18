package eu.frezilla.buckfast.charge;

import eu.frezilla.buckfast.accounting.GenericPayment;
import eu.frezilla.buckfast.otheroperation.OtherOperation;
import java.math.BigDecimal;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

public class AccountingCharge {
    
    private Set<GenericPayment> genericPayment;
    private Set<OtherOperation> otherOperationSet;
    
    private Pair<BigDecimal, BigDecimal> computeCreditAndDebit() {
        BigDecimal creditSum = BigDecimal.ZERO;
        BigDecimal debitSum = BigDecimal.ZERO;
        
        for (GenericPayment p : genericPayment) {
            BigDecimal amount = p.getAmount();
            if (amount.compareTo(BigDecimal.ZERO) > 0) {
                creditSum = creditSum.add(amount);
            } else {
                debitSum = debitSum.add(amount);
            }
        }
        
        for (OtherOperation o : otherOperationSet) {
            BigDecimal amount = o.getAmount();
            if (amount.compareTo(BigDecimal.ZERO) > 0) {
                creditSum = creditSum.add(amount);
            } else {
                debitSum = debitSum.add(amount);
            }
        }
        
        return Pair.of(debitSum, creditSum);
    }
    
    public final BigDecimal getCredit() {
        Pair<BigDecimal, BigDecimal> pair = computeCreditAndDebit();
        return pair.getRight();
    }
    
    public final BigDecimal getBalance() {
        Pair<BigDecimal, BigDecimal> pair = computeCreditAndDebit();
        return pair.getLeft().add(pair.getRight());
    }
    
    public final BigDecimal getDebit() {
        Pair<BigDecimal, BigDecimal> pair = computeCreditAndDebit();
        return pair.getLeft();
    }
    
    
    
}
