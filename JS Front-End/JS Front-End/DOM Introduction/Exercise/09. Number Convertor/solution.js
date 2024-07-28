function solve() {
    //TODO...
    const selectMenu = document.getElementById('selectMenuTo');

    const optionBinary = selectMenu.children[0];
    optionBinary.value = 'binary';
    optionBinary.textContent = 'Binary';

    const optionHexadecimal = document.createElement('option');
    optionHexadecimal.value = 'hexadecimal';
    optionHexadecimal.textContent = 'Hexadecimal';

    selectMenu.appendChild(optionHexadecimal);
        
    document.querySelector('button').addEventListener('click', calculate);

    function calculate(){
        const input = Number(document.getElementById('input').value);
        const outputElement = document.getElementById('result');

        switch (selectMenu.value){
            case optionBinary.value:
                outputElement.value = parseInt(input).toString(2)
                break;
            
            case optionHexadecimal.value:
                outputElement.value = parseInt(input).toString(16).toUpperCase()
                break;
        }
    }
}