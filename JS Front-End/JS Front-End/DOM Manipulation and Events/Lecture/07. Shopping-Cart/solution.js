function solve() {
   //TODO...
   const products = document.getElementsByClassName('product');
   const addButtons = document.getElementsByClassName('add-product');
   const outputElement = document.querySelector('textarea');
   const buyCardButton = document.querySelector('.checkout');

   outputElement.value = '';

   let card = {};
   
   Array.from(addButtons).forEach(button => button.addEventListener('click', (event) => {
      const currentProduct = event.currentTarget.parentElement.parentElement;
      
      const productName = currentProduct.querySelector('.product-title').textContent;
      const productPrice = Number(currentProduct.querySelector('.product-line-price').textContent);
      
      outputElement.value += `Added ${productName} for ${productPrice.toFixed(2)} to the cart.\n`
      
      if (!card.hasOwnProperty(productName)){
         card[productName] = 0;
      }

      card[productName] += productPrice;
   }));
   
   buyCardButton.addEventListener('click', (event) => {
      let products = '';
      let totalPrice = 0;

      for (const key in card) {
         products += key + ', ';
         totalPrice += card[key];
      }
      products = products.substring(0,products.length - 2);
      outputElement.value += `You bought ${products} for ${totalPrice.toFixed(2)}.`;

      document.querySelectorAll('button').forEach(b => b.disabled = true)
   });
}
