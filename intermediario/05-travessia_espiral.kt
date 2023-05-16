/*

Input: array bidimensional de n x m (que pode ser quadrado quando n == m);
Output: array unidimensional com todos os elementos do array em ordem espiral.

A ordem espiral começa no canto superior esquerdo do array bidimensional;
vai para a direita e prossegue em um padrão espiral até que todos os elementos tenham sido visitados.

*/

fun spiralTraverse(array: List<List<Int>>): List<Int> {
    val result = mutableListOf<Int>() // lista para armazenar o resultado
    var startRow = 0 // índice da primeira linha
    var endRow = array.size - 1 // índice da última linha
    var startCol = 0 // índice da primeira coluna
    var endCol = array[0].size - 1 // índice da última coluna

    // percorre o array em ordem espiral
    while (startRow <= endRow && startCol <= endCol) {
        // percorre a primeira linha da esquerda para a direita
        for (col in startCol..endCol) {
            result.add(array[startRow][col])
        }

        // percorre a última coluna de cima para baixo
        for (row in startRow + 1..endRow) {
            result.add(array[row][endCol])
        }

        // percorre a última linha da direita para a esquerda
        for (col in endCol - 1 downTo startCol) {
            if (startRow == endRow) break
            result.add(array[endRow][col])
        }

        // percorre a primeira coluna de baixo para cima
        for (row in endRow - 1 downTo startRow + 1) {
            if (startCol == endCol) break
            result.add(array[row][startCol])
        }

        // atualiza os índices para continuar percorrendo em espiral
        startRow++
        endRow--
        startCol++
        endCol--
    }

    return result
}