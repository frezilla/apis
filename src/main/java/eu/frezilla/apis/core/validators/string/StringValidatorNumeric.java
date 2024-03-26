package eu.frezilla.apis.core.validators.string;

import org.apache.commons.lang3.StringUtils;

public final class StringValidatorNumeric extends StringValidator {
    
    public StringValidatorNumeric() {
        super(null);
    }
    
    public StringValidatorNumeric(StringValidator stringValidator) {
        super(stringValidator);
    }

    @Override
    public boolean localValidate(String s) {
        return StringUtils.isNumeric(s);
    }
    
}
