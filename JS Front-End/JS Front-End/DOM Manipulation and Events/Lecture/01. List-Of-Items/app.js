function addItem() {
    //TODO:...
    const contentElement = document.getElementById('newItemText');
    const ulElement = document.getElementById('items');
    const liElement = document.createElement('li');
    
    liElement.textContent = contentElement.value;
    
    ulElement.appendChild(liElement);
    
    contentElement.value = '';
}
