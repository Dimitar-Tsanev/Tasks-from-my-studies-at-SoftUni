function addItem() {
    //TODO...
    const contentElement = document.getElementById('newItemText');
    const ulElement = document.getElementById('items');
    
    const liElement = document.createElement('li');
    const linkElement = document.createElement('a');
    
    linkElement.href = '#';
    linkElement.textContent = '[Delete]';
    
    liElement.textContent = contentElement.value;
    liElement.appendChild(linkElement);
    
    ulElement.appendChild(liElement);
    
    contentElement.value = '';
    
    const removeElement = document.querySelectorAll('li>a');
    
    removeElement.forEach(button => button.addEventListener('click', ()=>{
        button.parentElement.remove();
    }));
}
