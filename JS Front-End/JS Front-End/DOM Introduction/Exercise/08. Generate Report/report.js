function generateReport() {
    //TODO
    const checkableColumns = Array.from(document.querySelectorAll('thead th input'));
    const outputElement = document.getElementById('output');

    const rows = Array.from(document.querySelectorAll('tbody tr'));
    const tableCellsInRows = rows.map(row => {
        return Array.from(row.children);
    });
    
    const checkedColumnsIndexes = checkableColumns.filter(checkbox => checkbox.checked)
                                .map( checkbox => checkableColumns.indexOf(checkbox));

    let result = [];

    tableCellsInRows.forEach(row => {
        let object = {};
        checkedColumnsIndexes.forEach(index => {
          object[checkableColumns[index].name] = row[index].textContent;
        });
        result.push(object);
    });

    outputElement.value = JSON.stringify(result);
}