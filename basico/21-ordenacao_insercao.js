/*

Função que recebe um array de números inteiros e retorna uma versão ordenada usando o algoritmo Insertion Sort.

*/

function insertionSort(array) {
    // Percorre o array a partir do segundo elemento
    for (let i = 1; i < array.length; i++) {
        // Armazena o valor do elemento atual e define o índice para iniciar a comparação
        let currentValue = array[i];
        let j = i - 1;

        // Compara o valor atual com os elementos anteriores
        while (j >= 0 && array[j] > currentValue) {
            // Move o elemento maior para frente
            array[j + 1] = array[j];
            j--;
        }

        // Insere o valor atual na posição correta
        array[j + 1] = currentValue;
    }

    // Retorna o array ordenado
    return array;
}

exports.insertionSort = insertionSort;