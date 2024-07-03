function findSmallestNumber(...args){
    let smallestNumber = Math.min.apply(Math, args);

    console.log(smallestNumber);
}
findSmallestNumber(2, 5, 3);
findSmallestNumber(600, 342, 123);
findSmallestNumber(25, 21, 4);
findSmallestNumber(2, 2, 2);