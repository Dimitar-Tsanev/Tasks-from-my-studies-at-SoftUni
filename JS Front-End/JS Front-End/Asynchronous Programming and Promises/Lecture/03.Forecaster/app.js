function attachEvents() {
    // TODO:
    const inputElement = document.getElementById('location');
    const outputContainerElement = document.getElementById('forecast');
    
    const submitButton = document.getElementById('submit');
    
    let searchedLocationCode = '';

    const degreeSymbol = String.fromCharCode(176);

    
    submitButton.addEventListener('click',getLocation);
    
    function getWeather(){
        const todayWeatherUrl = `http://localhost:3030/jsonstore/forecaster/today/${searchedLocationCode}`;
        const upcomingWeatherUrl = `http://localhost:3030/jsonstore/forecaster/upcoming/${searchedLocationCode}`;

        forecastToday(todayWeatherUrl);
        forecastUpcoming(upcomingWeatherUrl);
        
    }
    function forecastToday(url){
        const output = outputContainerElement.querySelector('#current');

        fetch(url)
            .then(resp => resp.json())
            .then(result =>{
                const {condition, high, low} = result['forecast'];
                const name = result['name'];

                const forecastsElement = document.createElement('div');
                forecastsElement.classList.add('forecasts');

                const conditionSymbolElement = document.createElement('span');
                conditionSymbolElement.classList.add('condition');
                conditionSymbolElement.classList.add('symbol');
                conditionSymbolElement.textContent = getSymbol(condition);

                forecastsElement.appendChild(conditionSymbolElement);

                const conditionElement = document.createElement('span');
                conditionElement.classList.add('condition');

                const spanName = document.createElement('span');
                spanName.classList.add('forecast-data');
                spanName.textContent = name;

                conditionElement.appendChild(spanName);

                const spanTemps = document.createElement('span');
                spanTemps.classList.add('forecast-data');
                spanTemps.textContent = `${low}${degreeSymbol}/${high}${degreeSymbol}`;

                conditionElement.appendChild(spanTemps);

                const spanCondition = document.createElement('span');
                spanCondition.classList.add('forecast-data');
                spanCondition.textContent = condition;
                
                conditionElement.appendChild(spanCondition);

                forecastsElement.appendChild(conditionElement);

                output.appendChild(forecastsElement);
                outputContainerElement.style.display = 'block';
            });
    }
    
    function forecastUpcoming(url){
        const output = outputContainerElement.querySelector('#upcoming');

           fetch(url)
            .then(resp => resp.json())
            .then(result =>{
                const forecastsElement = document.createElement('div');
                forecastsElement.classList.add('forecast-info');

                result['forecast'].forEach(day => {
                    const {condition, high, low} = day;
                    const spanUpcoming = document.createElement('span');
                    spanUpcoming.classList.add('upcoming');

                    const symbolElement = document.createElement('span');
                    symbolElement.classList.add('symbol');
                    symbolElement.textContent = getSymbol(condition);

                    spanUpcoming.appendChild(symbolElement);

                    const spanTemps = document.createElement('span');
                    spanTemps.classList.add('forecast-data');
                    spanTemps.textContent = `${low}${degreeSymbol}/${high}${degreeSymbol}`;

                    spanUpcoming.appendChild(spanTemps);

                    const spanCondition = document.createElement('span');
                    spanCondition.classList.add('forecast-data');
                    spanCondition.textContent = condition;

                    spanUpcoming.appendChild(spanCondition);

                    forecastsElement.appendChild(spanUpcoming);
                });

                output.appendChild(forecastsElement)
            });
    }
    
    async function getLocation(){
        const url = 'http://localhost:3030/jsonstore/forecaster/locations';
        
        const result = await fetch(url).then(res => res.json());
        try{
            let find = false;
            result.forEach(location => {
                if (location['name'] === inputElement.value){
                    find = true;
                    searchedLocationCode = location['code'];
                }
            });
            if (!find){
                displayError();
                
            }else{
                getWeather();
            }
        }catch(error){
            displayError();
        }
        
    }
    function getSymbol(condition){
        switch(condition){
            case 'Sunny':
                return '\u2600'; 
            case 'Partly sunny':
                return '\u26C5'; 
            case 'Overcast':
                return '\u2601'; 
            case 'Rain':
    			return '\u2614'; 
        }
    }
    function displayError(){
        outputContainerElement.style.display ='block';
        
        outputContainerElement.textContent = 'Error';
    }
}

attachEvents();