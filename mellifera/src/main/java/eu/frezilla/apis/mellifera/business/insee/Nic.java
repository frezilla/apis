package eu.frezilla.apis.mellifera.business.insee;

import eu.frezilla.apis.mellifera.utils.validators.string.StringLengthValidator;
import eu.frezilla.apis.mellifera.utils.validators.string.StringNumericValidator;
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
