package eu.frezilla.buckfast.contributor;

import eu.frezilla.buckfast.charge.AccountingCharge;
import java.math.BigDecimal;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

public final class AccountingContributor {
    
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
        Pair<BigDecimal, BigDecimal> pair = computeCreditAndDebit();
        BigDecimal debit = pair.getLeft();
        BigDecimal credit = pair.getRight();
        return credit.subtract(debit);
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
