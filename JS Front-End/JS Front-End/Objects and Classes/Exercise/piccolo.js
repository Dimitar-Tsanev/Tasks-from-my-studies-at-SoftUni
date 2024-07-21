function getParkingState(inAndOutCars){
    let parking = {};
    let carIsInside = 'IN';
    let isParkingEmpty = true;

    for(let i = 0; i < inAndOutCars.length; i++){
        const [operation, carNumber] = inAndOutCars[i].split(', ');

        parking[carNumber] = operation;
    }

    Object.keys(parking).sort((c1, c2) => c1.localeCompare(c2)).forEach(carNumber => {
        if(parking[carNumber] === carIsInside){
            console.log(carNumber);
            isParkingEmpty = false;
        }
    });

    if(isParkingEmpty){
        console.log('Parking Lot is Empty')
    }
}
getParkingState(['IN, CA2844AA',
    'IN, CA1234TA',
    'OUT, CA2844AA',
    'IN, CA9999TT',
    'IN, CA2866HI',
    'OUT, CA1234TA',
    'IN, CA2844AA',
    'OUT, CA2866HI',
    'IN, CA9876HH',
    'IN, CA2822UU']);

getParkingState(['IN, CA2844AA',
    'IN, CA1234TA',
    'OUT, CA2844AA',
    'OUT, CA1234TA']);
