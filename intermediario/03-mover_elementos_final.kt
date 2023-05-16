/*

Input: array de inteiros e um inteiro.

Função que move todas as instâncias desse inteiro para o final do array e o retorna.

*/

package com.algoexpert.program

fun moveElementToEnd(array: MutableList<Int>, toMove: Int): List<Int> {
    var i = 0 // índice do início do array
    var j = array.size - 1 // índice do final do array
    while (i < j) {
        // enquanto o elemento no final do array for igual a `toMove`, mova o índice `j` para a esquerda
        while (i < j && array[j] == toMove) j--
        // se o elemento no início do array for igual a `toMove`, troque-o com o elemento no índice `j`
        if (array[i] == toMove) {
            val temp = array[j]
            array[j] = array[i]
            array[i] = temp
        }
        // mova o índice `i` para a direita
        i++
    }
    return array // retorne o array modificado
}