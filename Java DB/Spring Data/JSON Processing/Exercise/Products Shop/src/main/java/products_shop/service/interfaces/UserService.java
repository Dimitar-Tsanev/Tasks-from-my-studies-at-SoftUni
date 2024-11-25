package products_shop.service.interfaces;

import java.io.IOException;

public interface UserService {
    void importUsers() throws IOException;

    boolean areImported();

    String getALlUsersWithSuccessfulSale();
}
