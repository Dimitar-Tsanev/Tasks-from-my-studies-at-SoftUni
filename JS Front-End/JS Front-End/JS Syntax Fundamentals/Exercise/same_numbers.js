function isNumbersSame(num){
    const numToString = num.toString();
    const digit = numToString[0];
    let areSame = true;
    let sum = 0;

    for (let index = 0; index < numToString.length; index++) {
        if (digit !== numToString[index]){
            areSame = false;
        }
        sum += Number(numToString[index]);
    }
    console.log(areSame);
    console.log(sum);
}
isNumbersSame(2222222);
isNumbersSame(1234)