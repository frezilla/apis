package eu.frezilla.tu.api.mellifera.business.insee;

import eu.frezilla.apis.mellifera.business.insee.Nic;
import eu.frezilla.apis.mellifera.business.insee.Siren;
import eu.frezilla.apis.mellifera.business.insee.Siret;
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
