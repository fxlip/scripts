/*

Input: uma string de caracteres disponíveis e uma string representando um documento que precisa ser gerado. 

Função que determina se o documento pode ser gerado usando os caracteres disponíveis. 

Se o documento puder ser gerado retorna verdadeiro; caso contrário retorna falso.

O documento só pode ser gerado se a frequência de caracteres únicos na string de caracteres for maior ou igual à frequência de caracteres únicos na string do documento.

Por exemplo, se o input for characters = "abcabc" e document = "aabbccc", o documento não pode ser gerado porque está faltando um "c".

O documento pode conter quaisquer caracteres, incluindo caracteres especiais, letras maiúsculas, números e espaços.

PS: uma string vazia ("") sempre pode ser gerada.

*/

import java.util.*;

class Program {

    public boolean generateDocument(String characters, String document) {
        // Criar um mapa para armazenar a contagem de caracteres
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        // Preencher o mapa com a contagem de caracteres na string 'characters'
        for (char c : characters.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Verificar se todos os caracteres do documento estão disponíveis em 'characters'
        for (char c : document.toCharArray()) {
            // Se o caractere não estiver disponível ou a contagem for menor que a necessária, retorne false
            if (!charCountMap.containsKey(c) || charCountMap.get(c) == 0) {
                return false;
            }

            // Decrementar a contagem do caractere no mapa
            charCountMap.put(c, charCountMap.get(c) - 1);
        }

        // Se todos os caracteres do documento estiverem disponíveis em 'characters', retorne true
        return true;
    }
}
