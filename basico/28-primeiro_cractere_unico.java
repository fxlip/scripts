/*

Função que recebe uma string de letras minúsculas do alfabeto e retorna o índice do primeiro caractere não repetido na string.

O primeiro caractere não repetido é o primeiro caractere em uma string que ocorre apenas uma vez.

Se a string de entrada não tiver caracteres não repetidos, a função retorna -1.

*/

import java.util.*;

class Program {

    public int firstNonRepeatingCharacter(String string) {
        // Crie um mapa para armazenar a contagem de caracteres
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        // Preencha o mapa com a contagem de caracteres na string
        for (char c : string.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Verifique cada caractere na string e retorne o índice do primeiro caractere não repetido
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (charCountMap.get(c) == 1) {
                return i;
            }
        }

        // Se todos os caracteres forem repetidos, retorne -1
        return -1;
    }
}