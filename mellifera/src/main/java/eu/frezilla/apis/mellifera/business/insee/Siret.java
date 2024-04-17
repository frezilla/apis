package eu.frezilla.apis.mellifera.business.insee;

import eu.frezilla.apis.mellifera.utils.ValidatorUtils;
import java.math.BigInteger;
import lombok.Getter;
import lombok.NonNull;

@Getter
public final class Siret {
    
    private final @NonNull Nic nic;
    private final @NonNull Siren siren;
    
    public Siret(Siren siren, Nic nic) {
        this.siren = siren;
        this.nic = nic;
        
        if (!isValid()) throw new IllegalArgumentException("Le numéro SIRET n'est pas valide");
    }
    
    private static boolean checkLaPosteSiret(BigInteger siret) {
        String strValue = siret.toString();
        int sum = 0;
        for (int i = 0; i < strValue.length(); i++) {
            Character character = strValue.charAt(i);
            int currentValue = Integer.parseInt(character.toString());
            sum += currentValue;
        }
        return (sum % 5 == 0);
    }

    private boolean isValid() {
        if (nic == null || siren == null) return false;
        
        String nicValue = nic.getValue();
        String sirenValue = siren.getValue();
        if (nicValue == null || sirenValue == null) return false;
        
        if (Siren.LAPOSTE.equals(sirenValue)) {
            return checkLaPosteSiret(new BigInteger(sirenValue + nicValue));
        } else {
            return ValidatorUtils.checkLuhnKey(new BigInteger(sirenValue + nicValue));
        }
    }
    
}
