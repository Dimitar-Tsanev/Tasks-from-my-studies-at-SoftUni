package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import softuni.exam.models.entity.enums.StarType;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class ImportStarJsonDto implements Serializable {

    @Expose
    @Size(min = 2, max = 30)
    private String name;

    @Expose
    @Positive
    private Double lightYears;

    @Expose
    @Size(min = 6)
    private String description;

    @Expose
    private StarType starType;

    @Expose
    private Long constellation;

    public ImportStarJsonDto () {
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public Double getLightYears () {
        return lightYears;
    }

    public void setLightYears ( Double lightYears ) {
        this.lightYears = lightYears;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public StarType getStarType () {
        return starType;
    }

    public void setStarType ( StarType starType ) {
        this.starType = starType;
    }

    public Long getConstellation () {
        return constellation;
    }

    public void setConstellation ( Long constellation ) {
        this.constellation = constellation;
    }
}
