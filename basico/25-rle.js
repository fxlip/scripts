/*

Função que recebe uma string não vazia e retorna sua codificação de execução de comprimento (run-length encoding).

"A codificação de execução de comprimento é uma forma de compressão de dados sem perdas em que as execuções de dados são armazenadas como um único valor de dados e contagem, em vez de como a execução original." 

Uma execução de dados é qualquer sequência de caracteres idênticos consecutivos. 
Então, a execução "AAA" será codificada como "3A".

A string de entrada pode conter todos os tipos de caracteres especiais, incluindo números.

*/

function runLengthEncoding(string) {
    // Inicie um array vazio para armazenar a codificação.
    let encoded = [];
    // Inicie a contagem de caracteres consecutivos.
    let count = 1;
  
    // Itere sobre a string, começando do segundo caractere (índice 1).
    for (let i = 1; i <= string.length; i++) {
        // Se o caractere atual for igual ao caractere anterior e a contagem for menor que 9,
        // incremente a contagem.
        if (string[i] === string[i - 1] && count < 9) {
            count++;
        } else {
            // Caso contrário, adicione a contagem e o caractere anterior ao array codificado.
            encoded.push(count.toString());
            encoded.push(string[i - 1]);
            // Reinicie a contagem para 1.
            count = 1;
        }
    }
  
    // Junte o array codificado em uma única string e retorne.
    return encoded.join('');
  }
  
  exports.runLengthEncoding = runLengthEncoding;  