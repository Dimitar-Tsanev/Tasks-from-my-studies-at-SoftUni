function solve() {
  //TODO...
  const selector = document.getElementById('naming-convention').value;
  const textToTransform = document.getElementById('text').value;
  
  let resultText = textToTransform.split(/\s+/).map((w, i) =>{
    w = w.toLowerCase()
    
    if (i !== 0){
      w = w[0].toUpperCase() + w.substring(1, w.length);
    }
    return w;
  })
  .join('');
  
  switch(selector){
    case 'Camel Case':
      document.getElementById('result').textContent = resultText;
      break;
    
    case 'Pascal Case':
      document.getElementById('result').textContent = resultText[0].toUpperCase() + resultText.substring(1, resultText.length);
      break;
    
    default:
      document.getElementById('result').textContent = 'Error!';
      break;
  }
}
