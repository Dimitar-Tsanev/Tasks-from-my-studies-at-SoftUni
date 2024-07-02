function arraySortAndPrintLikeNumberedList(array){
    let result = array.slice().sort((a, b) => a.localeCompare(b));

    let number = 1;

    result.forEach(element => {
        console.log(`${number}.${element}`);
        number++;
    });
}
arraySortAndPrintLikeNumberedList(["John", "Bob", "Christina", "Ema"]);
