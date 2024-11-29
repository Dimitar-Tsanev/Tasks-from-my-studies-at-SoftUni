package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@XmlRootElement(name = "astronomer")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportAstronomerXmlDto implements Serializable {

    @XmlElement(name = "first_name" )
    @Length(min = 2, max = 30)
    private String firstName;

    @XmlElement(name = "last_name" )
    @Length(min = 2, max = 30)
    private String lastName;

    @XmlElement
    @Min(value = 15000)
    private Double salary;

    @XmlElement(name = "average_observation_hours")
    @Min ( 500 )
    private Double averageObservationHours;

    @XmlElement
    private String birthday;

    @XmlElement(name = "observing_star_id" )
    private Long observingStarId;

    public ImportAstronomerXmlDto () {
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

    public Double getSalary () {
        return salary;
    }

    public void setSalary ( Double salary ) {
        this.salary = salary;
    }

    public Double getAverageObservationHours () {
        return averageObservationHours;
    }

    public void setAverageObservationHours ( Double averageObservationHours ) {
        this.averageObservationHours = averageObservationHours;
    }

    public String getBirthday () {
        return birthday;
    }

    public void setBirthday ( String birthday ) {
        this.birthday = birthday;
    }

    public Long getObservingStarId () {
        return observingStarId;
    }

    public void setObservingStarId ( Long observingStarId ) {
        this.observingStarId = observingStarId;
    }
}
