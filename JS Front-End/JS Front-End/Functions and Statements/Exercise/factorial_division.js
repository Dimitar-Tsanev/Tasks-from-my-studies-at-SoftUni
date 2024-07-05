function factorialDivision(num1, num2){
    let num1factorial = findFactorial(num1);
    let num2factorial = findFactorial(num2);

    console.log ((num1factorial / num2factorial).toFixed(2));

    function findFactorial (num){
        let factorial = num;
        if (num <= 1){
            return 1;

        }else{
            factorial = factorial * findFactorial(num - 1);

        }
        return factorial;
    }
}
factorialDivision(5,2);