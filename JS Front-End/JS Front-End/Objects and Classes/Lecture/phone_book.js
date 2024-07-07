function createPhoneBook (phoneNumbers){
    let phoneBook = new Map();

    for (const phoneNumber of phoneNumbers) {
        let phoneEntity = phoneNumber.split(/\s+/);
        phoneBook.set(phoneEntity[0], phoneEntity[1]);
    }

    for (const entity of phoneBook) {
        console.log(`${entity[0]} -> ${entity[1]}`);
    }
}
createPhoneBook(['Tim 0834212554', 'Peter 0877547887', 'Bill 0896543112', 'Tim 0876566344'] );