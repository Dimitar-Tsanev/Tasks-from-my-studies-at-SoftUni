package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportAstronomersXmlDto;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.util.interfaces.ValidationUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

@Service
public class AstronomerServiceImpl implements AstronomerService {
    private static final String IMPORT_FILE_PATH = "src/main/resources/files/xml/astronomers.xml";
    private static final String SUCCESSFULLY_IMPORTED_TEMPLATE = "Successfully imported astronomer %s %s - %.2f";

    private final AstronomerRepository astronomerRepository;
    private final StarRepository starRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public AstronomerServiceImpl ( AstronomerRepository astronomerRepository, StarRepository starRepository, ModelMapper modelMapper, ValidationUtil validationUtil ) {
        this.astronomerRepository = astronomerRepository;
        this.starRepository = starRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported () {
        return astronomerRepository.count ( ) > 0;
    }

    @Override
    public String readAstronomersFromFile () throws IOException {
        return String.join ( "\n", Files.readAllLines (
                Path.of ( IMPORT_FILE_PATH ) ) ) + "\n";
    }

    @Override
    public String importAstronomers () throws IOException, JAXBException {
        if ( areImported ( ) ) {
            return "Data already imported!";
        }
        StringBuilder reportBuilder = new StringBuilder ( );

        ImportAstronomersXmlDto astronomers = xmlParser ( );

        astronomers.getAstronomers ( ).stream ( ).filter ( a -> {
            if ( !this.validationUtil.isValid ( a ) ||
                    astronomerRepository.existsByFirstNameAndLastName ( a.getFirstName ( ), a.getLastName ( ) ) ||
                    !starRepository.existsStarsById ( a.getObservingStarId ( ) ) ) {

                reportBuilder.append ( "Invalid astronomer" ).append ( System.lineSeparator ( ) );
                return false;
            }
            return true;

        } ).map ( a -> {
            Astronomer astronomer = modelMapper.map ( a, Astronomer.class );
            if ( a.getBirthday ( ) != null ) {
                astronomer.setBirthday ( LocalDate.parse ( a.getBirthday ( ) ) );
            }
            astronomer.setObservingStar ( starRepository.findStarById ( a.getObservingStarId ( ) ) );
            return astronomer;

        } ).forEach ( a -> {
            reportBuilder.append ( String.format ( SUCCESSFULLY_IMPORTED_TEMPLATE, a.getFirstName ( ), a.getLastName ( ), a.getAverageObservationHours ( ) ).replace ( ",","." ) )
                    .append ( System.lineSeparator ( ) );

            astronomerRepository.saveAndFlush ( a );
        } );
        return reportBuilder.toString ( );
    }

    private ImportAstronomersXmlDto xmlParser () throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance ( ImportAstronomersXmlDto.class );
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller ( );
        return (ImportAstronomersXmlDto) unmarshaller.unmarshal ( new File ( IMPORT_FILE_PATH ) );
    }
}
