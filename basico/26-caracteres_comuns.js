/*

Função que recebe uma lista não vazia de strings não vazias e retorna uma lista de caracteres que são comuns a todas as strings na lista, ignorando a multiplicidade.

PS1: As strings não têm garantia de conter apenas caracteres alfanuméricos. 
PS2: A lista que retorna pode estar em qualquer ordem.

*/

function commonCharacters(strings) {
    // Crie um objeto para armazenar a contagem de caracteres.
    let charCount = {};
    
    // Itere sobre a primeira string e adicione os caracteres ao objeto de contagem.
    for (let char of strings[0]) {
        if (!charCount[char]) {
            charCount[char] = 1;
        }
    }
    
    // Itere sobre as strings restantes.
    for (let i = 1; i < strings.length; i++) {
        // Crie um objeto temporário para armazenar a contagem de caracteres da string atual.
        let tempCharCount = {};
        
        // Itere sobre a string atual e adicione os caracteres ao objeto temporário.
        for (let char of strings[i]) {
            if (charCount[char] && !tempCharCount[char]) {
            tempCharCount[char] = 1;
            }
        }
        
        // Atualize o objeto de contagem de caracteres com o objeto temporário.
        charCount = tempCharCount;
    }
    
    // Extraia e retorne os caracteres comuns do objeto de contagem de caracteres.
    return Object.keys(charCount);
  }
  
  exports.commonCharacters = commonCharacters;  