package eu.frezilla.apis.core.validators.string;

import org.apache.commons.lang3.StringUtils;

public final class StringNumericValidator extends StringValidator {
    
    public StringNumericValidator() {
        super(null);
    }
    
    public StringNumericValidator(StringValidator stringValidator) {
        super(stringValidator);
    }

    @Override
    protected boolean localValidate(String s) {
        return StringUtils.isNumeric(s);
    }
    
}
