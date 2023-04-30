/*

Função que recebe um array de pelo menos três números inteiros e sem ordenar o array de entrada,
retorna um array ordenado com os três maiores números.

Essa função retorna números inteiros duplicados se necessário; 
Por exemplo: retorna [10, 10, 12] para um array de entrada [10, 5, 9, 10, 12].

*/

import java.util.*;

class Program {
    public static int[] findThreeLargestNumbers(int[] array) {
        // Inicialize um array para armazenar os três maiores números
        int[] largest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        // Itere pelos elementos do array de entrada
        for (int num : array) {
            // Atualize o array dos três maiores números, se necessário
            updateLargest(largest, num);
        }

        // Retorne o array dos três maiores números
        return largest;
    }

    public static void updateLargest(int[] largest, int num) {
        // Verifique e atualize o array dos três maiores números
        if (num > largest[2]) {
            shiftAndUpdate(largest, num, 2);
        } else if (num > largest[1]) {
            shiftAndUpdate(largest, num, 1);
        } else if (num > largest[0]) {
            shiftAndUpdate(largest, num, 0);
        }
    }

    public static void shiftAndUpdate(int[] array, int num, int idx) {
        // Desloque os números e atualize o índice específico com o novo número
        for (int i = 0; i <= idx; i++) {
            if (i == idx) {
                array[i] = num;
            } else {
                array[i] = array[i + 1];
            }
        }
    }
}