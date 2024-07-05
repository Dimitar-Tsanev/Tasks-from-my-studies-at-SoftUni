function sumEvenAndOddDigitsInNumber(num){
    let numArray = num.toString().split('').map(n => Number(n));

    let evenSum = 0;
    let oddSum = 0;

    numArray.forEach(element => {
        element % 2 === 0 ? evenSum += element: oddSum += element;
    });

    console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);

}
sumEvenAndOddDigitsInNumber(1000435);
sumEvenAndOddDigitsInNumber(3495892137259234);