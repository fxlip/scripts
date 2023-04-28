/*
Função que recebe uma matriz de inteiros ordenada em ordem crescente e retorna uma nova matriz 
com os quadrados desses inteiros, também ordenada em ordem crescente.
*/
import java.util.*;

class Program {
  public int[] sortedSquaredArray(int[] array) {
    int[] sortedSquares = new int[array.length]; // Inicializa o novo array com o mesmo tamanho do original
    int left = 0; // Ponteiro para o início do array original
    int right = array.length - 1; // Ponteiro para o final do array original

    for (int i = array.length - 1; i >= 0; i--) {
      if (Math.abs(array[left]) > Math.abs(array[right])) {
        sortedSquares[i] = array[left] * array[left]; // Insere o quadrado do maior valor absoluto no novo array
        left++; // Avança o ponteiro esquerdo
      } else {
        sortedSquares[i] = array[right] * array[right]; // Insere o quadrado do maior valor absoluto no novo array
        right--; // Move o ponteiro direito para a esquerda
      }
    }

    return sortedSquares;
  }
}