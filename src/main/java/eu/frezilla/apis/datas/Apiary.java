package eu.frezilla.apis.datas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Set;

//@Entity 
public class Apiary {
    
    @Id private Long Id;
    
    private String name;
    
    private Set<Hive> hives;
    
    
    
}
