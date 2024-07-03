function getAsciiCharactersBetween (char1, char2){
    let char1Position = char1.charCodeAt();
    let char2position = char2.charCodeAt();
    let result = [];

    if (char1Position > char2position){
        let temp = char1Position;
        char1Position = char2position;
        char2position = temp;
    }

    for (let i = char1Position + 1; i < char2position; i++){
        result.push(String.fromCharCode(i));
    }

    console.log(result.join(' '));
}
getAsciiCharactersBetween('a','d');
getAsciiCharactersBetween('#', ':');
getAsciiCharactersBetween('C', '#');