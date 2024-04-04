package eu.frezilla.apis.core.resources.laposte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class FrenchZipCodeLoader {
    
    private static class Holder {
        private static final FrenchZipCodeLoader INSTANCE;
        
        static {
            try {
                INSTANCE = new FrenchZipCodeLoader();
            } catch (IOException | NullPointerException e) {
                throw new IllegalArgumentException("Erreur au chargement des codes postaux français", e);
            }
        }
    }
    
    public static final String RESOURCE_FILE = "external/resources/019HexaSmal.csv";
    public static final String RESOURCE_FILE_CHARSET = "windows-1252";

    private final Set<FrenchZipCode> zipCodeSet;
    
    private FrenchZipCodeLoader() throws IOException {
        zipCodeSet = Collections.unmodifiableSet(new HashSet<>());
        ClassLoader classLoader = FrenchZipCodeLoader.class.getClassLoader();
        InputStream inputStream = Objects.requireNonNull(classLoader.getResourceAsStream(RESOURCE_FILE), "Fichier " + RESOURCE_FILE + " introuvable");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName(RESOURCE_FILE_CHARSET)));
        
        String line;
        boolean header = true;
        while ((line = bufferedReader.readLine()) != null) {
            if (header) {
                header = false;
            } else {
                String[] datas = line.split(";");
                zipCodeSet.add(new FrenchZipCode(datas[0], datas[2], datas[1], datas[3], datas[4]));
            }
        }
    }
    
    public Set<FrenchZipCode> getDatas() {
        return zipCodeSet;
    }
    
    public static FrenchZipCodeLoader getInstance() {
        return Holder.INSTANCE;
    }
    
}
