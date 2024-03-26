package eu.frezilla.apis.core.validators.string;

public abstract class StringValidator {

    private final StringValidator validator;

    StringValidator(StringValidator stringValidator) {
        this.validator = stringValidator;
    }

    public abstract boolean localValidate(String s);

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
