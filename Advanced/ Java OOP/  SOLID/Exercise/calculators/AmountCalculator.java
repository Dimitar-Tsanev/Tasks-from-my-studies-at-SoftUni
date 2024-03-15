package calculators;

import products.Product;

import java.util.List;

public class AmountCalculator implements Calculator {
    private final List<? extends Product> products;

    public AmountCalculator ( List<? extends Product> amountables ) {
        this.products = amountables;
    }

    @Override
    public double sum () {
        return this.products.stream( ).mapToDouble ( Product::amount ).sum ();
    }

    @Override
    public double average () {
        return this.sum() / this.products.size();
    }
}
