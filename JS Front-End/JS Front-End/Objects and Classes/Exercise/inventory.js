function readHeroInformation(data){
    let heroes = [];

    data.map(heroInformation =>{
        let[heroName, heroLevel, items] = heroInformation.split(" / ");
        return {heroName, heroLevel, items};

    }).forEach(hero => heroes.push(hero));

    heroes.slice().sort((h1, h2) => h1.heroLevel - h2.heroLevel).forEach(hero => {
        console.log(`Hero: ${hero.heroName}\nlevel => ${hero.heroLevel}\nitems => ${hero.items}`);
    });
}
readHeroInformation([
    'Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara'
    ]);
readHeroInformation([
    'Batman / 2 / Banana, Gun',
    'Superman / 18 / Sword',
    'Poppy / 28 / Sentinel, Antara'
    ]);
