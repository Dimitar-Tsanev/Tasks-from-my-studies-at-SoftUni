package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

public class ImportSellerDto {

    @Expose
    @Length(min = 2, max = 30)
    private String firstName;

    @Expose
    @Length(min = 2, max = 30)
    private String lastName;

    @Expose
    @Length(min = 3, max = 6)
    private String personalNumber;

    public ImportSellerDto() {

    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName ( String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName ( String lastName ) {
        this.lastName = lastName;
    }

    public String getPersonalNumber () {
        return personalNumber;
    }

    public void setPersonal_number ( String personal_number ) {
        this.personalNumber = personalNumber;
    }
}
