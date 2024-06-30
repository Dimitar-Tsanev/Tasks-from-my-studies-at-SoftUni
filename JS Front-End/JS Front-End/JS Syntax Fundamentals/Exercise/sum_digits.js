function sumDigits(digits){
    const digitsToString = digits.toString();

    let sum = 0;

    for (let i = 0; i < digitsToString.length; i++){
        sum += Number(digitsToString[i]);
    }
    console.log(sum);
}
sumDigits(245678);
sumDigits(97561);
sumDigits(543);