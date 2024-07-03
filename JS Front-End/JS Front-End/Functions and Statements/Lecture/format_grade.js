function printGradeWithDescription(grade){

    if (grade < 3 ){
        console.log('Fail (2)');
        
    }else{
        let description = grade >= 5.50 ? 'Excellent' : 
                        grade >= 4.50 ? 'Very good' :
                        grade >= 3.50 ? 'Good' : 
                        'Poor' ;
        
        console.log(`${description} (${grade.toFixed(2)})`);
    }
    
}
printGradeWithDescription(3.33);
printGradeWithDescription(4.50);
printGradeWithDescription(2.99);