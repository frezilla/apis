package eu.frezilla.apis.core.resources.laposte;

import eu.frezilla.apis.core.utils.validators.string.StringLengthValidator;
import eu.frezilla.apis.core.utils.validators.string.StringNotEmptyValidator;
import eu.frezilla.apis.core.utils.validators.string.StringNotNullValidator;
import eu.frezilla.apis.core.utils.validators.string.StringNumericValidator;
import lombok.Data;

@Data
public final class FrenchZipCode {
    
    private final String codeCommune;
    private final String codePostal;
    private final String libelleAcheminement;
    private final String ligne5;
    private final String nomCommune;
    
    public FrenchZipCode(String codeCommune, String codePostal, String libelleAcheminement, String ligne5, String nomCommune) {
        this.codeCommune = new StringLengthValidator(5).raiseIllegalArgumentExceptionIfNotValid(codeCommune, "Le code commune n'est pas valide");
        this.codePostal = new StringNumericValidator(new StringLengthValidator(5)).raiseIllegalArgumentExceptionIfNotValid(codePostal, "Le code postal n'est pas valide");
        this.libelleAcheminement = new StringNotNullValidator().raiseIllegalArgumentExceptionIfNotValid(libelleAcheminement, "Le libellé d'acheminement n'est pas valide");
        this.ligne5 = new StringNotNullValidator().raiseIllegalArgumentExceptionIfNotValid(ligne5, "La ligne 5 n'est pas valide");
        this.nomCommune = new StringNotEmptyValidator().raiseIllegalArgumentExceptionIfNotValid(nomCommune, "Le nom de la commune n'est pas valide");
    }
    
}
