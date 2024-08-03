function deleteByEmail() {
    //TODO:...
    const tableRows = document.querySelectorAll('#customers tbody tr');
    const input = document.querySelector('input[type="text"][name="email"]');
    const output = document.getElementById('result');

    const deleted = 'Deleted.';
    const notFound = 'Not found.';

    let foundInput = [];

    Array.from(tableRows).forEach(row => {
        const found = Array.from(row.children).filter(cell => cell.textContent.includes(input.value));

        if (found.length !== 0){
            foundInput.push(row);
        }
    });

    if (foundInput.length !== 0){
        foundInput.forEach(row => row.parentElement.removeChild(row));

        output.textContent = deleted;

    }else{
        output.textContent = notFound;
    }

    input.value = '';
}
