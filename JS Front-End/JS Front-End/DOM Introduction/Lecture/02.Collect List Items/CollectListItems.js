function extractText() {
    // TODO
    let targets = document.getElementById('items').children;
    let resultToInject = document.getElementById('result')

    let textsToReturn = Array.from(targets).map(t => t.textContent.trim()).join('\n');
    resultToInject.value = textsToReturn;
}
