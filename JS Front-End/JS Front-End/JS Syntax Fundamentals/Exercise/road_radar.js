function roadRadar(speed, area){
    const restrictions = new Map;
    restrictions.set ('motorway',130).set('interstate',90).set('city', 50).set('residential',20);

    const restriction = restrictions.get(area)
    const difference = speed - restriction;
    let overSpeedType = '';
    
    if (speed <= restriction){
        overSpeedType = 'none';

    }else{
        if (difference <= 20){
            overSpeedType = 'speeding';

        }else if (difference <= 40 ){
            overSpeedType = 'excessive speeding';

        }else{
            overSpeedType = 'reckless driving';
        }
    }

    if (overSpeedType === 'none'){
        console.log (`Driving ${speed} km/h in a ${restriction} zone`);

    }else{
        console.log (`The speed is ${difference} km/h faster than the allowed speed of ${restriction} - ${overSpeedType}`);
    }
    
}
roadRadar(40, 'city');
roadRadar(21, 'residential');
roadRadar(120, 'interstate');
roadRadar(200, 'motorway');