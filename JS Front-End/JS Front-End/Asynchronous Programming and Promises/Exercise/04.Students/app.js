function attachEvents() {
  // TODO:
  const url = 'http://localhost:3030/jsonstore/collections/students';
  
  loadTableBodyHandler();
  
  const tableBody = document.querySelector('#results tbody');
  
  const submitButton = document.getElementById('submit');
  
  submitButton.addEventListener('click', generateStudentHandler);
  
  function generateStudentHandler(){
    const firstNameInputElement = document.querySelector('input[name="firstName"]');
    const lastNameInputElement = document.querySelector('input[name="lastName"]');
    const facultyNumberInputElement = document.querySelector('input[name="facultyNumber"]');
    const gradeInputElement = document.querySelector('input[name="grade"]');

    const firstName = firstNameInputElement.value;
    const lastName = lastNameInputElement.value;
    const facultyNumber = facultyNumberInputElement.value;
    const grade = gradeInputElement.value;

    
    if (!firstName || !lastName || !facultyNumber || !grade) {
      return;
    }
    fetch(url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        firstName,
        lastName,
        facultyNumber,
        grade
      })
    })
    
    firstNameInputElement.value = '';
    lastNameInputElement.value = '';
    facultyNumberInputElement.value = '';
    gradeInputElement.value = '';
  }
  
  function loadTableBodyHandler(){
    fetch(url)
    .then(response => response.json())
    .then(result => {
      for (const key in result) {
        const {firstName, lastName, facultyNumber, grade, _id} = result[key];
        const trElement = document.createElement('tr');
        
        const tdForName = document.createElement('td');
        tdForName.textContent = firstName;
        trElement.appendChild(tdForName)
        
        const tdForLastName = document.createElement('td');
        tdForLastName.textContent = lastName;
        trElement.appendChild(tdForLastName)
        
        const tdForFacultyNumber = document.createElement('td');
        tdForFacultyNumber.textContent = facultyNumber;
        trElement.appendChild(tdForFacultyNumber)
        
        const tdForGrade = document.createElement('td');
        tdForGrade.textContent = grade;
        trElement.appendChild(tdForGrade)
        
        tableBody.appendChild(trElement);
      }
    })
  }
  
}

attachEvents();