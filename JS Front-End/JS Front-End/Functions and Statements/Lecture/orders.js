function productPrice(productType, quantity ){
    const singleProductPrice = new Map();
    singleProductPrice.set('coffee', 1.50).set('water', 1.00).set('coke', 1.40).set('snacks', 2.00);
    
    printTotal(singleProductPrice.get(productType), quantity)

    function printTotal(price, quantity){
        console.log( (price * quantity).toFixed(2));
    }
}