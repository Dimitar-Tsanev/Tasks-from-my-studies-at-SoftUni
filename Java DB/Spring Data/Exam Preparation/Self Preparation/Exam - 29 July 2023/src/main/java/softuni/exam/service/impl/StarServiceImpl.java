package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import softuni.exam.models.dto.ImportStarJsonDto;
import softuni.exam.models.entity.Star;
import softuni.exam.models.entity.enums.StarType;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.interfaces.ValidationUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class StarServiceImpl implements StarService {
    private static final String IMPORT_FILE_PATH = "src/main/resources/files/json/stars.json";
    private static final String SUCCESSFULLY_IMPORTED_TEMPLATE = "Successfully imported star %s - %.2f light years";

    private final StarRepository starRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public StarServiceImpl ( StarRepository starRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil ) {
        this.starRepository = starRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported () {
        return starRepository.count ( ) > 0;
    }

    @Override
    public String readStarsFileContent () throws IOException {
        return String.join ( "\n", Files.readAllLines (
                Path.of ( IMPORT_FILE_PATH ) ) );
    }

    @Override
    public String importStars () throws IOException {
        if ( areImported ( ) ) {
            return "Data already imported!";
        }
        StringBuilder reportBuilder = new StringBuilder ( );
        Arrays.stream ( this.gson.fromJson ( readStarsFileContent ( ), ImportStarJsonDto[].class ) ).filter ( s -> {
                    if ( !this.validationUtil.isValid ( s ) || starRepository.existsStarByName ( s.getName ( ) ) ) {
                        reportBuilder.append ( "Invalid star" ).append ( System.lineSeparator ( ) );
                        return false;
                    }
                    return true;

                } )
                .map ( s -> this.modelMapper.map ( s, Star.class ) )
                .forEach ( s -> {
                    reportBuilder.append ( String.format ( SUCCESSFULLY_IMPORTED_TEMPLATE, s.getName ( ), s.getLightYears ( ) ).replaceAll ( ",","." ))
                            .append ( System.lineSeparator ( ) );

                    starRepository.saveAndFlush ( s );
                } );
        return reportBuilder.toString ( );
    }

    @Transactional
    @Override
    public String exportStars () {
        StringBuilder reportBuilder = new StringBuilder ( );
        starRepository.findAllByStarTypeAndObservers_EmptyOrderByLightYearsAsc ( StarType.RED_GIANT )
                .forEach ( s-> reportBuilder.append (s).append ( System.lineSeparator ()));

        return reportBuilder.toString ( );
    }
}
