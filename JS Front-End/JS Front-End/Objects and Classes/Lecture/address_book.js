function createAddressBook(addressesOfPersons){
    let addressBook = new Map();

    addressesOfPersons.forEach(element => {
        let name = element.split(':')[0];
        let address = element.split(':')[1];
        addressBook.set(name, address);
    });

    addressBook = new Map([...addressBook.entries()].sort());

    addressBook.forEach((value, key) => console.log(`${key} -> ${value}`));
}
createAddressBook(['Tim:Doe Crossing', 'Bill:Nelson Place', 'Peter:Carlyle Ave', 'Bill:Ornery Rd'] );