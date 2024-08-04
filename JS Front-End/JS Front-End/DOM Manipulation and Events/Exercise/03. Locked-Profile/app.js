function lockedProfile() {
    //TODO...
    const lockUnlockButtons = document.querySelectorAll('.profile input[type="radio"]');
    
    lockUnlockButtons.forEach(radioButton => {
        if(radioButton.value === 'lock'){
            radioButton.checked = true;
        }else{
            radioButton.checked = false;
        }
    });
    
    lockUnlockButtons.forEach(radioButton => radioButton.addEventListener('click', (event) =>{
        const currentProfileRadioButton = event.target;
        currentProfileRadioButton.checked = true;
        
        Array.from(currentProfileRadioButton.parentElement.querySelectorAll('input[type="radio'))
        .filter(b => b !== currentProfileRadioButton)
        .forEach(b => b.checked = false);
    }));
    
    const showHideButtons = document.querySelectorAll('.profile button');
    
    showHideButtons.forEach(button => button.addEventListener('click', () =>{
        const profileRadioButtons = button.parentElement.querySelectorAll('input[type="radio"]');
        
        profileRadioButtons.forEach(radioButton => {
            
            if (radioButton.value === 'unlock' && radioButton.checked){
                if (button.textContent === 'Show more'){
                    button.parentElement.querySelector('div').style.display = 'block'
                    button.textContent = 'Hide it';
                    
                    
                }else{
                    button.parentElement.querySelector('div').style.display = 'none'
                    button.textContent = 'Show more';
                }
            }
        });
    }));
}
