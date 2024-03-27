package eu.frezilla.apis.core.domain.insee;

import eu.frezilla.apis.core.utils.ValidatorUtils;
import java.math.BigInteger;

public class Siret {
    
    private Nic nic;
    private Siren siren;
    
    public final Nic getNic() {
        return nic;
    }
    
    public final Siren getSiren() {
        return siren;
    }
    
    public final boolean isValid() {
        if (nic == null || siren == null) return false;
        
        String nicValue = nic.getValue();
        String sirenValue = siren.getValue();
        if (nicValue == null || sirenValue == null) return false;
        
        return ValidatorUtils.checkLuhnKey(new BigInteger(sirenValue + nicValue));
    }
    
    public final void setNic(Nic nic) {
        if (nic == null) throw new IllegalArgumentException("Le nic n'est pas valide");
        this.nic = nic;
    }
    
    public final void setSiren(Siren siren) {
        if (siren == null) throw new IllegalArgumentException("Le siren n'est pas valide");
        this.siren = siren;
    }
    
    
}
