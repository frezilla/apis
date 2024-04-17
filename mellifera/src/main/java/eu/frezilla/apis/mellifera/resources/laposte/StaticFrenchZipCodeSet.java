package eu.frezilla.apis.mellifera.resources.laposte;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public final class StaticFrenchZipCodeSet {
    
    private static class Holder {
        
        private static final StaticFrenchZipCodeSet INSTANCE;
        
        static {
            try {
                INSTANCE = new StaticFrenchZipCodeSet();
            } catch (Exception e) {
                throw new IllegalArgumentException("Erreur à la création de l'ensemble des codes postaux français", e);
            }
        }
    }
    
    private final Set<FrenchZipCode> frenchZipCodeSet;
    
    private StaticFrenchZipCodeSet() {
        frenchZipCodeSet = FrenchZipCodeLoader.getInstance().getDatas();        
    }
    
    private static Set<FrenchZipCode> filter(Predicate<? super FrenchZipCode> predicate) {
        return Holder.INSTANCE.frenchZipCodeSet.stream().filter(predicate).collect(Collectors.toSet());
    }
    
    public static Set<FrenchZipCode> getByCodeCommune(String codeCommune) {
        return filter(zipCode -> StringUtils.equals(zipCode.getCodeCommune(), codeCommune));
    }
    
    public static Set<FrenchZipCode> getByCodePostal(String codePostal) {
        return filter(zipCode -> StringUtils.equals(zipCode.getCodePostal(), codePostal));
    }
    
    public static Set<FrenchZipCode> getByLibelleAcheminement(String libelleAcheminement) {
        return filter(zipCode -> StringUtils.equals(zipCode.getLibelleAcheminement(), libelleAcheminement));
    }
    
    public static Set<FrenchZipCode> getByLigne5(String ligne5) {
        return filter(zipCode -> StringUtils.equals(zipCode.getLigne5(), ligne5));
    }
    
    public static Set<FrenchZipCode> getByNomCommune(String nomCommune) {
        return filter(zipCode -> StringUtils.equals(zipCode.getLibelleAcheminement(), nomCommune));
    }
    
}
