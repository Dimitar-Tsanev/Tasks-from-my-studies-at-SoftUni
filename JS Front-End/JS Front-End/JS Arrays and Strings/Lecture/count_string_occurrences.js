function countStringOccurrences(text, word){
    const pattern = new RegExp (`\\b${word}\\b`, 'g');

    if (pattern.test(text)){
        const matches = text.match(pattern);
        console.log (matches.length)

    }else{
        console.log(0)
    }
}
countStringOccurrences('This is a word and it also is a sentence', 'is' );
countStringOccurrences('softuni is great place for learning new programming languages', 'softuni' );