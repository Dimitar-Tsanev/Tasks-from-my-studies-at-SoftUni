window.addEventListener("load", solve);

function solve() {
    //...TODO
    const inputForNameElement = document.getElementById('name');
    const inputForPhoneElement = document.getElementById('phone');
    const selectForCategoryElement = document.getElementById('category');

    clearInput();

    const addButton = document.getElementById('add-btn');

    addButton.addEventListener('click', addToChecklist);
    
    function addToChecklist(){
      if (!inputForNameElement.value || !inputForPhoneElement.value || !selectForCategoryElement.value){
        return;
      }
      const outputElement = document.getElementById('check-list');

      const liElement = document.createElement('li');
      const articleElement = document.createElement('article');

      const paragraphsElements = new Array(3).fill().map(e => document.createElement('p'));

      paragraphsElements[0].textContent = `${inputForNameElement.id}:${inputForNameElement.value}`;
      paragraphsElements[1].textContent = `${inputForPhoneElement.id}:${inputForPhoneElement.value}`;
      paragraphsElements[2].textContent = `${selectForCategoryElement.id}:${selectForCategoryElement.value}`;

      paragraphsElements.forEach(e => articleElement.appendChild(e));

      liElement.appendChild(articleElement);

      const buttonsContainer = document.createElement('div');
      buttonsContainer.classList.add('buttons');

      const editButton = document.createElement('button');
      editButton.classList.add('id', 'edit-btn' );

      const saveButton = document.createElement('button');
      saveButton.classList.add('id', 'save-btn' );

      editButton.addEventListener('click', () => editOutput(outputElement, liElement));
      saveButton.addEventListener('click', () => save(liElement));

      buttonsContainer.appendChild(editButton);
      buttonsContainer.appendChild(saveButton);

      liElement.appendChild(buttonsContainer);

      outputElement.appendChild(liElement);
      clearInput();
    }

    function editOutput(outputElement, liElement){
      const paragraphs = Array.from(liElement.querySelectorAll('article p'));
      inputForNameElement.value = (paragraphs[0].textContent).split(':')[1];
      inputForPhoneElement.value = (paragraphs[1].textContent).split(':')[1];
      selectForCategoryElement.value = (paragraphs[2].textContent).split(':')[1];

      outputElement.removeChild(liElement);
    }

    function save(liElement){
      const contactElement = document.getElementById('contact-list');

     liElement.removeChild(liElement.querySelector('div.buttons'));

      const deleteButton = document.createElement('button');
      deleteButton.classList.add('del-btn');

      deleteButton.addEventListener('click', () => deleteContact(contactElement, liElement));

      liElement.appendChild(deleteButton);

      contactElement.appendChild(liElement);
    }

    function deleteContact(contactElement, liElement){
      contactElement.removeChild(liElement);
    }

    function clearInput(){
      inputForNameElement.value = '';
      inputForPhoneElement.value = '';
      selectForCategoryElement.value = '';
    }
  }
 