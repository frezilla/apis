package eu.frezilla.apis.mellifera.business.country;

import lombok.Getter;

public enum Countries {
    AFGHANISTAN(new Country("AF", "AFG", "Afghanistan", "AFGHANISTAN", "004")),
    AFRIQUE_DU_SUD(new Country("ZA", "ZAF", "Afrique du Sud", "AFRIQUE DU SUD", "710")),
    ALBANIE(new Country("AL", "ALB", "Albanie", "ALBANIE", "008")),
    ALGERIE(new Country("DZ", "DZA", "Algérie", "ALGÉRIE", "012")),
    ILES_ALAND(new Country("AX", "ALA", "Îles Åland", "ÅLAND, ÎLES", "248"));
    
    @Getter private final Country country;
    
    private Countries(Country country) {
        this.country = country;
    }
    
}
