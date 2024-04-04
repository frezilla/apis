package eu.frezilla.apis.core.utils;

import java.math.BigInteger;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ValidatorUtils {
    
    public static final boolean checkLuhnKey(BigInteger value) {
        if (value == null) throw new IllegalArgumentException("La valeur du paramètre est égal à null");
        if (value.compareTo(BigInteger.valueOf(10)) < 0) return false;
        String strValue = StringUtils.reverse(value.toString());
        int sum = 0;
        for (int i = 0; i < strValue.length(); i++) {
            Character character = strValue.charAt(i);
            int currentValue = Integer.parseInt(character.toString());
            if (i % 2 == 0) {
                sum += currentValue;
            } else {
                currentValue = currentValue * 2;
                sum += (currentValue / 10) + (currentValue % 10);
            }
        }
        return (sum % 10 == 0);
    }
    
}
