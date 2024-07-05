function checkPassword(password){
    let isValid = true;

    isLengthValid(password);
    isOnlyLettersAndDigits(password);
    doesItContainTwoDigits(password);
    
    if(isValid){
        console.log ('Password is valid');
    }

    function isLengthValid (password){
        
        if (password.length < 6 || password.length > 10){
            isValid = false;
            console.log('Password must be between 6 and 10 characters');
        }
    }

    function isOnlyLettersAndDigits(password){
        const pattern = /^[0-9A-Za-z]+$/g;

        if(!pattern.test(password)){
            isValid = false;
            console.log('Password must consist only of letters and digits');
        }
    }

    function doesItContainTwoDigits(password){
        const pattern = /\d[A-Za-z]*\d/g;

        if(!pattern.test(password)){
            isValid = false;
            console.log('Password must have at least 2 digits');
        }
    }
}
checkPassword('logIn');
checkPassword('MyPass123');
checkPassword('Pa$s$s');