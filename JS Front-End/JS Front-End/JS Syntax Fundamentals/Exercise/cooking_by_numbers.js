function cookingByNumbers(num, ...args){
    let number = num;

    args.forEach(element => {
        switch(element) {
            case'chop':
                    console.log(number /= 2 );
                break;
            case'dice':
                    console.log(number = Math.sqrt(number) );
                break;
            case'spice':
                    console.log(number += 1 );
                break;
            case'bake':
                    console.log(number *= 3 );
                break;
            case'fillet':
                    console.log(number *= 0.8); 
            break;
        }
    });
}
cookingByNumbers('32', 'chop', 'chop', 'chop', 'chop', 'chop');
cookingByNumbers('9', 'dice', 'spice', 'chop', 'bake', 'fillet');