package bookshop.service;

import bookshop.data.entities.Category;
import bookshop.data.repositories.CategoryRepository;
import bookshop.service.interfaces.CategoryService;
import bookshop.service.interfaces.DatabaseSeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService, DatabaseSeed {
    private static final Path RESOURCE_PATH = Path.of ( "src/main/resources/files/categories.txt" ).toAbsolutePath ( );

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl ( CategoryRepository categoryRepository ) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seed () throws IOException {
        if ( categoryRepository.count ( ) != 0 ) {
            return;
        }

        Files.readAllLines ( RESOURCE_PATH )
                .stream ( )
                .filter ( l -> !l.isBlank ( ) )
                .map ( Category::new )
                .forEach ( categoryRepository::save );
    }

    @Override
    public Set<Category> getRandomCategories () {
        Set<Category> categories = new HashSet<> ( );

        long count = ThreadLocalRandom.current().nextLong (1, 4 );
        for ( int i = 0 ; i <= count ; i++ ) {

            long randomId = ThreadLocalRandom.current ().nextLong ( 1,categoryRepository.count ( ) + 1 );
            categories.add ( categoryRepository.findById ( randomId ) );
        }

        return categories;
    }

    @Override
    public Category getById ( long id ) {
        return categoryRepository.getReferenceById ( id );
    }

}
