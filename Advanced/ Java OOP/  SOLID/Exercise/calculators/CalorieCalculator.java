package calculators;

import products.Product;

import java.util.List;

public class CalorieCalculator implements Calculator {

    private final List<? extends Product> products;

    public CalorieCalculator(List<? extends Product> products) {
        this.products = products;
    }
    @Override
    public double sum() {
        return this.products.stream ( ).mapToDouble (Product::getCalories).sum ( );
    }
    @Override
    public double average() {
        return this.sum() / products.size();
    }
}
