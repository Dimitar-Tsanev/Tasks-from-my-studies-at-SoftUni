function convertJsonToObject(objectJson){
    let object = JSON.parse(objectJson);
    let entities = Object.entries(object);

    for (const [key, value] of entities) {
        console.log(`${key}: ${value}`);
    }

}
convertJsonToObject('{"name": "George", "age": 40, "town": "Sofia"}');