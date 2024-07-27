function subtract() {
     //TODO:...
    let firstNumber = Number(document.getElementById('firstNumber').value);
    let secondNumber = Number(document.getElementById('secondNumber').value);

    let result = document.getElementById('result');
    result.textContent = firstNumber - secondNumber;
}
