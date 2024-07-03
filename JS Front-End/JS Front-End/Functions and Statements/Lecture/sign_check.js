function signOfTheREsult (...args){
    let negativeCount = 0;

    for (const num of args) {
        if (num < 0){
            negativeCount++;
        }
    }
    console.log(negativeCount % 2 === 0? 'Positive' : 'Negative')
}
signOfTheREsult( 5, 12, -15);
signOfTheREsult(-6, -12, 14 );
signOfTheREsult(-1, -2, -3 );
signOfTheREsult(-5, 1, 1);