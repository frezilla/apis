package eu.frezilla.apis.core.utils.validators.string;

public final class StringLengthValidator extends AbstractStringValidator {
    
    private final int length;
    
    public StringLengthValidator(int length) {
        super(null);
        this.length = checkLengthParameter(length);
    }
    
    public StringLengthValidator(int length, StringValidator stringValidator) {
        super(stringValidator);
        this.length = checkLengthParameter(length);
    }
    
    private int checkLengthParameter(int length) {
        if (length < 0) throw new IllegalArgumentException("La valeur de la longueur n'est pas valide");
        return length;
    }

    @Override
    protected boolean localValidate(String s) {
        if (s == null) throw new IllegalArgumentException("La chaine de caractères à valider n'est pas valide");
        return (s.length() == length);
    }
    
}
