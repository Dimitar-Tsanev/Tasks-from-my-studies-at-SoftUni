package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportSaleDto;
import softuni.exam.models.entity.Sale;
import softuni.exam.repository.SaleRepository;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SaleService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class SaleServiceImpl implements SaleService {
    private static final String IMPORT_FILE_PATH = "src/main/resources/files/json/sales.json";
    private static final String SUCCESSFULLY_IMPORTED_TEMPLATE = "Successfully imported sale with number %s";

    private final SaleRepository saleRepository;
    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, SellerRepository sellerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.saleRepository = saleRepository;
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported () {
        return saleRepository.count() > 0;
    }

    @Override
    public String readSalesFileContent () throws IOException {
        return String.join ( System.lineSeparator (), Files.readAllLines (
                Path.of ( IMPORT_FILE_PATH ) ) );
    }

    @Override
    public String importSales () throws IOException {
        if ( areImported ( ) ) {
            return "Data already imported!";
        }
        StringBuilder reportBuilder = new StringBuilder ( );
        Arrays.stream ( this.gson.fromJson ( readSalesFileContent (), ImportSaleDto[].class ) ).filter ( s -> {
                    if ( !this.validationUtil.isValid ( s ) || saleRepository.existsSaleByNumber ( s.getNumber () ) ) {
                        reportBuilder.append ( "Invalid sale" ).append ( System.lineSeparator ( ) );
                        return false;
                    }
                    return true;

                } )
                .map ( s -> {
                    Sale sale = this.modelMapper.map ( s, Sale.class );
                    sale.setSeller ( sellerRepository.findById ( s.getSeller () ));
                    sale.setSaleDate ( LocalDateTime.parse ( s.getSaleDate (), DateTimeFormatter.ofPattern ( "yyyy-MM-dd HH:mm:ss" ) ) );
                    return sale;

                } )
                .forEach ( s -> {
                    reportBuilder.append ( String.format ( SUCCESSFULLY_IMPORTED_TEMPLATE, s.getNumber () ) )
                            .append ( System.lineSeparator ( ) );

                    saleRepository.saveAndFlush ( s );
                });
        return reportBuilder.toString ( );
    }
}
