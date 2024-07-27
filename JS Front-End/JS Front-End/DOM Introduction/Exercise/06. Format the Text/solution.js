function solve() {
  //TODO
  const textAreaInput = document.getElementById('input');
  const text = textAreaInput.value;
  textAreaInput.value = '';

  const output = document.getElementById('output');

  const validSentences = text.split('.').filter(element => element.trim().length !== 0).map(sentence => sentence.trim().concat('.'));

  let paragraphs = [];
  let paragraph = '';

  for (let i = 1; i <= validSentences.length; i++){
    paragraph += validSentences[i - 1];

    if (i % 3 === 0){
      paragraphs.push(paragraph);
      paragraph = '';
    }

    if (i === validSentences.length && paragraph.length !== 0 ){
      paragraphs.push(paragraph);
    }
  }
  paragraphs.forEach(paragraph => {
    const pElement = document.createElement('p');
    pElement.textContent = paragraph;
    output.appendChild(pElement)
  });
}