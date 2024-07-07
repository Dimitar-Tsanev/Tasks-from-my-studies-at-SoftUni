function convertObjectToJson (firstName, lastName, hairColor){
    let person = {name: firstName, lastName, hairColor};

    let personToJson = JSON.stringify(person);

    console.log(personToJson);
}
convertObjectToJson('George', 'Jones', 'Brown');