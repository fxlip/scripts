/*

Função que retorna a quantidade mínima do tempo total de espera para todas consultas. 

Um array não vazio de inteiros positivos representa a quantidade de tempo que consultas específicas levam para serem executadas. 
Apenas uma consulta pode ser executada por vez mas as consultas podem ser executadas em qualquer ordem.

O tempo de espera de uma consulta é definido como a quantidade de tempo que ela deve esperar antes que sua execução comece. 
Em outras palavras, se uma consulta é executada em segundo lugar, seu tempo de espera é a duração da primeira consulta; 
Se uma consulta é executada em terceiro lugar, seu tempo de espera é a soma das durações das duas primeiras consultas.

Por exemplo, se forem fornecidas as consultas de duração [1, 4, 5];
O tempo total de espera se as consultas fossem executadas na ordem de [5, 1, 4] seria (0) + (5) + (5 + 1) = 11. 

A primeira consulta de duração 5 seria executada imediatamente, então seu tempo de espera seria 0;
A segunda consulta de duração 1 teria que esperar 5 segundos (a duração da primeira consulta) para ser executada;
A última consulta teria que esperar a duração das duas primeiras consultas antes de ser executada.

*/

import java.util.*;

class Program {

    public int minimumWaitingTime(int[] queries) {
        // Ordena o array de consultas em ordem crescente
        Arrays.sort(queries);
        
        // Inicializa a variável que armazenará o tempo total de espera
        int totalWaitingTime = 0;
        
        // Inicializa a variável que armazenará o tempo de espera para a consulta atual
        int currentWaitingTime = 0;
        
        // Percorre o array de consultas
        for (int i = 1; i < queries.length; i++) {
            // Adiciona a duração da consulta anterior ao tempo de espera atual
            currentWaitingTime += queries[i - 1];
            
            // Adiciona o tempo de espera atual ao tempo total de espera
            totalWaitingTime += currentWaitingTime;
        }
        
        // Retorna o tempo total de espera mínimo
        return totalWaitingTime;
    }
}
