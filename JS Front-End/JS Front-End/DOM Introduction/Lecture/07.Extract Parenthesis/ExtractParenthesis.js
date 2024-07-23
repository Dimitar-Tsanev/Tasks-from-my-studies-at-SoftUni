function extract(content) {
    let text = document.getElementById(content).textContent;

    let pattern = /\([^)]*\)/g;

    let matches = text.match(pattern).join('; ').replaceAll(/\(|\)/g,'');

   return matches
}
