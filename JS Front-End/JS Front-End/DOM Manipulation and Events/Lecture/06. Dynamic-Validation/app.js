function validate() {
    //TODO:...
    const emailInput = document.getElementById('email');

    emailInput.addEventListener('change', () => {
        const pattern = /[a-z]+@[a-z]+.[a-z]+/g;

        !pattern.test(emailInput.value) ? emailInput.classList.add('error') : emailInput.classList.remove('error');
      
    });
}
