package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportConstellationJsonDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.interfaces.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class ConstellationServiceImpl implements ConstellationService {
    private static final String IMPORT_FILE_PATH = "src/main/resources/files/json/constellations.json";
    private static final String SUCCESSFULLY_IMPORTED_TEMPLATE = "Successfully imported constellation %s - %s";

    private final ConstellationRepository constellationRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public ConstellationServiceImpl ( ConstellationRepository constellationRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validator ) {
        this.constellationRepository = constellationRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validator;
    }

    @Override
    public boolean areImported () {
        return this.constellationRepository.count ( ) > 0;
    }

    @Override
    public String readConstellationsFromFile () throws IOException {
        return String.join ( "\n", Files.readAllLines (
                Path.of ( IMPORT_FILE_PATH ) ) );
    }

    @Override
    public String importConstellations () throws IOException {
        if ( areImported ( ) ) {
            return "Data already imported!";
        }
        StringBuilder reportBuilder = new StringBuilder ( );
        Arrays.stream ( this.gson.fromJson ( readConstellationsFromFile ( ), ImportConstellationJsonDto[].class ) ).filter ( c -> {
                    if ( !this.validationUtil.isValid ( c ) || constellationRepository.existsConstellationByName ( c.getName ( ) ) ) {
                        reportBuilder.append ( "Invalid constellation" ).append ( System.lineSeparator ( ) );
                        return false;
                    }
                    return true;

                } )
                .map ( c -> this.modelMapper.map ( c, Constellation.class ) )
                .forEach ( c -> {
                    reportBuilder.append ( String.format ( SUCCESSFULLY_IMPORTED_TEMPLATE, c.getName (), c.getDescription () ) )
                            .append ( System.lineSeparator ( ) );

                    constellationRepository.saveAndFlush ( c );
                } );
        return reportBuilder.toString ( );
    }
}
