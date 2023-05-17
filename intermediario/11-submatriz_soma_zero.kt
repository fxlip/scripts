/*

Função que retorna um booleano representando se existe ou não um subarray de soma zero em uma lista de inteiros. 

Um subarray de soma zero é qualquer subarray em que todos os valores somam zero. 

Um subarray pode ser tão pequeno quanto um elemento e tão grande quanto a lista original.

*/

package com.algoexpert.program

fun zeroSumSubarray(nums: List<Int>): Boolean {
    // Conjunto para armazenar as somas acumuladas
    val sumSet = mutableSetOf<Int>()
    // Variável para armazenar a soma acumulada atual
    var sum = 0

    // Percorre a lista de números
    for (num in nums) {
        // Calcula a soma acumulada adicionando o número atual
        sum += num

        // Verifica se a soma atual é igual a zero, se já foi encontrada antes ou se o número atual é zero
        if (sum == 0 || sumSet.contains(sum) || num == 0) {
            // Se alguma das condições for verdadeira, indica que foi encontrado um subarray de soma zero
            return true
        }

        // Adiciona a soma atual ao conjunto
        sumSet.add(sum)
    }

    // Caso não tenha sido encontrado nenhum subarray de soma zero
    return false
}