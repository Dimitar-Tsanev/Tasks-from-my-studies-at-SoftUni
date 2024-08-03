function attachGradientEvents() {
    //TODO:...
    const target = document.getElementById('gradient');
    const outputElement = document.getElementById('result');
   
    target.addEventListener('mousemove', (event) => {
        let pointerPosition = event.offsetX;
        const elementWidth = event.currentTarget.clientWidth;

        outputElement.textContent = `${Math.floor(Number(pointerPosition) /Number(elementWidth) * 100)}%`;
    });
}
