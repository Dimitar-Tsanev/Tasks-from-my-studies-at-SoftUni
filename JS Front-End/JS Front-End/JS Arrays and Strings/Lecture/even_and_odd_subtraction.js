function evenAndOddsDifference(input){
    let oddSum = 0;
    let evenSum = 0;
    
    for(let i = 0; i < input.length; i++){
        if (input[i] % 2 === 0){
            evenSum += input[i];

        }else{
            oddSum += input[i];
        }
    }
    console.log(evenSum - oddSum);
}
evenAndOddsDifference([1,2,3,4,5,6]);
evenAndOddsDifference([3,5,7,9]);
evenAndOddsDifference([2,4,6,8,10]);