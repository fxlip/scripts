/*

Input: string não vazia de letras minúsculas e um número inteiro não negativo representando uma chave.

Função que retorna uma nova string obtida deslocando cada letra na string de entrada por k posições no alfabeto, onde k é a chave.

O script dá uma volta no alfabeto: a letra 'z' deslocada por um retorna a letra 'a'.

*/

import java.util.*;

class Program {
    public static String caesarCypherEncryptor(String str, int key) {
        // Cria um array de caracteres para armazenar a string criptografada
        char[] encryptedString = new char[str.length()];

        // Ajusta a chave para ficar dentro do intervalo de 0 a 25
        key %= 26;

        // Itera sobre cada caractere da string de entrada
        for (int i = 0; i < str.length(); i++) {
            // Desloca o caractere pela quantidade da chave e verifica se precisa "dar a volta" no alfabeto
            int shiftedChar = str.charAt(i) + key;
            if (shiftedChar > 'z') {
                shiftedChar = 'a' + (shiftedChar - 'z' - 1);
            }

            // Adiciona o caractere criptografado ao array de caracteres
            encryptedString[i] = (char) shiftedChar;
        }

        // Retorna a string criptografada
        return new String(encryptedString);
    }
}