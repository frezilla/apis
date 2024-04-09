package eu.frezilla.apis.core.utils.validators.string;

public final class StringNotEmptyValidator extends AbstractStringValidator {

    public StringNotEmptyValidator() {
        super(null);
    }
    
    public StringNotEmptyValidator(StringValidator stringValidator) {
        super(stringValidator);
    }

    @Override
    protected boolean localValidate(String s) {
        return (s != null && s.length() > 0);
    }
    
}
