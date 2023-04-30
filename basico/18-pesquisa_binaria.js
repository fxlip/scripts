/*

Função que recebe um array ordenado de números inteiros e também um número alvo. 

Usa-se o algoritmo de Busca Binária para determinar se o número alvo está contido no array;
Retornará seu índice se estiver, caso contrário retornará -1.

*/

function binarySearch(array, target) {
    // Defina o intervalo inicial para a busca binária
    let left = 0;
    let right = array.length - 1;
  
    // Enquanto o intervalo não estiver vazio
    while (left <= right) {
        // Calcule o índice do meio do intervalo
        let middle = Math.floor((left + right) / 2);
  
        // Verifique se o elemento do meio é igual ao alvo
        if (array[middle] === target) {
            return middle;
        }
        // Se o elemento do meio for maior que o alvo, atualize o limite direito
        else if (array[middle] > target) {
            right = middle - 1;
        }
        // Se o elemento do meio for menor que o alvo, atualize o limite esquerdo
        else {
            left = middle + 1;
        }
    }
  
    // Se o alvo não for encontrado, retorne -1
    return -1;
}
 
exports.binarySearch = binarySearch;