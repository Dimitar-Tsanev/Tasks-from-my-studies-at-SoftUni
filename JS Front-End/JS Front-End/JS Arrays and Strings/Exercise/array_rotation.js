function rotateArray(array, position){
    let result = array;

    for (let i = 0; i < position; i++){
        const element = result.shift();
        result.push(element);
    }
    console.log(result.join(' '));
}
rotateArray([51, 47, 32, 61, 21], 2);
rotateArray([32, 21, 61, 1], 4);
rotateArray([2, 4, 15, 31], 5);
