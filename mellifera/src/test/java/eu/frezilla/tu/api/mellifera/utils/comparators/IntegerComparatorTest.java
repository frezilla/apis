package eu.frezilla.tu.api.mellifera.utils.comparators;

import eu.frezilla.apis.mellifera.utils.comparators.IntegerComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerComparatorTest {
    
    @Test
    @DisplayName("Contrôle de la méthode de comparaison")
    public void testCompare() {
        IntegerComparator c = new IntegerComparator();
        
        Assertions.assertTrue(c.compare(null, null) == 0);
        Assertions.assertTrue(c.compare(null, 10) == -1);
        Assertions.assertTrue(c.compare(5, null) == 1);
        Assertions.assertTrue(c.compare(10, 10) == 0);
        Assertions.assertTrue(c.compare(9, 10) == -1);
        Assertions.assertTrue(c.compare(11, 10) == 1);
    }
}
