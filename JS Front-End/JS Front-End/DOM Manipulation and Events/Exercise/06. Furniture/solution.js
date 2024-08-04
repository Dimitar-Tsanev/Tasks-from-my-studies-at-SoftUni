function solve() {
  //TODO...
  const input = document.querySelector('#exercise textarea:first-of-type');
  const output = document.querySelector('#exercise div+textarea');
  output.value =''
  
  const tableBody = document.querySelector('.table tbody') 
  
  const generateButton = document.querySelector('#exercise button');
  
  generateButton.addEventListener('click', () => {
    const items = JSON.parse(input.value);
    input.value = '';
    
    
    items.forEach(object => {
      const newTrElement = document.createElement('tr');
      
      for(let i = 0; i < Object.keys(object).length; i++ ){
        const newTdElement = document.createElement('td');
        const newPElement = document.createElement('p');
        switch(i){
          case 0:
            const neImgElement = document.createElement('img');
            neImgElement.src = object['img'];
            newTdElement.appendChild(neImgElement);
            break;
          case 1:
            newPElement.textContent = object['name'];
            newTdElement.appendChild(newPElement);
            break;

          case 2:
            newPElement.textContent = object['price'];
            newTdElement.appendChild(newPElement);
            break;

          case 3:
            newPElement.textContent = object['decFactor'];
            newTdElement.appendChild(newPElement);
            break;
        }
        newTrElement.appendChild(newTdElement);
      }
      
      const newTddElement = document.createElement('td');
      
      const newInputTypeCheckbox = document.createElement('input');
      newInputTypeCheckbox.type ='checkbox';
      
      newTddElement.appendChild(newInputTypeCheckbox);
      newTrElement.appendChild(newTddElement);
      
      tableBody.appendChild(newTrElement);
    });
  });
  
  const tableRows = tableBody.getElementsByTagName('tr');
  
  const buyButton = document.querySelector('#exercise div+textarea+button')
  
  buyButton.addEventListener('click', () => {
    output.value =''
    
    const checkedRows = Array.from(tableRows).filter(row => {
      const input = row.querySelector('td input[type="checkbox"]');
      
      if(input.checked){
        return true;
        
      }else{
        return false;
      }
    });
    let itemList = [];
    let totalPrice = 0;
    let averageDecorationFactor = 0;
    
    checkedRows.forEach(row => {
      const elementsInCells =  Array.from(row.querySelectorAll('td *'))
      .map(cell => cell.textContent);
      
      const cellsHeadersNames = Array.from(document.querySelectorAll('.table thead tr th'))
      .map(cell => cell.textContent);
      
      cellsHeadersNames.forEach(name => {
        const index = cellsHeadersNames.indexOf(name);
        
        switch(name){
          case 'Name':
          itemList.push(elementsInCells[index])
          break;
          
          case 'Price':
          totalPrice += Number(elementsInCells[index])
          break;
          
          case 'Decoration factor':
          averageDecorationFactor += Number(elementsInCells[index]);
          break;
        }
      });
    });
    averageDecorationFactor /= checkedRows.length;
    
    output.value += `Bought furniture: ${itemList.join(', ')}\n`;
    output.value += `Total price: ${totalPrice.toFixed(2)}\n`;
    output.value += `Average decoration factor: ${averageDecorationFactor}`;
  });
}