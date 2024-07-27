function toggle() {
    // TODO:...
    const buttonTextMore = 'More';
    const buttonTextLess = 'Less';

    const contentElement = document.getElementById('extra');
    const buttonElement = document.querySelector('div.head span.button');

    if (buttonElement.textContent === buttonTextMore){
        contentElement.style.display = 'block';
        buttonElement.textContent = buttonTextLess;

    }else{
        contentElement.style.display = 'none';
        buttonElement.textContent = buttonTextMore;
    }
}
