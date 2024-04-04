package eu.frezilla.apis.core.validators.string;

public class StringNotEmptyValidator extends StringValidator {

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
