function countWords(input=[]){
    const [wordsToCount, ...text] = input;
    const words = new Map();

    wordsToCount.split(/\s+/).forEach(word => words.set(word,0));

    text.forEach(word => {
        if(words.has(word)){
            let newValue = words.get(word) + 1;
            words.set(word, newValue);
        }
    });
    
    let wordsSorted = new Map ([...words.entries()].sort(([k1, v1], [k2, v2]) => v2 - v1 ));

    wordsSorted.forEach((value, key) => console.log(`${key} - ${value}`));
}

countWords([
    'this sentence', 
    'In', 'this', 'sentence', 'you', 'have', 'to', 'count', 'the',
    'occurrences', 'of', 'the', 'words', 'this', 'and', 'sentence',
    'because', 'this', 'is', 'your', 'task'
    ]);
    
    countWords([
    'is the', 
    'first', 'sentence', 'Here', 'is', 'another', 'the', 'And',
     'finally', 'the', 'the', 'sentence'
    ]);
