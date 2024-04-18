package eu.frezilla.apis.carnica.person;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Setter;
import org.apache.commons.lang3.ObjectUtils;

@Data
@Embeddable
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class IdentificationId implements Comparable<IdentificationId> {

    @Column(nullable = false)
    @EqualsAndHashCode.Include
    @JoinColumn(name = "personId", nullable = false)
    @ManyToOne
    @Setter(AccessLevel.NONE)
    private Person person;

    @Column(nullable = false)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    private LocalDate effectiveDate;
    
    protected IdentificationId(@NonNull Person person, @NonNull LocalDate effectiveDate) {
        this.person = person;
        this.effectiveDate = effectiveDate;
    }

    @Override
    public int compareTo(IdentificationId o) {
        if (o == null) {
            return 1;
        }
        
        int compareResult;
        if ((compareResult = ObjectUtils.compare(getPerson(), o.getPerson())) != 0) {
            return compareResult;
        }
        return ObjectUtils.compare(getEffectiveDate(), o.getEffectiveDate());
    }

}
