package eu.frezilla.apis.datas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//@Entity
public class Hive {
    
    @Id
    private Long id;
    
    private HiveType type;
}
