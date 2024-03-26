package eu.frezilla.apis.core.validators.string;

public final class StringValidatorLength extends StringValidator {
    
    private final int length;
    
    public StringValidatorLength(int length) {
        super(null);
        this.length = checkLengthParameter(length);
    }
    
    public StringValidatorLength(int length, StringValidator stringValidator) {
        super(stringValidator);
        this.length = checkLengthParameter(length);
    }
    
    private int checkLengthParameter(int length) {
        if (length < 0) throw new IllegalArgumentException("La valeur de la longueur n'est pas valide");
        return length;
    }

    @Override
    public boolean localValidate(String s) {
        if (s == null) throw new IllegalArgumentException("La chaine de caractères à valider n'est pas valide");
        return (s.length() == length);
    }
    
}
