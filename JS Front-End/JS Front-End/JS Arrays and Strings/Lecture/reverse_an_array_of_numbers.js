function reverseArrayOfNumbers(num, input){
    let result = input.slice(0, num);
    console.log (result.reverse().join(' '));
}
reverseArrayOfNumbers(3, [10, 20, 30, 40, 50]);
reverseArrayOfNumbers(4, [-1, 20, 99, 5]);
reverseArrayOfNumbers(2, [66, 43, 75, 89, 47]);