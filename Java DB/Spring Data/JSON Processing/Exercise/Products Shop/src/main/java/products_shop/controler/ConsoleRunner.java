package products_shop.controler;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import products_shop.service.interfaces.CategoryService;
import products_shop.service.interfaces.ProductService;
import products_shop.service.interfaces.UserService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private static final String EXPORT_PATH = "src/main/resources/exportJson/";

    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;

    public ConsoleRunner(UserService userService, CategoryService categoryService, ProductService productService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run ( String... args ) throws Exception {
        if(!userService.areImported ()){
            userService.importUsers();
        }
        if(!categoryService.areImported()){
            categoryService.importCategories();
        }
        if(!productService.areImported()){
            productService.insertProduct ();
        }
        export ( "products-in-range.json", productService.getNotSoledProductInPriceRange ( 500.00, 1000.00 ) );
        export ( "users-sold-products.json", userService.getALlUsersWithSuccessfulSale () );

    }

    private void export(String fileName, String json) throws IOException {
        String fullPath = EXPORT_PATH + fileName;
        if(!Files.exists ( new File (fullPath).toPath () )){
            Files.createFile( Path.of ( fullPath));
        }
        FileWriter fileWriter = new FileWriter ( fullPath);
        fileWriter.write (json);
        fileWriter.close();
    }
}
