/*
Função que determina se um segundo array não vazio e inteiro é uma subsequência do primeiro.

Uma subsequência é um conjunto de números que não são necessariamente adjacentes mas que estão na mesma ordem que aparecem no array. 
Para uma instância, os números [1, 3, 4] formam uma subsequência do array [1, 2, 3, 4] assim como os números [2, 4].
*/
function isValidSubsequence(array, sequence) {
  let arrIdx = 0;
  let seqIdx = 0;

  while (arrIdx < array.length && seqIdx < sequence.length) {
    if (array[arrIdx] === sequence[seqIdx]) {
      seqIdx++; // Se os elementos são iguais, avança o ponteiro da subsequência
    }
    arrIdx++; // Sempre avança o ponteiro do array original
  }

  // Se o ponteiro da subsequência atingir o final, significa que todos os elementos foram encontrados no array original
  return seqIdx === sequence.length;
}
exports.isValidSubsequence = isValidSubsequence;