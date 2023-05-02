/*

Input: um array não vazio de inteiros distintos e um inteiro representando uma soma alvo. 

Função que encontra todos os trios no array que somam à soma alvo e retornar um array bidimensional de todos esses trios. 

Os números em cada trio são ordenados em ordem crescente e os próprios trios são ordenados em ordem crescente em relação aos números que contêm.

Quando não há três números que somem à soma alvo a função retorna um array vazio.

*/

package com.algoexpert.program

fun threeNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
    // Ordene o array
    array.sort()

    val triplets = mutableListOf<List<Int>>()

    // Percorra o array, e use dois ponteiros para encontrar os trios
    for (i in 0 until array.size - 2) {
        var left = i + 1
        var right = array.size - 1

        while (left < right) {
            val currentSum = array[i] + array[left] + array[right]
            when {
                currentSum == targetSum -> {
                    triplets.add(listOf(array[i], array[left], array[right]))
                    left++
                    right--
                }
                currentSum < targetSum -> left++
                else -> right--
            }
        }
    }

    // Retorne a lista de trios encontrados
    return triplets
}