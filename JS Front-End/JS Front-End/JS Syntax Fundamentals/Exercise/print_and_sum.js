function printSumAndNumbersBetweenValues(num1, num2){
    let numbers = '';

    let sum = 0;
    
    for (let i = num1; i <= num2; i++){
        numbers += i + " ";
        sum += i;
    }
    console.log(numbers)
    console.log(`Sum: ${sum}`)
}
printSumAndNumbersBetweenValues(5, 10);
printSumAndNumbersBetweenValues(0, 26);
printSumAndNumbersBetweenValues(50, 60);