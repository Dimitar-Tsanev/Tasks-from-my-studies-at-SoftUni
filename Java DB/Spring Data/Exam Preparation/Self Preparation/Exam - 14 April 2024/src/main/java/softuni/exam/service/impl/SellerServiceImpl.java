package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.models.dto.ImportSellerDto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class SellerServiceImpl implements SellerService {
    private static final String IMPORT_FILE_PATH = "src/main/resources/files/json/sellers.json";
    private static final String SUCCESSFULLY_IMPORTED_TEMPLATE = "Successfully imported seller %s %s";


    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    @Autowired
    public SellerServiceImpl ( SellerRepository sellerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson ) {
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported () {
        return sellerRepository.count ( ) > 0;
    }

    @Override
    public String readSellersFromFile () throws IOException {
        return String.join ( System.lineSeparator ( ), Files.readAllLines (
                Path.of ( IMPORT_FILE_PATH ) ) );
    }

    @Override
    public String importSellers () throws IOException {
        if ( areImported ( ) ) {
            return "Data already imported!";
        }
        StringBuilder reportBuilder = new StringBuilder ( );
        Arrays.stream ( this.gson.fromJson ( readSellersFromFile ( ), ImportSellerDto[].class ) ).filter ( s -> {
                    if ( !this.validationUtil.isValid ( s ) || sellerRepository.existsSellerByLastName ( s.getLastName ( ) ) ) {
                        reportBuilder.append ( "Invalid seller" ).append ( System.lineSeparator ( ) );
                        return false;
                    }
                    return true;

                } )
                .map ( s -> this.modelMapper.map ( s, Seller.class ) )
                .forEach ( s -> {
                        reportBuilder.append ( String.format ( SUCCESSFULLY_IMPORTED_TEMPLATE, s.getFirstName (), s.getLastName () ) )
                                .append ( System.lineSeparator ( ) );

                        sellerRepository.saveAndFlush ( s );
                });
        return reportBuilder.toString ( );
    }
}
