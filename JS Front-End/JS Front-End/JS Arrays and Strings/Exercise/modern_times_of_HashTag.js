function findTagged(text){
    let pattern = /#[A-za-z]+/g;
    let words = text.match(pattern);
    for (const word of words) {
        console.log(word.substring(1))
    }
}
findTagged('Nowadays everyone uses # to tag a #special word in #socialMedia');
findTagged('The symbol # is known #variously in English-speaking #regions as the #number sign');