/*

Função que recebe um array de números inteiros e retorna uma versão ordenada usando o algoritmo Bubble Sort.

*/

import java.util.*;

class Program {
    public static int[] bubbleSort(int[] array) {
        // Verifica se o array está vazio ou com apenas um elemento
        if (array.length == 0 || array.length == 1) {
            return array;
        }

        // Inicializa a variável para controlar se houve troca
        boolean swapped;

        // Percorre o array até que não ocorra mais trocas
        do {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                // Se o elemento atual for maior que o próximo elemento, troque-os
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }
        } 
        while (swapped);

        // Retorna o array ordenado
        return array;
    }

    // Método auxiliar para trocar os elementos do array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}