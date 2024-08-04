function create(words) {
   //TODO:...
   const newDivElement = document.createElement('div');
   const newParagraphElement = document.createElement('p');
   
   const containerElement = document.getElementById('content');
   
   words.forEach(word => {
      const newDivElement = document.createElement('div');
      const newParagraphElement = document.createElement('p');
      
      newParagraphElement.textContent = word;
      newParagraphElement.style.display = 'none';
      
      newDivElement.appendChild(newParagraphElement);
      containerElement.appendChild(newDivElement);
   });

   containerElement.addEventListener('click', (e) => {
      e.target.querySelector('p').style.display = 'block'
   });
}