function groupPrice(groupCount, groupType, dayOfWeek){
    const overnightStay = new Map;
    
    overnightStay.set ( 'Friday',{student: 8.45, business: 10.90, regular: 15 } );
    overnightStay.set ( 'Saturday',{student: 9.80, business: 15.60, regular: 20} );
    overnightStay.set ( 'Sunday',{student: 10.46, business: 16, regular: 22.50} );
    
    let overnightStayDay= overnightStay.get(dayOfWeek);
    
    let pricePerPerson = 0;
    let discount = 0;
    
    switch(groupType){
        case 'Students':
            pricePerPerson = overnightStayDay.student;
            price = groupCount * pricePerPerson;

            if (groupCount >= 30){
                discount = price * 0.15;
            }

        break;

        case 'Business':
            pricePerPerson = overnightStayDay.business;
            price = groupCount * pricePerPerson;

            if (groupCount >= 100){
                discount = pricePerPerson * 10;
            }

        break;

        case'Regular':
            pricePerPerson = overnightStayDay.regular;
            price = groupCount * pricePerPerson;

            if (groupCount >= 10 && groupCount <= 20){
                discount = price * 0.05;
            }

        break;
    }
    console.log(`Total price: ${(price - discount).toFixed(2)}`)
}
groupPrice( 40, "Regular", "Saturday" );
groupPrice( 30, "Students", "Sunday" )