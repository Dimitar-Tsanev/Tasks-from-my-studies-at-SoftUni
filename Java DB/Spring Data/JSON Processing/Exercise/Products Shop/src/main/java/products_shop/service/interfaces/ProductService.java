package products_shop.service.interfaces;

import products_shop.data.DTO.NotSoledProductsInRangeDTO;
import products_shop.data.entity.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;

public interface ProductService {
    void insertProduct( ) throws IOException;
    boolean areImported();

    String getNotSoledProductInPriceRange( Double min, Double max );
}
