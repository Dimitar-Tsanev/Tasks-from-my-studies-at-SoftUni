function everyNthElement(array, number){
    let result = [];
    for (let i = 0; i < array.length; i += number){
        result.push(array[i]);
    }
    return result;
}
// Everything from this line bellow is for test it's not necessary
function print (arr) {
    for (const el of arr) {
        console.log(el);
    }
}
print(everyNthElement(['5', '20', '31', '4', '20'], 2));
print(everyNthElement(['dsa', 'asd', 'test', 'tset'], 2));
print(everyNthElement(['1', '2', '3', '4', '5'], 6 ));