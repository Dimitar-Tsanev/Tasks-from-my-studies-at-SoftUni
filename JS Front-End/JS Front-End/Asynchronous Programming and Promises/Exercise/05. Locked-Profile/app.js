function lockedProfile() {
    //    TODO...
    const baseUrl = 'http://localhost:3030/jsonstore/advanced/profiles';
    
    const profileElement = document.querySelector('div.profile');
    const containerElement = document.getElementById('main');
    
    getUsers()
    
    function getUsers(){}
    fetch(baseUrl)
    .then(response => response.json())
    .then(result => {
        containerElement.innerHTML ='';

        for (const key in result) {
            const cloneUserProfileElement = profileElement.cloneNode(true);
            
            const usernameElement = cloneUserProfileElement.querySelector('input[type="text"][name="user1Username"]');
            const emailElement = cloneUserProfileElement.querySelector('input[type="email"][name="user1Email"]');
            const userAgeElement = cloneUserProfileElement.querySelector('input[type="email"][name="user1Age"]');
            const lockUnlockButtons = cloneUserProfileElement.querySelectorAll('input[type="radio"]');
            const showHideButton = cloneUserProfileElement.querySelector('button');

            lockUnlockButtons.forEach(radioButton => {
                if(radioButton.value === 'lock'){
                    radioButton.checked = true;
                    
                }else{
                    radioButton.checked = false;
                }
            });
            
            const {_id, age, email, username} = result[key];
            usernameElement.value = username;
            emailElement.value = email;
            userAgeElement.value = age.toString();
            lockUnlockButtons.forEach(button => button.setAttribute('name',_id));
            

            showHideButton.parentElement.querySelector('div').style.display = 'none'
                            showHideButton.textContent = 'Show more';
            
            lockUnlockButtons.forEach(radioButton => radioButton.addEventListener('click', (event) =>{
                const currentProfileRadioButton = event.target;
                currentProfileRadioButton.checked = true;
                
                Array.from(currentProfileRadioButton.parentElement.querySelectorAll('input[type="radio'))
                .filter(b => b !== currentProfileRadioButton)
                .forEach(b => b.checked = false);
            }));
            
            showHideButton.addEventListener('click', () => {
                lockUnlockButtons.forEach(radioButton => {
                    if (radioButton.value === 'unlock' && radioButton.checked){
                        if (showHideButton.textContent === 'Show more'){
                            showHideButton.parentElement.querySelector('div').style.display = 'block'
                            showHideButton.textContent = 'Hide it';
                            
                            
                        }else{
                            showHideButton.parentElement.querySelector('div').style.display = 'none'
                            showHideButton.textContent = 'Show more';
                        }
                    }
                });
            });
            
            containerElement.appendChild(cloneUserProfileElement);
            
            console.log(_id, age, email, username)
        }
    });
    
}
