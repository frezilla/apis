package eu.frezilla.apis.core.domain.insee;

import eu.frezilla.apis.core.utils.ValidatorUtils;
import eu.frezilla.apis.core.validators.string.StringLengthValidator;
import eu.frezilla.apis.core.validators.string.StringNumericValidator;
import java.math.BigInteger;
import lombok.Getter;

@Getter
public final class Siren {
    
    public static final String LAPOSTE = "356000000";
    public static final int LENGTH = 9;
        
    private final String value;
    
    public Siren(String value) {
        if (!new StringNumericValidator(new StringLengthValidator(LENGTH)).validate(value)
                || !ValidatorUtils.checkLuhnKey(new BigInteger(value))) {
            throw new IllegalArgumentException("La valeur du SIREN n'est pas valide");
        }
        
        this.value = value;
    }
    
}
