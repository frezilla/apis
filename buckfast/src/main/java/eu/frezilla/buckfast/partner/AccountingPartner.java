package eu.frezilla.buckfast.partner;

import eu.frezilla.buckfast.charge.AccountingCharge;
import java.math.BigDecimal;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

public final class AccountingPartner {
    
    private Set<AccountingCharge> accountingChargeSet;
    
    private Pair<BigDecimal, BigDecimal> computeCreditAndDebit() {
        BigDecimal creditSum = BigDecimal.ZERO;
        BigDecimal debitSum = BigDecimal.ZERO;
        
        for (AccountingCharge a : accountingChargeSet) {
            creditSum = creditSum.add(a.getCredit());
            debitSum = debitSum.add(a.getDebit());
        }
        
        return Pair.of(debitSum, creditSum);
    }
    
    public final BigDecimal getBalance() {
        BigDecimal balanceSum = BigDecimal.ZERO;
        
        for (AccountingCharge a : accountingChargeSet) {
            balanceSum = balanceSum.add(a.getBalance());
                    
        }

        return balanceSum;
    }
    
    public final BigDecimal getCredit() {
        Pair<BigDecimal, BigDecimal> pair = computeCreditAndDebit();
        return pair.getRight();
    }
    
    
    
    public final BigDecimal getDebit() {
        Pair<BigDecimal, BigDecimal> pair = computeCreditAndDebit();
        return pair.getLeft();
    }
    
}
