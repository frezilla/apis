package eu.frezilla.apis.core.resources.laposte;

import eu.frezilla.apis.core.utils.validators.string.StringLengthValidator;
import eu.frezilla.apis.core.utils.validators.string.StringNotEmptyValidator;
import eu.frezilla.apis.core.utils.validators.string.StringNumericValidator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public final class FrenchZipCode {
    
    private final String codeCommune;
    private final String codePostal;
    private final String nomCommune;
    private final String libelleAcheminement;
    private final String ligne5;

    public FrenchZipCode(String codeCommune, String codePostal, String nomCommune, String libelleAcheminement, String ligne5) {
        this.codeCommune = new StringNumericValidator(new StringLengthValidator(5)).raiseIllegalArgumentExceptionIfNotValid(codeCommune, "Le code commune n'est pas valide");
        this.codePostal = new StringNumericValidator(new StringLengthValidator(5)).raiseIllegalArgumentExceptionIfNotValid(codePostal, "Le code postal n'est pas valide");
        this.nomCommune = new StringNotEmptyValidator().raiseIllegalArgumentExceptionIfNotValid(nomCommune, "Le nom de la commune n'est pas valide");
        this.libelleAcheminement = libelleAcheminement;
        this.ligne5 = ligne5;
    }
    
}
