function solve(input){
    const numberOfBarista = input.shift();

    let baristas = {};

    for(let i = 0; i < numberOfBarista; i++){
        const [name, shift, drinksString] = input.shift().split(' ');

        let drinks = drinksString.split(',');

        baristas[name] = {shift, drinks};
    }
    
    let commandData = input.shift();

    while(commandData !== 'Closed'){
        const [command, name, ...data] = commandData.split(' / ');

        switch(command){
            case 'Prepare':
                const [searchedShift, coffeeType] = data;

                if(baristas[name].shift === searchedShift && baristas[name].drinks.includes(coffeeType)){
                    console.log(`${name} has prepared a ${coffeeType} for you!`);

                }else{
                    console.log(`${name} is not available to prepare a ${coffeeType}.`)
                }
                break;

            case 'Change Shift':
                baristas[name].shift = data[0];
                console.log(`${name} has updated his shift to: ${data}`);

                break;

            case 'Learn':
                if(baristas[name].drinks.includes(data[0])){
                    console.log(`${name} knows how to make ${data}.`);

                }else{
                    baristas[name].drinks.push(data[0]);
                    console.log(`${name} has learned a new coffee type: ${data}.`);
                }
                break;
        }

        commandData = input.shift();
    }

    Object.keys(baristas).forEach(name => {
        console.log(`Barista: ${name}, Shift: ${baristas[name].shift}, Drinks: ${baristas[name].drinks.join(', ')}`);
    });
}

solve(
    ['4',
        'Alice day Espresso,Cappuccino',
        'Bob night Latte,Mocha',
        'Carol day Americano,Mocha',
        'David night Espresso',
        'Prepare / Alice / day / Espresso',
        'Change Shift / Bob / day',
        'Learn / Carol / Latte',
        'Prepare / Bob / night / Latte',
        'Learn / David / Cappuccino',
        'Prepare / Carol / day / Cappuccino',
        'Change Shift / Alice / night',
         'Learn / Bob / Mocha',
        'Prepare / David / night / Espresso',
        'Closed']
)
