package eu.frezilla.apis.core.business.country;

import eu.frezilla.apis.core.utils.validators.string.StringAllUpperCaseValidator;
import eu.frezilla.apis.core.utils.validators.string.StringLengthValidator;
import eu.frezilla.apis.core.utils.validators.string.StringNotEmptyValidator;
import eu.frezilla.apis.core.utils.validators.string.StringNumericValidator;
import lombok.Data;

@Data
public final class Country {
    
    private final String alpha2;
    private final String alpha3;
    private final String frenchName;
    private final String isoName;
    private final String num;
    
    public Country(String alpha2, String alpha3, String frenchName, String isoName, String num) {
        if (!new StringAllUpperCaseValidator(new StringLengthValidator(2)).validate(alpha2)) throw new IllegalArgumentException();
        if (!new StringAllUpperCaseValidator(new StringLengthValidator(3)).validate(alpha2)) throw new IllegalArgumentException();
        if (!new StringNotEmptyValidator().validate(frenchName)) throw new IllegalArgumentException();
        if (!new StringAllUpperCaseValidator(new StringNotEmptyValidator()).validate(isoName)) throw new IllegalArgumentException();
        if (!new StringNumericValidator(new StringLengthValidator(3)).validate(num)) throw new IllegalArgumentException();
        
        this.alpha2 = alpha2;
        this.alpha3 = alpha3;
        this.frenchName = frenchName;
        this.isoName = isoName;
        this.num = num;
    }
    
}
