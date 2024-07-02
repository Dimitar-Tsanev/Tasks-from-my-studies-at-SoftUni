function splitPascalCase(textOriginal){
    let text = textOriginal.slice();
    const pattern = /[A-Z]/g;
    let result = [];
    let matches = text.match(pattern);
    
    while (matches.length > 0 ){
        let letter = matches.shift();

        if (matches.length > 0){
            let index = text.indexOf(matches[0]);

            if(index === 0){
                let testText = text.substring(1);
                index = testText.indexOf(matches[0]) + 1;
            }

            result.push(text.substring(0, index) );
            text = text.substring(index);
            
        }else{
            result.push(text);
        }
    }
    
    console.log(result.join(', '));
}
splitPascalCase('SplitMeIfYouCanHaHaYouCantOrYouCan');
splitPascalCase('HoldTheDoor');
splitPascalCase('ThisIsSoAnnoyingToDo');