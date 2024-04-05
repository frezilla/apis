package eu.frezilla.apis.core.utils.validators.string;

import org.apache.commons.lang3.StringUtils;

abstract class AbstractStringValidator implements StringValidator {

    private final StringValidator validator;

    AbstractStringValidator(StringValidator stringValidator) {
        this.validator = stringValidator;
    }

    protected abstract boolean localValidate(String s);
    
    @Override
    public String raiseIllegalArgumentExceptionIfNotValid(String s, String msg) {
        if (!validate(s)) throw new IllegalArgumentException(StringUtils.defaultString(msg));
        return s;
    }

    @Override
    public final boolean validate(String s) {
        boolean test = true;
        if (this.validator != null) {
            test = this.validator.validate(s);
        }
        if (test) {
            test = localValidate(s);
        }
        return test;
    }

}
