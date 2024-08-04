function attachEventsListeners() {
    //TODO:...
    Array.from(document.querySelectorAll('input[type="text"]')).forEach(input => input.value = '');

    const daysElement = document.getElementById('days');
    const hoursElement = document.getElementById('hours');
    const minutesElement = document.getElementById('minutes');
    const secondsElement = document.getElementById('seconds');

    const convertButtons = document.querySelectorAll('input[type="button"][value="Convert"]');

    convertButtons.forEach(button => button.addEventListener('click',(event) => {
        const currentInput = event.target.parentElement.querySelector('input[type="text"]');

        switch(currentInput){
            case daysElement:
                hoursElement.value = daysElement.value * 24;
                minutesElement.value = multiplyTimeBySixty(hoursElement.value);
                secondsElement.value = multiplyTimeBySixty(minutesElement.value);
                break;

            case hoursElement:
                daysElement.value = convertHoursToDays(hoursElement.value);
                minutesElement.value = multiplyTimeBySixty(hoursElement.value);
                secondsElement.value = multiplyTimeBySixty(minutesElement.value);
                break;

            case minutesElement:
                secondsElement.value = multiplyTimeBySixty(minutesElement.value);
                hoursElement.value = divideTimeBySixty(minutesElement.value);
                daysElement.value = convertHoursToDays(hoursElement.value);
                break;

            case secondsElement:
                minutesElement.value = divideTimeBySixty(secondsElement.value);
                hoursElement.value = divideTimeBySixty(minutesElement.value);
                daysElement.value = convertHoursToDays(hoursElement.value)
                break;
        }
    }));

    function multiplyTimeBySixty(time){
        return time * 60;
    }
    
    function divideTimeBySixty(time){
        return time / 60;
    }

    function convertHoursToDays(hours){
        return hours / 24;
    }
}
