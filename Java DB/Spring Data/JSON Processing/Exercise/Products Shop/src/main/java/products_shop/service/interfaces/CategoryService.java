package products_shop.service.interfaces;

import java.io.IOException;

public interface CategoryService {
    void importCategories() throws IOException;

    boolean areImported();
}
