package eu.frezilla.apis.core.domain.insee;

import eu.frezilla.api.core.utils.ValidatorUtils;
import eu.frezilla.apis.core.validators.string.StringValidator;
import eu.frezilla.apis.core.validators.string.StringValidatorLength;
import eu.frezilla.apis.core.validators.string.StringValidatorNumeric;
import java.math.BigInteger;

public class Siren {
    
    static final int LENGTH = 9;
    private final StringValidator stringValidator;
    
    private String value;
    
    public Siren() {
        this.stringValidator = (StringValidator) new StringValidatorNumeric(new StringValidatorLength(LENGTH));
    }
    
    public final boolean isValid() {
        if (value == null) return false;
        return ValidatorUtils.checkLuhnKey(new BigInteger(this.value));
    }
    
    public final String getValue() {
        return this.value;
    }

    public final void setValue(String value) {
        if (!stringValidator.validate(value) || ValidatorUtils.checkLuhnKey(new BigInteger(value))) throw new IllegalArgumentException("La valeur du SIREN n'est pas valide");
        this.value = value;
    }
    
}
