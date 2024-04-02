package eu.frezilla.tu.api.core.domain.insee;

import eu.frezilla.apis.core.domain.insee.Nic;
import eu.frezilla.apis.core.domain.insee.Siren;
import eu.frezilla.apis.core.domain.insee.Siret;
import org.junit.jupiter.api.Test;

public class SiretTest {
    
    @Test
    public void testSiret() {
        new Siret(
                new Siren("356000000"),
                new Nic("49837")
        );
        
    }
    
}
