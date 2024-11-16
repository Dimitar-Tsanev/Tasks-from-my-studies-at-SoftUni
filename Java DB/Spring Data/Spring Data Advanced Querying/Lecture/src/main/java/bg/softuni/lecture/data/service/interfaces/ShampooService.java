package bg.softuni.lecture.data.service.interfaces;

import bg.softuni.lecture.data.entities.Label;
import bg.softuni.lecture.data.entities.Shampoo;

import java.util.List;

public interface ShampooService {
    List<Shampoo> getShampooBySize(String size);

    List<Shampoo> getShampooBySizeOrLabel ( String size, Label label );

    List<Shampoo> getShampooByPriceGreaterThan(double price);

    Integer getShampooCountWithPriceLowerThan ( Double price);

    List<Shampoo> getShampooWithIngredientCount(int count);
}
