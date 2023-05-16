/*

Função que recebe um array de inteiros e retorna o comprimento do pico mais longo no array.

Um pico é definido como inteiros adjacentes no array que são estritamente crescentes 
até atingirem um ponto máximo (o valor mais alto do pico), a partir do qual se tornam estritamente decrescentes. 

Pelo menos três inteiros são necessários para formar um pico.

Exemplo: os inteiros 1, 4, 10, 2 formam um pico, mas os inteiros 4, 0, 10 não e nem os inteiros 1, 2, 2, 0. 
Da mesma forma, os inteiros 1, 2, 3 não formam um pico porque não há inteiros estritamente decrescentes após o 3.

*/

class Program {
    func longestPeak(array: [Int]) -> Int {
        var longestPeakLength = 0 // comprimento do pico mais longo
        var i = 1 // índice para percorrer o array
        while i < array.count - 1 {
            // verifica se o elemento atual é um pico
            let isPeak = array[i - 1] < array[i] && array[i] > array[i + 1]
            if !isPeak {
                i += 1
                continue
            }

            // encontra o índice do início do pico
            var leftIdx = i - 2
            while leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1] {
                leftIdx -= 1
            }

            // encontra o índice do final do pico
            var rightIdx = i + 2
            while rightIdx < array.count && array[rightIdx] < array[rightIdx - 1] {
                rightIdx += 1
            }

            // calcula o comprimento do pico atual
            let currentPeakLength = rightIdx - leftIdx - 1
            // atualiza o comprimento do pico mais longo se necessário
            longestPeakLength = max(longestPeakLength, currentPeakLength)
            // move o índice para depois do pico atual
            i = rightIdx
        }
        return longestPeakLength // retorna o comprimento do pico mais longo
    }
}