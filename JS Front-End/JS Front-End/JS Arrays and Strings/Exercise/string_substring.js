function findWord(testForWord, textToTest){
    let word = testForWord.toLowerCase();
    let text = textToTest.toLowerCase().split(' ');

    if (text.includes(word)){
        console.log(testForWord);

    }else{
        console.log(`${testForWord} not found!`)
    }
}
findWord('javascript', 'JavaScript is the best programming language');
findWord('python', 'JavaScript is the best programming language' );