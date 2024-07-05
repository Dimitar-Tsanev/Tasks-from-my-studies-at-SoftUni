function isNumberPerfect(num){
    let dividersSum = 1;
    for(let i = 2; i < num; i++){
        if (num % i === 0 ){
            dividersSum += i;
        }
    }
    console.log(dividersSum === num ? 'We have a perfect number!' : 'It\'s not so perfect.' )
}
isNumberPerfect(6);
isNumberPerfect(28);
isNumberPerfect(1236498);