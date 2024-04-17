package eu.frezilla.tu.api.mellifera.resources.laposte;

import eu.frezilla.apis.mellifera.resources.laposte.FrenchZipCode;
import eu.frezilla.apis.mellifera.resources.laposte.FrenchZipCodeLoader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FrenchZipCodeLoaderTest {
    
    @Test
    public void test() {
        FrenchZipCodeLoader loader = FrenchZipCodeLoader.getInstance();
        Set<FrenchZipCode> zipCodeSet = loader.getDatas();
        
        FrenchZipCode zipCode01001 = new FrenchZipCode("01001", "01400", "L ABERGEMENT CLEMENCIAT", "", "L ABERGEMENT CLEMENCIAT");
        
        Assertions.assertFalse(zipCodeSet.isEmpty());
        Assertions.assertTrue(Long.compare(2, zipCodeSet.stream().filter(zipCode -> "13200".equals(zipCode.getCodePostal())).count()) == 0);
        Assertions.assertTrue(zipCodeSet.contains(zipCode01001));
        
        try { zipCodeSet.remove(zipCode01001); Assertions.fail(); } catch (UnsupportedOperationException e) { }
        try { zipCodeSet.add(zipCode01001); Assertions.fail(); } catch (UnsupportedOperationException e) { }
            
        
    }
}
