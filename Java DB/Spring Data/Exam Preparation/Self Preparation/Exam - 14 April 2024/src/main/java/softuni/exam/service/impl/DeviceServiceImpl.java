package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ExportDeviceDto;
import softuni.exam.models.dto.ImportDevicesDto;
import softuni.exam.models.entity.Device;
import softuni.exam.models.entity.enums.DeviceType;
import softuni.exam.repository.DeviceRepository;
import softuni.exam.repository.SaleRepository;
import softuni.exam.service.DeviceService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class DeviceServiceImpl implements DeviceService {
    private static final String IMPORT_FILE_PATH = "src/main/resources/files/xml/devices.xml";
    private static final String SUCCESSFULLY_IMPORTED_TEMPLATE = "Successfully imported device of type %s with brand %s";

    private final DeviceRepository deviceRepository;
    private final SaleRepository saleRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public DeviceServiceImpl ( DeviceRepository deviceRepository, SaleRepository saleRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser ) {
        this.deviceRepository = deviceRepository;
        this.saleRepository = saleRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported () {
        return deviceRepository.count ( ) > 0;
    }

    @Override
    public String readDevicesFromFile () throws IOException {
        return String.join ( System.lineSeparator ( ), Files.readAllLines (
                Path.of ( IMPORT_FILE_PATH ) ) );
    }

    @Override
    public String importDevices () throws IOException, JAXBException {
        if ( areImported ( ) ) {
            return "Data already imported!";
        }
        StringBuilder reportBuilder = new StringBuilder ( );

        ImportDevicesDto devicesDto = xmlParser.fromFile ( IMPORT_FILE_PATH, ImportDevicesDto.class );

        devicesDto.getImportDevices ( ).stream ( ).filter ( d -> {
            if ( !this.validationUtil.isValid ( d ) ||
                    deviceRepository.existsByBrandAndModel ( d.getBrand ( ), d.getModel ( ) ) ||
                    !saleRepository.existsSaleById ( d.getSale ( ) ) ) {

                reportBuilder.append ( "Invalid device" ).append ( System.lineSeparator ( ) );
                return false;
            }
            return true;

        } ).map ( d -> {
            Device device = modelMapper.map ( d, Device.class );
            device.setSale ( saleRepository.getById ( d.getSale ( ) ) );
            return device;

        } ).forEach ( d -> {
            reportBuilder.append ( String.format ( SUCCESSFULLY_IMPORTED_TEMPLATE, d.getDeviceType ( ).toString ( ), d.getBrand ( ) ) )
                    .append ( System.lineSeparator ( ) );

            deviceRepository.saveAndFlush ( d );
        } );
        return reportBuilder.toString ( );
    }

    @Override
    public String exportDevices () {
        StringBuilder reportBuilder = new StringBuilder ( );
        deviceRepository.findAllByDeviceTypeAndPriceLessThanEqualAndStorageGreaterThanEqualOrderByBrand ( DeviceType.SMART_PHONE, 1000.00, 128 )
                .stream( )
                .sorted ((d1,d2) -> d1.getBrand ().compareToIgnoreCase ( d2.getBrand () ) )
                .forEach ( d -> {
                    reportBuilder.append ( modelMapper.map ( d, ExportDeviceDto.class ).toString ( ) ).append ( System.lineSeparator ( ) );
                } );

        return reportBuilder.toString ( ).replaceAll ( ",","." );
    }
}
