function search() {
   // TODO
   Array.from(document.querySelectorAll('#towns li')).forEach(element => {
      element.style.fontWeight = "normal";
      element.style.textDecoration = "none";
   });

   const searchedText = document.getElementById('searchText').value;
   const matches = Array.from(document.querySelectorAll('#towns li'))
                  .filter(e => e.textContent.toLocaleLowerCase().includes(searchedText.toLowerCase()));

   matches.forEach(match => {
      match.style.fontWeight = "bold";
      match.style.textDecoration = "underline";
   });
   document.getElementById('searchText').value = '';

   document.getElementById('result').textContent = `${matches.length} matches found`;
}
