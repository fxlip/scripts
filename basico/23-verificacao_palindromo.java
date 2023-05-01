/*

Função que recebe uma string não vazia e retorna um booleano representando se a string é um palíndromo.

Um palíndromo é definido como uma string que é escrita da mesma forma de trás para frente. 
OBS: Strings de um único caractere são palíndromos.

*/

import java.util.*;

class Program {
    public static boolean isPalindrome(String str) {
        // Inicializa dois ponteiros, um no início e outro no fim da string
        int left = 0;
        int right = str.length() - 1;

        // Enquanto os ponteiros não se encontrarem, verifica se os caracteres são iguais
        while (left < right) {
            // Se os caracteres nas posições dos ponteiros forem diferentes, a string não é um palíndromo
            if (str.charAt(left) != str.charAt(right)) {
                return false;
        }

        // Move os ponteiros em direção ao centro da string
        left++;
        right--;
        }

        // Se todos os caracteres foram iguais, a string é um palíndromo
        return true;
    }
}