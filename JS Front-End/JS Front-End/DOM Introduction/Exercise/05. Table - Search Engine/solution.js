function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      //   TODO:
      const searchedText = document.getElementById('searchField');

      const tableRows = Array.from(document.querySelectorAll('tbody tr')).forEach(row =>{
         
         if(row.classList.contains('select')){
            row.classList.remove('select');
         }

         const rowData = Array.from(row.children)
                        .filter(cell => cell.textContent.toLowerCase().includes(searchedText.value.toLowerCase()));

         if (rowData.length !== 0 ){
            row.classList.add('select')
         }

      });
      searchedText.value = '';
   }
}