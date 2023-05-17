/*

Função que percorre o array e, para cada valor, verifica se o elemento no índice correspondente a esse valor (menos um) é negativo. 

Se for negativo, significa que esse valor já foi visto antes e é o primeiro valor duplicado. 
Caso contrário, o elemento no índice correspondente é multiplicado por -1 para marcar que esse valor já foi visto.

*/

class Program {
    func firstDuplicateValue(_ array: inout [Int]) -> Int {
        // Percorre o array
        for value in array {
            // Obtém o valor absoluto do elemento atual
            let absValue = abs(value)
            // Verifica se o elemento no índice correspondente a esse valor (menos um) é negativo
            if array[absValue - 1] < 0 {
                // Se for negativo, retorna o valor absoluto do elemento atual como o primeiro valor duplicado
                return absValue
            }
            // Caso contrário, multiplica o elemento no índice correspondente por -1 para marcar que esse valor já foi visto
            array[absValue - 1] *= -1
        }
        // Se nenhum valor duplicado foi encontrado, retorna -1
        return -1
    }
}