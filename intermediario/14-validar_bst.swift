/*

Input: lista não ordenada de números inteiros únicos nums no intervalo de [1, n], 
        onde n representa o comprimento de nums + 2. 
        Isso significa que dois números nesse intervalo estão faltando na lista.

Função que recebe uma essa lista e retorne uma nova lista com os dois números ausentes, ordenados numericamente.

*/

class Program {
    func missingNumbers(_ nums: [Int]) -> [Int] {
        // Encontrar o valor máximo na lista original
        let n = nums.count + 2
        
        // Criar um conjunto para armazenar os números presentes na lista original
        var numSet = Set(nums)
        
        // Criar um array para armazenar os números ausentes
        var missingNums = [Int]()
        
        // Verificar cada número no intervalo de 1 a n
        for num in 1...n {
            // Se o número não estiver presente no conjunto, ele está ausente
            if !numSet.contains(num) {
                missingNums.append(num)
            }
        }
        
        // Retornar os números ausentes, ordenados numericamente
        return missingNums.sorted()
    }
}