package eu.frezilla.tu.api.mellifera.utils;

import eu.frezilla.apis.mellifera.utils.ValidatorUtils;
import java.math.BigInteger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorUtilsTest {
    
    @Test
    @DisplayName("Contrôle de la méthode de vérification de la clé de Luhn")
    public void testCheckLuhnKey() {
        Assertions.assertFalse(ValidatorUtils.checkLuhnKey(BigInteger.valueOf(1111)));
        Assertions.assertTrue(ValidatorUtils.checkLuhnKey(BigInteger.valueOf(8763)));
        Assertions.assertFalse(ValidatorUtils.checkLuhnKey(BigInteger.valueOf(543210)));
        Assertions.assertTrue(ValidatorUtils.checkLuhnKey(BigInteger.valueOf(543215)));
        Assertions.assertTrue(ValidatorUtils.checkLuhnKey(new BigInteger("73282932000074")));        
        
    }
    
}
