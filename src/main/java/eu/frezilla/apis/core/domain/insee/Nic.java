package eu.frezilla.apis.core.domain.insee;

import eu.frezilla.apis.core.validators.string.StringValidator;
import eu.frezilla.apis.core.validators.string.StringLengthValidator;
import eu.frezilla.apis.core.validators.string.StringNumericValidator;

public class Nic {
    
    static final int LENGTH = 5;
    
    private final StringValidator stringValidator;
    
    private String value;
    
    public Nic() {
        this.stringValidator = (StringValidator) new StringNumericValidator(new StringLengthValidator(LENGTH));
    }
    
    public final String getValue() {
        return this.value;
    }
    
    public final void setValue(String value) {
        if (!stringValidator.validate(value)) throw new IllegalArgumentException("La valeur du NIC n'est pas valide");
        this.value = value;
    }
    
}
