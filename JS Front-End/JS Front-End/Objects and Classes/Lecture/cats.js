function createCats(catsData){
    class Cat {
        constructor (name, age){
            this.name = name;
            this.age = age;
        }

        speak(){
            console.log(`${this.name}, age ${this.age} says Meow`);
        }
    }
    let cats = [];

    for (const cat of catsData) {
        const catData = cat.split(/\s+/);
      
        const currentCat = new Cat(catData[0], catData[1])

        cats.push(currentCat);
    }

    for (const cat of cats) {
        cat.speak();
    }
}
createCats(['Mellow 2', 'Tom 5']);
createCats(['Candy 1', 'Poppy 3', 'Nyx 2']);
