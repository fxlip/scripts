/*

Função que recebe uma lista de strings únicas e retorna uma lista de pares de semordnilaps.

Um par de semordnilaps é definido como:
- conjunto de strings diferentes em que o inverso de uma palavra é o mesmo que a versão direta da outra. 
- exemplo: as palavras "diaper" e "repaid" são um par de semordnilaps, 
assim como as palavras "palindromes" e "semordnilap".

*/

function semordnilap(words) {
    // Crie um mapa para armazenar as palavras e seus reversos
    const wordMap = new Map();
    const result = [];
  
    // Adicione as palavras e seus reversos no mapa
    for (const word of words) {
        const reversedWord = word.split('').reverse().join('');
        if (wordMap.has(reversedWord)) {
            result.push([word, reversedWord]);
        } else {
            wordMap.set(word, reversedWord);
        }
    }
  
    // Retorne a lista de pares semordnilap
    return result;
}

exports.semordnilap = semordnilap;  