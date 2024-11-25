package products_shop.service;

import com.google.gson.Gson;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import products_shop.data.DTO.ImportProductJsonDto;
import products_shop.data.DTO.NotSoledProductsInRangeDTO;
import products_shop.data.entity.Category;
import products_shop.data.entity.Product;
import products_shop.data.entity.User;
import products_shop.data.repositorie.CategoryRepository;
import products_shop.data.repositorie.ProductRepository;
import products_shop.data.repositorie.UserRepository;
import products_shop.service.interfaces.ProductService;
import products_shop.util.interfacces.ValidatorUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductServiceImpl implements ProductService {
    private static final String IMPORT_FILE_PATH = "src/main/resources/imports/products.json";

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidatorUtil validator;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository, CategoryRepository categoryRepository, ModelMapper modelMapper, Gson gson, ValidatorUtil validator) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validator = validator;
    }
    @Override
    public void insertProduct () throws IOException {
        String jsonString = String.join ( "", Files.readAllLines ( Path.of ( IMPORT_FILE_PATH ) ) );

        Set<Product> products = Arrays.stream ( this.gson.fromJson ( jsonString, ImportProductJsonDto[].class ) )
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
                .map ( s -> {
                    Product product = this.modelMapper.map ( s, Product.class );
                    product.setSeller ( getRandomSeller());

                    Set<Category> categories;
                    int count = ThreadLocalRandom.current().nextInt (1,4);
                    categories = IntStream.range ( 0, count ).mapToObj ( i -> getRandomCategory ( ) ).collect ( Collectors.toSet ( ) );
                    product.setCategories ( categories );

                    product.setBuyer ( getRandomBuyer() );
                    return product;
                } ).collect( Collectors.toSet());

        productRepository.saveAll ( products );
    }

    private User getRandomBuyer () {
        return this.userRepository.findById ( ThreadLocalRandom.current().nextLong (1, this.userRepository.count () + 5) ).orElse ( null );
    }

    private Category getRandomCategory () {
        return this.categoryRepository.findById ( ThreadLocalRandom.current().nextLong (1, this.categoryRepository.count ()) ).get ();
    }

    private User getRandomSeller () {
        return this.userRepository.findById ( ThreadLocalRandom.current().nextLong (1, this.userRepository.count ()) ).get ();
    }

    @Override
    public boolean areImported () {
        return productRepository.count() > 0;
    }

    @Override
    public String getNotSoledProductInPriceRange ( Double min, Double max ) {
       Set<NotSoledProductsInRangeDTO> notSoled = productRepository.findAllByPriceIsBetweenAndBuyerIsNullOrderByPriceAsc ( min, max)
               .stream( )
               .map ( p -> {
                   NotSoledProductsInRangeDTO products = modelMapper.map ( p, NotSoledProductsInRangeDTO.class );
                   String sellerName = (p.getSeller ().getFirstName () != null ?  p.getSeller ().getFirstName () + " ": "" ) + p.getSeller ().getLastName ();
                   products.setSeller (sellerName );
                   return products;
               }).collect( Collectors.toSet());
        return this.gson.toJson (notSoled );
    }
}
