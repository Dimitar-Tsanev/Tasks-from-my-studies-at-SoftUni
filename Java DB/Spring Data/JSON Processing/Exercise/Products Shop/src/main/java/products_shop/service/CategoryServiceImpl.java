package products_shop.service;

import com.google.gson.Gson;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import products_shop.data.DTO.ImportCategoryJsonDto;
import products_shop.data.entity.Category;
import products_shop.data.repositorie.CategoryRepository;
import products_shop.service.interfaces.CategoryService;
import products_shop.util.interfacces.ValidatorUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final String IMPORT_FILE_PATH = "src/main/resources/imports/categories.json";

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidatorUtil validator;

    @Autowired
    public CategoryServiceImpl ( CategoryRepository categoryRepository, ModelMapper modelMapper, Gson gson, ValidatorUtil validator ) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validator = validator;
    }

    @Override
    public void importCategories () throws IOException {
        String jsonString = String.join ( "", Files.readAllLines ( Path.of ( IMPORT_FILE_PATH ) ) );

        Arrays.stream ( this.gson.fromJson ( jsonString, ImportCategoryJsonDto[].class ) )
                .filter ( s -> {
                    if ( !this.validator.isValid ( s ) ) {
                        System.out.println ( this.validator.validate ( s )
                                .stream ( )
                                .map ( ConstraintViolation::getMessage )
                                .collect ( Collectors.joining ( System.lineSeparator ( ) ) ) );
                        return false;
                    }

                    return true;
                } )
                .map ( s -> this.modelMapper.map ( s, Category.class ) )
                .forEach ( categoryRepository::saveAndFlush );
    }

    @Override
    public boolean areImported () {
        return this.categoryRepository.count() > 0;
    }
}
