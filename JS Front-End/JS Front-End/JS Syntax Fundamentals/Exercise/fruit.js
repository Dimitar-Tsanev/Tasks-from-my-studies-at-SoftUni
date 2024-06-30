function moneyNeededForFruits(fruit, weightInGrams, pricePerKg){
    const weightInKg = weightInGrams / 1000;
    console.log(`I need $${(pricePerKg * weightInKg).toFixed(2)} to buy ${weightInKg.toFixed(2)} kilograms ${fruit}.`);
}
moneyNeededForFruits('orange', 2500, 1.80);
moneyNeededForFruits('apple', 1563, 2.35);