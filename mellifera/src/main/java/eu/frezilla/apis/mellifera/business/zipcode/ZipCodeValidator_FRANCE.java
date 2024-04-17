package eu.frezilla.apis.mellifera.business.zipcode;

import eu.frezilla.apis.mellifera.resources.laposte.StaticFrenchZipCodeSet;
import eu.frezilla.apis.mellifera.utils.validators.string.StringLengthValidator;
import eu.frezilla.apis.mellifera.utils.validators.string.StringNumericValidator;

public final class ZipCodeValidator_FRANCE implements ZipCodeValidator {

    @Override
    public boolean validate(String s) {
        if (!new StringNumericValidator(new StringLengthValidator(5)).validate(s)) return false;
        return !StaticFrenchZipCodeSet.getByCodePostal(s).isEmpty();
    }
    
}
