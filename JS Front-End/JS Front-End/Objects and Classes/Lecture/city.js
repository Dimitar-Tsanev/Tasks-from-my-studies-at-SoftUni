function printInfo(city){
    let entity = Object.entries(city);

    for (const [key, value] of entity) {
        console.log (`${key} -> ${value}`)
    }
}
printInfo({
    name: "Sofia",
    area: 492,
    population: 1238438,
    country: "Bulgaria",
    postCode: "1000"
});