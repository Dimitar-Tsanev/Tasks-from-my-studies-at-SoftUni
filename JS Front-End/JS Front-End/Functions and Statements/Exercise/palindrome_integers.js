function palindromeIntegers(array){
    array.forEach(element => {
        console.log(isNumPalindrome(element));
    });

    function isNumPalindrome (num){
        let numToString = num.toString();
    
        for (let i = 0; i < numToString.length / 2; i++ ){
            if (numToString[i] !== numToString[numToString.length - i - 1]){
                return false;
            }
        }
        return true;
    }
}
palindromeIntegers([123,323,421,121]);
palindromeIntegers([32,2,232,1010]);