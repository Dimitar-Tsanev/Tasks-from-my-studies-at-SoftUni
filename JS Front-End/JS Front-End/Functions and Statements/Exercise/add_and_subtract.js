/*Task description -> Write a function sum() to calculate the sum of the first two integers
 and a function subtract(), which subtracts the result of the function
 the sum() and the third integer.*/

function addAndSubtract(num1, num2, num3){
    console.log(subtract(sum(num1, num2),num3));

    function sum(num1, num2){
        return num1 + num2;
    }

    function subtract(num1, num2){
        return num1 - num2;
    }
}
addAndSubtract(23,6,10);