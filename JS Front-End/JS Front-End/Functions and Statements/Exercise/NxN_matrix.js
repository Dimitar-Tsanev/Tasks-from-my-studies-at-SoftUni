function printMatrixNxN(num){
    let row = (`${num} `.repeat(num)).trim();
    for (let i = 1; i <= num; i++){
        console.log(row)
    }
}
printMatrixNxN(2);
printMatrixNxN(3);
printMatrixNxN(7);

