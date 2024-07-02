function sortingSmallBig(array){
    let arrayCopy = array.slice();
    let result = [];

    while (arrayCopy.length > 0){
        let min = Math.min.apply(Math, arrayCopy);
        let smallestElementIndex = arrayCopy.indexOf(min);
        result.push(min);
        arrayCopy.splice(smallestElementIndex, 1);

        if (arrayCopy.length === 0 ){
            break;
        }

        let max = Math.max.apply(Math, arrayCopy);
        let biggestElementIndex = arrayCopy.indexOf(max);
   
        result.push(max);

        arrayCopy.splice(biggestElementIndex, 1);
    }

    return result;
}
