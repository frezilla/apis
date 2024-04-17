package eu.frezilla.apis.mellifera.utils.validators.string;

public final class StringNotNullValidator extends AbstractStringValidator {

    public StringNotNullValidator() {
        super(null);
    }
    
    public StringNotNullValidator(StringValidator stringValidator) {
        super(stringValidator);
    }

    @Override
    protected boolean localValidate(String s) {
        return s != null;
    }
    
}
