function printTownInfo(townsInfo){
    let towns = [];

    townsInfo.forEach(element => {
        const [town, latitude, longitude] = element.split(" | ");
        towns.push({town, 
            latitude: Number(latitude).toFixed(2),
            longitude: Number(longitude).toFixed(2) });
    });

    towns.forEach(element => console.log(element));
}
printTownInfo(['Sofia | 42.696552 | 23.32601', 'Beijing | 39.913818 | 116.363625']);
printTownInfo(['Plovdiv | 136.45 | 812.575']);