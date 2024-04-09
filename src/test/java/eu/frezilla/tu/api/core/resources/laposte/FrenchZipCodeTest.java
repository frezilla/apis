package eu.frezilla.tu.api.core.resources.laposte;

import eu.frezilla.apis.core.resources.laposte.FrenchZipCode;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FrenchZipCodeTest {

    @Test
    public void equalAndHashCodeTest() {
        FrenchZipCode zipCode01001_1 = new FrenchZipCode("01001", "01400", "L ABERGEMENT CLEMENCIAT", "", "L ABERGEMENT CLEMENCIAT");
        FrenchZipCode zipCode01001_2 = new FrenchZipCode("01001", "01400", "L ABERGEMENT CLEMENCIAT", "", "L ABERGEMENT CLEMENCIAT");
        
        Assertions.assertTrue(zipCode01001_1.equals(zipCode01001_2));
        Assertions.assertTrue(Objects.equals(zipCode01001_1, zipCode01001_2));
        Assertions.assertTrue(Objects.equals(zipCode01001_1.hashCode(), zipCode01001_2.hashCode()));        
    }    
}
