function censoredWord (string, word){
    let result = string;

    while (result.includes(word)){
        result = result.replace(word, '*'.repeat(word.length));
    }
    console.log(result)
}
censoredWord('A small sentence with some words', 'small');
censoredWord('Find the hidden word', 'hidden');