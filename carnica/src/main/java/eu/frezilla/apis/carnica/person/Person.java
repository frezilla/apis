package eu.frezilla.apis.carnica.person;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Setter;
import org.apache.commons.lang3.ObjectUtils;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person implements Comparable<Person> {
    
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carnica_sequence" )
    @SequenceGenerator(name="carnica_sequence", sequenceName = "person_seq", allocationSize=50)
    @Setter(AccessLevel.PRIVATE)
    private Long personId;
    
    @OneToMany(targetEntity = Identification.class, mappedBy = "id.person")
    @Setter(AccessLevel.PRIVATE)
    private Set<Identification> identificationSet = new TreeSet<>();

    @Override
    public int compareTo(Person o) {
        if (o == null) return 1;
        return ObjectUtils.compare(personId, o.getPersonId());
    }
    
    public final boolean addIdentification(String lastName, String firstName, LocalDate effectiveDate) {
        Identification identification = new Identification(this, effectiveDate, lastName, firstName);
        identificationSet.remove(identification);
        return identificationSet.add(identification);
    }
    
    public final Identification getCurrentIdentification() {
        return getIdentification(LocalDate.now());
    }
    
    public final Identification getIdentification(@NonNull LocalDate date) {
        Identification result = null;
        
        for (Identification current : identificationSet) {
            int compareResult = ObjectUtils.compare(date, current.getId().getEffectiveDate(), true);
            if (compareResult > 0) break;
            result = current;
        }
        
        return result;
    }
    
    public final boolean removeIdentificiation(@NonNull Identification identification) {
        return identificationSet.remove(identification);
    }
    
}
