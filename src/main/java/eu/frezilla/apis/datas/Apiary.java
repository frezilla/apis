package eu.frezilla.apis.datas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity 
public class Apiary {
    
    @Id private Long Id;
    
    private String name;
    
    
    
}
