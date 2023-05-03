/*

Função que recebe dois arrays não vazios de números inteiros;
encontra o par de números (um de cada array) cuja diferença absoluta é mais próxima de zero;
e retorna um array contendo esses dois números, com o número do primeiro array na primeira posição.

OBS: a diferença absoluta de dois números inteiros é a distância entre eles na reta numérica. 
Por exemplo: a diferença absoluta de -5 e 5 é 10, e a diferença absoluta de -5 e -4 é 1.

*/

class Program {
    func smallestDifference(arrayOne: inout [Int], arrayTwo: inout [Int]) -> [Int] {
        // Ordenar ambos os arrays
        arrayOne.sort()
        arrayTwo.sort()
        
        // Inicializar índices e variáveis para armazenar a menor diferença e o par de números correspondente
        var idxOne = 0
        var idxTwo = 0
        var smallestDifference = Int.max
        var currentDifference = Int.max
        var smallestPair = [Int]()
        
        // Percorrer ambos os arrays até que um deles chegue ao fim
        while idxOne < arrayOne.count, idxTwo < arrayTwo.count {
            let firstNum = arrayOne[idxOne]
            let secondNum = arrayTwo[idxTwo]
            
            // Atualizar a diferença atual e compará-la com a menor diferença
            if firstNum < secondNum {
                currentDifference = secondNum - firstNum
                idxOne += 1
            } else if firstNum > secondNum {
                currentDifference = firstNum - secondNum
                idxTwo += 1
            } else {
                // A diferença é zero, então encontramos o par de números com a menor diferença
                return [firstNum, secondNum]
            }
            
            // Atualizar a menor diferença e o par de números correspondente, se necessário
            if currentDifference < smallestDifference {
                smallestDifference = currentDifference
                smallestPair = [firstNum, secondNum]
            }
        }
        
        return smallestPair
    }
}