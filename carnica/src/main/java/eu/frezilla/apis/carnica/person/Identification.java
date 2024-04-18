package eu.frezilla.apis.carnica.person;

import eu.frezilla.apis.mellifera.utils.validators.string.StringAllUpperCaseValidator;
import eu.frezilla.apis.mellifera.utils.validators.string.StringNotEmptyValidator;
import eu.frezilla.apis.mellifera.utils.validators.string.StringValidator;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.apache.commons.lang3.ObjectUtils;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Identification implements Comparable<Identification> {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private IdentificationId id;

    @Column
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Transient
    private final StringValidator lastNameValidator = new StringNotEmptyValidator(new StringAllUpperCaseValidator());

    protected Identification(@NonNull Person person, @NonNull LocalDate effectiveDate, String lastName, String firstName) {
        id = new IdentificationId(person, effectiveDate);
        setLastName(lastName);
        this.firstName = firstName;
    }

    @Override
    public int compareTo(Identification o) {
        if (o == null) {
            return 1;
        }
        return ObjectUtils.compare(id, o.getId(), true);
    }

    public final void setLastName(String lastName) {
        this.lastName = lastNameValidator.raiseIllegalArgumentExceptionIfNotValid(lastName, "Le nom doit être renseigné et en majuscule");
    }

}
