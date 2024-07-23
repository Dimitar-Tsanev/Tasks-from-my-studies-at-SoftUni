function colorize() {
    // TODO
    Array.from(document.querySelectorAll('tr:nth-of-type(2n)'))
        .forEach(e => e.style = 'background-color: teal');
}