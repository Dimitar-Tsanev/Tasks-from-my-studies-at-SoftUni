function simpleCalculator(num1, num2, operation){
    let calculator = new Map();

    calculator.set('multiply', x = (a,b) => a * b )
            .set('divide', x = (a,b) => a / b)
            .set('add', x = (a,b) => a + b)
            .set('subtract', x = (a,b) => a - b);

    let currentOperation = calculator.get(operation);

    console.log(currentOperation(num1, num2));
}
simpleCalculator(5, 5,'multiply');