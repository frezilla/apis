package eu.frezilla.apis.mellifera.utils.validators.string;

public interface StringValidator {
    
    String raiseIllegalArgumentExceptionIfNotValid(String s, String msg);
    
    boolean validate(String s);
    
}
