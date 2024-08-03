function focused() {
    //TODO:...
    const elements = document.querySelectorAll('body div div input[type="text"]');
    
    elements.forEach(el => el.addEventListener('focus', (event) => {
        elements.forEach(el => el.parentElement.classList.remove('focused'));
        event.currentTarget.parentElement.classList.add('focused');

    }));  
}
