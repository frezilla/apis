package eu.frezilla.apis.core.utils.validators.string;

abstract class AbstractStringValidator implements StringValidator {

    private final StringValidator validator;

    AbstractStringValidator(StringValidator stringValidator) {
        this.validator = stringValidator;
    }

    protected abstract boolean localValidate(String s);

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
