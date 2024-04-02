package eu.frezilla.apis.core.domain.insee;

import eu.frezilla.apis.core.validators.string.StringLengthValidator;
import eu.frezilla.apis.core.validators.string.StringNumericValidator;
import lombok.Getter;

@Getter
public class Nic {
    
    public static final int LENGTH = 5;
    
    private final String value;
    
    public Nic(String value) {
        if (!new StringNumericValidator(new StringLengthValidator(LENGTH)).validate(value)) throw new IllegalArgumentException("La valeur du NIC n'est pas valide");
        this.value = value;
    }
    
}
