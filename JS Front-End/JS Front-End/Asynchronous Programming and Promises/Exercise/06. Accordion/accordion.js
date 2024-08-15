window.addEventListener("load", solution);

function solution() {
    //TODO .....
    const articleTitlesURL = 'http://localhost:3030/jsonstore/advanced/articles/list';
    const articleContentBaseUrl = 'http://localhost:3030/jsonstore/advanced/articles/details';

    const containerElement = document.getElementById('main');

    const buttonValueShow = 'More'.toUpperCase();
    const buttonValueHide = 'Less'.toUpperCase();

    fetch(articleTitlesURL)
        .then(response => response.json())
        .then(result => {
         result.forEach(element => {
            
            const {_id, title} = element;
            
            const articleContainerElement = document.createElement('div');
            articleContainerElement.classList.add('accordion');

            const headContainerElement = document.createElement('div');
            headContainerElement.classList.add('head');

            const titleElement = document.createElement('span');
            titleElement.textContent = title;

            headContainerElement.appendChild(titleElement);

            const showHideButtonElement = document.createElement('button');
            showHideButtonElement.classList.add('button');
            showHideButtonElement.setAttribute('id', _id);
            showHideButtonElement.textContent = buttonValueShow;

            headContainerElement.appendChild(showHideButtonElement);

            articleContainerElement.appendChild(headContainerElement);

            containerElement.appendChild(articleContainerElement);

            showHideButtonElement.addEventListener('click', (e) => getContent(e));
         });  
    });

    function getContent(e){
        const articleContainerElement = e.target.closest('.accordion');
        const contentElement = articleContainerElement.querySelector('.extra');
        const button = e.target;

        if(!contentElement){
            const id = e.target.id;
            fetch(`${articleContentBaseUrl}/${id}`)
                .then(response => response.json())
                .then(result => {
                    const {_id, content, title} = result;

                    const contentContainerElement = document.createElement('div');
                    containerElement.style.display = 'block'
                    contentContainerElement.classList.add('extra');
    
                    const contentElement = document.createElement('p');
                    contentElement.textContent = content;
    
                    contentContainerElement.appendChild(contentElement);
    
                    articleContainerElement.appendChild(contentContainerElement);
                    button.textContent = buttonValueHide;
            });
     
        }else{
            if(button.textContent === buttonValueShow){
                containerElement.style.display = 'block'
                button.textContent = buttonValueHide;
                

            }else if (button.textContent === buttonValueHide) {
                button.textContent = buttonValueShow;
                containerElement.style.display = 'none';
            }
        }
    }
}