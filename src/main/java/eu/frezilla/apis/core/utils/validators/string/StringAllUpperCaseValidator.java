package eu.frezilla.apis.core.utils.validators.string;

/**
 * La classe {@code StringAllUpperCaseValidator} vérifie qu'un {@code String} 
 * est composé de lettres majuscules.
 * <p>Si la chaine de caractères est composée de caractères autres, ces 
 * caractères sont ignorés.
 */
public class StringAllUpperCaseValidator extends AbstractStringValidator {
    
    public StringAllUpperCaseValidator() {
        super(null);
    }
    
    public StringAllUpperCaseValidator(StringValidator stringValidator) {
        super(stringValidator);
    }

    @Override
    protected boolean localValidate(String s) {
        if (s == null) return false;
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) return false;
        }
        return true;
    }

}
