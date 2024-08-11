function attachEvents() {
    // TODO:
    const url = 'http://localhost:3030/jsonstore/messenger';
    
    const sendButton = document.getElementById('submit');
    const refreshButton = document.getElementById('refresh');
    
    sendButton.addEventListener('click', sendMessageHandler);
    refreshButton.addEventListener('click', loadMessagesHandler);
    
    function sendMessageHandler(){
        const authorInputElement = document.querySelector('input[name="author"]');
        const messageContentElement = document.querySelector('input[name="content"]');
        
        fetch(url,{
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                author: authorInputElement.value,
                content: messageContentElement.value,
            })
        })
        
        authorInputElement.value = '';
        messageContentElement.value = '';
    }
    
    function loadMessagesHandler(){
        const displayContentElement = document.getElementById('messages');
        
        fetch(url)
        .then(response => response.json())
        .then(result => {
            displayContentElement.textContent = '';

            const messages = [];
            
            for (const key in result) {
                const {author, content} = result[key];

                messages.push(`${author}: ${content}`);
            }
            displayContentElement.textContent = messages.join('\n');
        })  
    }
}

attachEvents();