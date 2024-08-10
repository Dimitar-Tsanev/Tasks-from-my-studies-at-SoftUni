function getInfo() {
    // TODO:
    const baseUrl = 'http://localhost:3030/jsonstore/bus/businfo/';
    
    const input = document.getElementById('stopId');
    const inputStopId = input.value;
    input.value = '';
    
    if (!inputStopId){
        displayError();
        return;
    }

    const bussesOutputElement = document.getElementById('buses');
    bussesOutputElement.innerHTML = '';
    
    const stopNameElement = document.getElementById('stopName');
    
    fetch(`${baseUrl}\\${inputStopId}`)
    .then((res) => res.json())
    .then( response => {
        const [busses, bussStopName] = Object.values(response);
        stopNameElement.textContent = bussStopName;
        
        for (const bussId in busses) {
            const liElement = document.createElement('li');
            
            liElement.textContent = `Bus ${bussId} arrives in ${busses[bussId]} minutes`;
            bussesOutputElement.appendChild(liElement);
        }
    }).catch(_ => {
        displayError();
    });

    function displayError(){
        stopNameElement.textContent = 'Error'
    }
}