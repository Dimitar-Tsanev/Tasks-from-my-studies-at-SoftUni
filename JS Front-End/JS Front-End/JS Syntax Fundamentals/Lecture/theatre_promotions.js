function theatrePromotions(day, age){
    const childTicket = new Map;
    const adultTicket = new Map;
    const elderTicket = new Map;

    childTicket.set('Weekday',12);
    childTicket.set('Weekend',15);
    childTicket.set('Holiday',5);

    adultTicket.set('Weekday',18);
    adultTicket.set('Weekend',20);
    adultTicket.set('Holiday',12);

    elderTicket.set('Weekday',12);
    elderTicket.set('Weekend',15);
    elderTicket.set('Holiday',10);

    if (age >=0 && age <=122){
        if (age <=18){
            console.log (childTicket.get(day) + '$');

        }
        else if(age <= 64){
            console.log (adultTicket.get(day) + '$');
    
        }else{
            console.log (elderTicket.get(day) + '$');
    
        }

    }else{
        console.log ('Error!' );
    }
}
theatrePromotions('Weekday', 42);
theatrePromotions('Holiday', -12);
theatrePromotions('Holiday', 15);