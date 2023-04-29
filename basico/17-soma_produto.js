/*

Função que recebe um array especial e retorna a soma do produto.

Um array especial é um array não vazio que contém inteiros ou outros arrays especiais. 
A soma do produto de um array especial é a soma de seus elementos, onde os arrays especiais dentro dele são somados e multiplicados pelo seu nível de profundidade.

A profundidade de um array especial é o quão aninhado ele está. 
Por exemplo, a profundidade de [] é 1; 
a profundidade do array interno em [[]] é 2; 
a profundidade do array mais interno em [[[]]] é 3.

Portanto, a soma do produto de [x, y] é x + y; 
a soma do produto de [x, [y, z]] é x + 2 * (y + z); 
a soma do produto de [x, [y, [z]]] é x + 2 * (y + 3z).

*/

function productSum(array, multiplier = 1) {
    let sum = 0;
  
    for (const element of array) {
        if (Array.isArray(element)) {
            // Multiplica o resultado da chamada recursiva pelo multiplicador atual
            sum += productSum(element, multiplier + 1) * multiplier;
        } else {
            sum += element * multiplier;
        }
    }
  
    return sum;
}

exports.productSum = productSum;
  