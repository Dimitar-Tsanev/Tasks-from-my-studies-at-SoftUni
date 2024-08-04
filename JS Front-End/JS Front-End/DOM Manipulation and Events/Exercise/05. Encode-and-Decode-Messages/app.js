function encodeAndDecodeMessages() {
    // TODO...
    let buttons = document.querySelectorAll('#main div textarea+button');

    buttons.forEach(button => {
        const inputElement = button.parentElement.querySelector('textarea');

        if(button.textContent === 'Encode and send it'){
            button.addEventListener('click', () =>{
                const textToEncode = inputElement.value;
                let encodedMessage = '';
        
                for(let i = 0; i < textToEncode.length; i++){
                    encodedMessage += String.fromCharCode(textToEncode[i].charCodeAt() + 1);
                }
                const [headerBeforeOutput, _ ] = Array.from(document.querySelectorAll('#main div *'))
                                .filter(element => element.textContent === 'Last received message');
        
                const outputElement = headerBeforeOutput.parentElement.querySelector('textarea');
        
                outputElement.value = encodedMessage;
                inputElement.value ='';
            });
            
        }else if(button.textContent === 'Decode and read it'){
            button.addEventListener('click', () => {
                const textToEncode = inputElement.value;
                let encodedMessage = '';
        
                for(let i = 0; i < textToEncode.length; i++){
                    encodedMessage += String.fromCharCode(textToEncode[i].charCodeAt() - 1);
                }
                inputElement.value = encodedMessage;
            });
        }
    });
}
