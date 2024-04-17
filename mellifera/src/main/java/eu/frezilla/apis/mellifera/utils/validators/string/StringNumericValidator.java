package eu.frezilla.apis.mellifera.utils.validators.string;

import org.apache.commons.lang3.StringUtils;

public final class StringNumericValidator extends AbstractStringValidator {
    
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
