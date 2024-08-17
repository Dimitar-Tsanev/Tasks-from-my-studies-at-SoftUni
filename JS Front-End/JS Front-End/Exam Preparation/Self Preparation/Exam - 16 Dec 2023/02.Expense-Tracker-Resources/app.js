window.addEventListener("load", solve);

function solve(){
    const inputExpenses = document.getElementById('expense');
    const amountElement = document.getElementById('amount');
    const dateElement = document.getElementById('date');
    
    const addButton = document.getElementById('add-btn');

    const deleteButton = document.querySelector('#expenses button.delete');

    deleteButton.addEventListener('click', () => window.location.reload());
    
    const previewList = document.getElementById('preview-list');
    const expenseList = document.getElementById('expenses-list');
    
    addButton.addEventListener('click', (e) => generatePreview(e) );
    
    function generatePreview(e){
        e.preventDefault();
        
        if (!inputExpenses.value || !amountElement.value || !dateElement.value){
            return;
        }
        addButton.setAttribute('disabled', 'disabled');
        const liElement = document.createElement('li');
        liElement.classList.add('expense-item')
        
        const articleElement = document.createElement('article');
        
        let pElements = new Array(3).fill().map(e => document.createElement('p') );
        
        pElements[0].textContent = `Type: ${inputExpenses.value}`;
        pElements[1].textContent = `Amount: ${amountElement.value}\$`;
        pElements[2].textContent = `Date: ${dateElement.value}`;

        clearInput();
        
        pElements.forEach(p => articleElement.appendChild(p));
        
        liElement.appendChild(articleElement);
        
        const buttonsContainer = document.createElement('div');
        buttonsContainer.classList.add('buttons');
        
        const editButton = document.createElement('button');
        editButton.classList.add('btn');
        editButton.classList.add('edit');
        editButton.textContent = 'edit';
        editButton.addEventListener('click',()=>{
            addButton.removeAttribute('disabled');
            const expense = (articleElement.querySelector('p:nth-of-type(1)').textContent).split(': ')[1];
            const amount = (articleElement.querySelector('p:nth-of-type(2)').textContent).split(': ')[1].replace('$','');
            const date = (articleElement.querySelector('p:nth-of-type(3)').textContent).split(': ')[1];

            inputExpenses.value = expense;
            amountElement.value = amount;
            dateElement.value = date;

            previewList.removeChild(liElement);
        })
        
        const okButton = document.createElement('button');
        okButton.classList.add('btn');
        okButton.classList.add('ok');
        okButton.textContent = 'ok';
        okButton.addEventListener('click',()=>{
            liElement.removeChild(buttonsContainer);
            expenseList.appendChild(liElement);

            addButton.removeAttribute('disabled');
        });
        
        buttonsContainer.appendChild(editButton);
        buttonsContainer.appendChild(okButton);
        
        liElement.appendChild(buttonsContainer);
        
        previewList.appendChild(liElement);
        
    }
    
    function clearInput(){
        inputExpenses.value = '';
        amountElement.value = '';
        dateElement.value = '';
    }
    
}
