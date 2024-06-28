function numbersInInterval(num1, num2){
    if (num1 < num2){
        for(let i = num1; i <= num2; i++){
            console.log(i);
        }
    }else{
        for(let i = num1; i >= num2; i--){
            console.log(i);
        }
    }
}
numbersInInterval(6, 2);
numbersInInterval(4,1);
numbersInInterval(1,5);