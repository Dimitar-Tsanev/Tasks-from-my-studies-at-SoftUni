package softuni.exam.models.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "devices")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportDevicesDto {

    @XmlElement(name ="device")
    List<ImportDeviceDto> importDevices;
    public ImportDevicesDto() {

    }

    public List<ImportDeviceDto> getImportDevices () {
        return importDevices;
    }

    public void setImportDevices ( List<ImportDeviceDto> importDevices ) {
        this.importDevices = importDevices;
    }
}
