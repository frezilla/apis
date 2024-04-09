package eu.frezilla.tu.api.core.utils.validators.string;

import eu.frezilla.apis.core.utils.validators.string.StringLengthValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringLengthValidatorTest {
    
    @Test
    @DisplayName("Contrôle des constructeurs")
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor() {
        new StringLengthValidator(0);
        new StringLengthValidator(10);
        try { new StringLengthValidator(-1); Assertions.fail(); } catch (IllegalArgumentException e) { }
        
        new StringLengthValidator(0, null);
        new StringLengthValidator(10, null);
        try { new StringLengthValidator(-1, null); Assertions.fail(); } catch (IllegalArgumentException e) { }
        
        new StringLengthValidator(0, new StringLengthValidator(5));
        new StringLengthValidator(10, new StringLengthValidator(5));
        try { new StringLengthValidator(-1, new StringLengthValidator(5)); Assertions.fail(); } catch (IllegalArgumentException e) { }
    }

    @Test
    @DisplayName("Contrôle de la méthode de validation de la longueur d'une chaine de caractères")
    public void testValidate() {
        Assertions.assertTrue(new StringLengthValidator(10).validate("0123456789"));
        Assertions.assertFalse(new StringLengthValidator(10).validate("01234567"));
        Assertions.assertFalse(new StringLengthValidator(10).validate("0123456789ABCDEF"));
        
        try { new StringLengthValidator(10).validate(null); Assertions.fail(); } catch (IllegalArgumentException e) { }
    }
}
