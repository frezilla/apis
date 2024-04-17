package eu.frezilla.apis.mellifera.resources.laposte;

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
            } catch (Exception e) {
                throw new IllegalArgumentException("Erreur au chargement des codes postaux français", e);
            }
        }
    }
    
    public static final String RESOURCE_FILE = "resources/laposte/019HexaSmal.csv";
    public static final String RESOURCE_FILE_CHARSET = "windows-1252";

    private final Set<FrenchZipCode> zipCodeSet;
    
    private FrenchZipCodeLoader() throws IOException {
        ClassLoader classLoader = FrenchZipCodeLoader.class.getClassLoader();
        InputStream inputStream = Objects.requireNonNull(classLoader.getResourceAsStream(RESOURCE_FILE), "Fichier " + RESOURCE_FILE + " introuvable");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName(RESOURCE_FILE_CHARSET)));
        
        String line;
        boolean header = true;
        Set<FrenchZipCode> localZipCodeSet = new HashSet<>();
        while ((line = bufferedReader.readLine()) != null) {
            if (header) {
                header = false;
            } else {
                String[] datas = line.split(";", -1);
                localZipCodeSet.add(new FrenchZipCode(datas[0], datas[2], datas[3], datas[4], datas[1]));
            }
        }
        
        zipCodeSet = Collections.unmodifiableSet(localZipCodeSet);
    }
    
    public Set<FrenchZipCode> getDatas() {
        return zipCodeSet;
    }
    
    public static FrenchZipCodeLoader getInstance() {
        return Holder.INSTANCE;
    }
    
}
