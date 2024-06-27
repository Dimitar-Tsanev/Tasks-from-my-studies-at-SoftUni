function largestNumber (...numbers){
    let biggestNumber = Number.MIN_SAFE_INTEGER;

    numbers.forEach(element => {
        if(biggestNumber < element){
            biggestNumber = element
        }

    });

    console.log(`The largest number is ${biggestNumber}.`);
}
largestNumber(5, -3, 16);
largestNumber(-3, -5, -22.5);