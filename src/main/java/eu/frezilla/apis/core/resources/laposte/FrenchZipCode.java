package eu.frezilla.apis.core.resources.laposte;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Data
public final class FrenchZipCode {
    
    private final String codeCommune;
    private final String codePostal;
    private final String nomCommune;
    private final String libelleAcheminement;
    private final String ligne5;
    
}
