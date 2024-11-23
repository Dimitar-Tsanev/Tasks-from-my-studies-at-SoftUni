package game_store.service.interfaces;

public interface ShoppingCartService {
    String addItem(String itemName);

    String removeItem(String itemName);

    String buyItems();

}
