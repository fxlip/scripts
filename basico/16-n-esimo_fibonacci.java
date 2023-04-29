/*

Função que recebe um número inteiro n e retorna o enésimo número de Fibonacci.

A sequência de Fibonacci é definida da seguinte forma: 
O primeiro número da sequência é 0, o segundo número é 1 e o enésimo número é a soma dos números (n - 1) e (n - 2). 

Nota: a sequência de Fibonacci é frequentemente definida com seus dois primeiros números como F0 = 0 e F1 = 1. 
Para o propósito desse algoritmo, o primeiro número de Fibonacci é F0; 
Portanto, getNthFib(1) é igual a F0, getNthFib(2) é igual a F1 e assim por diante.

*/

import java.util.*;

class Program {
    public static int getNthFib(int n) {
        // Caso base: se n for 1 ou 2, retorna n-1 (já que F0 = 0 e F1 = 1)
        if (n == 1 || n == 2) {
            return n - 1;
        }

        // Inicializa os dois primeiros números de Fibonacci
        int firstFib = 0;
        int secondFib = 1;

        // Itera do terceiro número de Fibonacci até o enésimo
        for (int i = 3; i <= n; i++) {
            // Calcula o próximo número de Fibonacci como a soma dos dois anteriores
            int nextFib = firstFib + secondFib;

            // Atualiza os dois primeiros números de Fibonacci para a próxima iteração
            firstFib = secondFib;
            secondFib = nextFib;
        }

        // Retorna o enésimo número de Fibonacci
        return secondFib;
    }
}


