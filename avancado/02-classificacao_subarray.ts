/*

Função que recebe um array de pelo menos dois inteiros e retorna um array com os índices inicial e final;

Se o array de entrada já estiver ordenado a função retorna [-1, -1]

*/

type Range = [number, number];

export function subarraySort(array: number[]): Range {
    // Inicialize as variáveis para armazenar os índices inicial e final do subarray.
    let startIdx = -1;
    let endIdx = -1;
  
    // Encontre o primeiro elemento fora de ordem da esquerda para a direita.
    for (let i = 0; i < array.length - 1; i++) {
        if (array[i] > array[i + 1]) {
            startIdx = i;
            break;
        }
    }

    // Se não encontrarmos nenhum elemento fora de ordem, o array já está ordenado.
    if (startIdx === -1) {
        return [-1, -1];
    }

    // Encontre o primeiro elemento fora de ordem da direita para a esquerda.
    for (let i = array.length - 1; i > 0; i--) {
        if (array[i] < array[i - 1]) {
            endIdx = i;
        break;
        }
    }

    // Encontre os valores mínimo e máximo no subarray.
    let minValue = Infinity;
    let maxValue = -Infinity;
    for (let i = startIdx; i <= endIdx; i++) {
        minValue = Math.min(minValue, array[i]);
        maxValue = Math.max(maxValue, array[i]);
    }

    // Ajuste o índice inicial do subarray.
    while (startIdx > 0 && array[startIdx - 1] > minValue) {
        startIdx--;
    }

    // Ajuste o índice final do subarray.
    while (endIdx < array.length - 1 && array[endIdx + 1] < maxValue) {
        endIdx++;
    }

    return [startIdx, endIdx];
}