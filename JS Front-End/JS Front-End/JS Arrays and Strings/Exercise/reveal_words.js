function revealWords(words,CensoredText){
    let wordsArray = words.split(/, /);
    let text = CensoredText.slice();

    while (wordsArray.length !== 0){
        let word = wordsArray.shift();
        let pattern = '*'.repeat(word.length);

        if (text.includes(pattern)){
            text = text.replace(pattern, word);
        }
    }
    console.log(text);
}
revealWords('great, learning', 'softuni is ***** place for ******** new programming languages' );