function addItem() {
    //TODO:...
    const inputTextElement = document.getElementById('newItemText');
    const inputValueElement = document.getElementById('newItemValue');

    const output = document.getElementById('menu');

    const newOptionElement = document.createElement('option');

    newOptionElement.value = inputValueElement.value;
    newOptionElement.textContent = inputTextElement.value;

    output.appendChild(newOptionElement);

    inputTextElement.value = '';
    inputValueElement.value = '';
}
