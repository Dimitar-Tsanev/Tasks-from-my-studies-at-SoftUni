function countWordsOddOccurrences(input){
    const words = input.toLowerCase().split(/\s+/);

    let wordsOccurrences = words.reduce((accumulator, current) => {
        if(!accumulator.hasOwnProperty(current)){
            accumulator[current] = 0;
        }
        accumulator[current]++;
        return accumulator;
    },{});

    console.log(
        Object.keys(wordsOccurrences)
        .filter( word => wordsOccurrences[word] %2 !==0)
        .join(' '))
}
countWordsOddOccurrences('Java C# Php PHP Java PhP 3 C# 3 1 5 C#');
countWordsOddOccurrences('Cake IS SWEET is Soft CAKE sweet Food');
