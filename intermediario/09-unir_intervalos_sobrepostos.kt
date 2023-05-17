/*

Função que ordena os intervalos pelo início de cada um e depois percorre a lista de intervalos ordenados 
verificando se o fim do intervalo atual é maior ou igual ao início do próximo intervalo. 

Se for maior ou igual, significa que os dois intervalos estão sobrepostos e devem ser unidos. 
Caso contrário, o próximo intervalo é adicionado à lista de intervalos unidos.

*/

package com.algoexpert.program

fun mergeOverlappingIntervals(intervals: List<List<Int>>): List<List<Int>> {
    // Ordena os intervalos pelo início de cada um
    val sortedIntervals = intervals.sortedBy { it[0] }
    // Cria uma lista mutável para armazenar os intervalos unidos
    val mergedIntervals = mutableListOf<List<Int>>()
    // Inicializa o intervalo atual como o primeiro intervalo da lista ordenada
    var currentInterval = sortedIntervals[0].toMutableList()
    // Adiciona o intervalo atual à lista de intervalos unidos
    mergedIntervals.add(currentInterval)
    // Percorre a lista de intervalos ordenados
    for (nextInterval in sortedIntervals) {
        // Obtém o fim do intervalo atual e o início do próximo intervalo
        val (currentIntervalEnd, nextIntervalStart) = listOf(currentInterval[1], nextInterval[0])
        // Verifica se o fim do intervalo atual é maior ou igual ao início do próximo intervalo
        if (currentIntervalEnd >= nextIntervalStart) {
            // Se for maior ou igual, atualiza o fim do intervalo atual para o máximo entre o fim do intervalo atual e o fim do próximo intervalo
            currentInterval[1] = maxOf(currentIntervalEnd, nextInterval[1])
        } else {
            // Caso contrário, atualiza o intervalo atual para o próximo intervalo e adiciona-o à lista de intervalos unidos
            currentInterval = nextInterval.toMutableList()
            mergedIntervals.add(currentInterval)
        }
    }
    // Retorna a lista de intervalos unidos
    return mergedIntervals
}
