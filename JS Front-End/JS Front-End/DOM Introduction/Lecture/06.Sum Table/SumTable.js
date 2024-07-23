function sumTable() {
    document.getElementById('sum').textContent = 
        Array.from(document.querySelectorAll('td:nth-of-type(2n):not(#sum)'))
            .reduce((sum, currentElement) => sum += Number(currentElement.textContent),0);
}