/*

Input: matriz não vazia de inteiros;
Output: matriz de mesmo tamanho;
        cada elemento é igual ao produto de todos os outros números na matriz de entrada

valor em output[i] é igual ao produto de todos os números na matriz de entrada exceto input[i]

Função que calcula o produto de todos os elementos 
à esquerda e à direita de cada elemento da matriz de entrada 
e armazena esses valores na matriz de saída. 

Isso resolve o problema em tempo linear O(n) e espaço constante O(1), 
já que a matriz de saída não é considerada no cálculo do espaço adicional usado pelo algoritmo.

*/

package com.algoexpert.program

fun arrayOfProducts(array: List<Int>): List<Int> {
        // Cria uma lista mutável do mesmo tamanho que a lista de entrada
        val products = MutableList(array.size) { 1 }
        
        // Inicializa uma variável para armazenar o produto acumulado dos elementos à esquerda
        var leftRunningProduct = 1
        
        // Percorre a lista da esquerda para a direita
        for (i in array.indices) {
            // Armazena o produto acumulado dos elementos à esquerda na lista de saída
            products[i] = leftRunningProduct
            // Atualiza o produto acumulado dos elementos à esquerda
            leftRunningProduct *= array[i]
        }
        
        // Inicializa uma variável para armazenar o produto acumulado dos elementos à direita
        var rightRunningProduct = 1
        
        // Percorre a lista da direita para a esquerda
        for (i in array.indices.reversed()) {
            // Multiplica o valor atual na lista de saída pelo produto acumulado dos elementos à direita
            products[i] *= rightRunningProduct
            // Atualiza o produto acumulado dos elementos à direita
            rightRunningProduct *= array[i]
        }
        
        // Retorna a lista de saída
        return products
}