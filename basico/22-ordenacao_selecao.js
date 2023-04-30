/*

Função que recebe um array de números inteiros e retorna uma versão ordenada usando o algoritmo Selection Sort.

*/

function selectionSort(array) {
    // Percorre o array até o penúltimo elemento
    for (let i = 0; i < array.length - 1; i++) {
        // Define o índice do menor valor como o índice atual
        let minIndex = i;

        // Percorre o restante do array procurando um valor menor
        for (let j = i + 1; j < array.length; j++) {
            if (array[j] < array[minIndex]) {
                // Atualiza o índice do menor valor
                minIndex = j;
            }
        }

        // Se o índice do menor valor for diferente do índice atual, troca os elementos
        if (minIndex !== i) {
            [array[i], array[minIndex]] = [array[minIndex], array[i]];
        }
    }

    // Retorna o array ordenado
    return array;
}

exports.selectionSort = selectionSort;  