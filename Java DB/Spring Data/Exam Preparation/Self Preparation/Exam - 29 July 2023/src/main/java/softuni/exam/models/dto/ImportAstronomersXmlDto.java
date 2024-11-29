package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "astronomers")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportAstronomersXmlDto implements Serializable {

    @XmlElement(name = "astronomer")
    private List<ImportAstronomerXmlDto> astronomers;

    public ImportAstronomersXmlDto () {
    }

    public List<ImportAstronomerXmlDto> getAstronomers () {
        return astronomers;
    }

    public void setAstronomers ( List<ImportAstronomerXmlDto> astronomers ) {
        this.astronomers = astronomers;
    }
}
