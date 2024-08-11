function solve() {
    const baseURl = 'http://localhost:3030/jsonstore/bus/schedule/';

    const departButton = document.getElementById('depart'); 
    const arriveButton = document.getElementById('arrive');

    const displayElement = document.querySelector('#info .info')

    let stopId = 'depot';
    let stopName = '';

    function depart() {
        // TODO: 
        fetch(baseURl + stopId)
            .then(response => response.json())
            .then(result => {
                console.log(result)
                const nextStopId = result['next'];
                stopId = nextStopId;

                const currentStopName = result['name'];
                stopName = currentStopName;
                
                arriveButton.removeAttribute('disabled');
                departButton.setAttribute('disabled','disabled');

                displayElement.textContent = `Next stop ${stopName}`;

            })
            .catch(error => {
                displayError();
            });
            
    }

    async function arrive() {
        // TODO:
        displayElement.textContent = `Arriving at ${stopName}`;

        departButton.removeAttribute('disabled');
        arriveButton.setAttribute('disabled','disabled');  
    }

    function displayError(){
        displayElement.textContent = 'Error';
        departButton.setAttribute('disabled','disabled');
        arriveButton.setAttribute('disabled','disabled');
    }

    return {
        depart,
        arrive
    };
}

let result = solve();