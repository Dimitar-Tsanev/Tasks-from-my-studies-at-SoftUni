package bookshop.service.interfaces;

import bookshop.data.entities.Category;

import java.util.Set;


public interface CategoryService extends DatabaseSeed {

    Set<Category> getRandomCategories();

    Category getById(long id);
}
