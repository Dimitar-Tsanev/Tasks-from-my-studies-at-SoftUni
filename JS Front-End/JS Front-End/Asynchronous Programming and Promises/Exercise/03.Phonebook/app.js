function attachEvents() {
    // TODO:
    const baseUrl = 'http://localhost:3030/jsonstore/phonebook';

    const loadButton = document.getElementById('btnLoad');
    loadButton.addEventListener('click', loadPhonebookHandler);

    const createButton = document.getElementById('btnCreate');
    createButton.addEventListener('click', createContactHandler);

    function deleteContactHandler(e){
        const elementToDelete = e.target.parentElement;

        const idToDelete = elementToDelete.id;

        fetch(`${baseUrl}/${idToDelete}`,{method: 'DELETE'})
        .then( loadPhonebookHandler)
        .catch(error => console.log(error + 'error'));
   
    };

    function createContactHandler(){
        const inputElementForPerson = document.getElementById('person');
        const inputElementForPhone = document.getElementById('phone');

        fetch(baseUrl, {
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                person: inputElementForPerson.value,
                phone: inputElementForPhone.value,
            })
        })
        inputElementForPerson.value = '';
        inputElementForPhone.value = '';
        loadPhonebookHandler();
    }

    function loadPhonebookHandler(){
        const displayElement = document.getElementById('phonebook');

        fetch(baseUrl)
            .then(response => response.json())
            .then(result =>{
                displayElement.innerHTML = '';

                for (const key in result) {
                   const liElement = document.createElement('li');

                   const {person, phone, _id} = result[key]; 

                   liElement.setAttribute('id',_id);
                   liElement.textContent = `${person}: ${phone}`;

                   const deleteButton = document.createElement('button');
                   deleteButton.textContent = 'Delete';
                   deleteButton.addEventListener('click',(e) => deleteContactHandler(e));

                   liElement.appendChild(deleteButton);

                   displayElement.appendChild(liElement);
                }
            });
    }


}

attachEvents();