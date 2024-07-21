function getProducts(availableProducts, orderedProducts){
    let allProducts = new Map();
    
    addProduct(availableProducts, allProducts);
    addProduct(orderedProducts, allProducts);
    
    for (const [key, value] of allProducts) {
        console.log(`${key} -> ${value}`);
    }
    
    function addProduct(products, allProducts){
        for(let i = 0; i < products.length; i += 2 ){
            const productName = products[i];
            const productQuantity = Number(products[i + 1]);
            
            if (!allProducts.has(productName)){
                allProducts.set(productName, 0)
            }
            
            allProducts.set(productName, allProducts.get(productName) + productQuantity);
        }
    }
}
getProducts([
    'Chips', '5', 'CocaCola', '9', 'Bananas', '14', 'Pasta', '4', 'Beer', '2'
],
[
    'Flour', '44', 'Oil', '12', 'Pasta', '7', 'Tomatoes', '70', 'Bananas', '30'
]);
getProducts([
    'Salt', '2', 'Fanta', '4', 'Apple', '14', 'Water', '4', 'Juice', '5'
],
[
    'Sugar', '44', 'Oil', '12', 'Apple', '7', 'Tomatoes', '7', 'Bananas', '30'
]);