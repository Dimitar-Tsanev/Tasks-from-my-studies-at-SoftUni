function solve(input){
    class Character {
        constructor (name, hp, bullets ){
            this.name = name;
            this.hp = hp;
            this.bullets = bullets;
            this.isAlive = true;
        }
        action(action, ...parameters){
            if (!this.isAlive){
                return;
            }
            switch(action){
                case 'FireShot':
                    if (this.bullets === 0){
                        console.log(`${this.name} doesn't have enough bullets to shoot at ${parameters[0]}!`);
        
                    }else{
                        this.bullets--;
                        console.log(`${this.name} has successfully hit ${parameters[0]} and now has ${this.bullets} bullets!`);
                    }
                break;

                case 'TakeHit':
                    this.hp -= Number(parameters[0]);

                    if (this.hp <= 0){
                        console.log(`${this.name} was gunned down by ${parameters[1]}!`);
                        this.isAlive = false;
        
                    }else{
                        console.log(`${this.name} took a hit for ${parameters[0]} HP from ${parameters[1]} and now has ${this.hp} HP!`);
                    }
                break;

                case 'Reload':
                    const maxBullets = 6;

                    if(this.bullets === maxBullets){
                        console.log(`${this.name}'s pistol is fully loaded!`);

                    }else{
                        console.log(`${this.name} reloaded ${maxBullets - this.bullets} bullets!`);
                        this.bullets = maxBullets;
                    }
                break;

                case 'PatchUp':
                    const maxHp = 100;

                    if(this.hp === maxHp){
                        console.log(`${this.name} is in full health!"`);

                    }else{
                        const healed = Math.min(maxHp - this.hp, Number(parameters[0]));
                        this.hp += healed; 

                        console.log(`${this.name} patched up and recovered ${healed} HP!`)
                    }
                break;
            }
        }
    }
    const finalCommand = 'Ride Off Into Sunset';

    let crew = {};

    const [charactersNumber, ...data] = input;

    for(let i = 0; i < charactersNumber; i++){
        const [name, hp, bullets] = data.shift().split(' ');

        crew[`${name}`] = new Character(name, Number(hp), Number(bullets));
    }

    let command = data.shift();

    while(command !== finalCommand ){
        const[action, name, ...commandData] = command.split(' - ');
        crew[name].action(action, ...commandData);
        
        command = data.shift();
    }
    
    for (const char in crew) {
        if (crew[char].isAlive){
            console.log(char);
            console.log(` HP: ${crew[char].hp}`);
            console.log(` Bullets: ${crew[char].bullets}`);
        }
    }
}
solve(
    ["2",
        "Jesse 0 6",
        "Walt 100 5",
         "TakeHit - Jesse - 0 - Bandit",
         "PatchUp - Walt - 100" ,
         "Reload - Jesse",
         "Ride Off Into Sunset"]     
);