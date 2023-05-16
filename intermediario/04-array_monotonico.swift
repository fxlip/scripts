/*

Função que recebe um array de inteiros e retorna um booleano representando se o array é monotônico ou não.

Monotônico: se seus elementos, da esquerda para a direita, são inteiramente não-crescentes ou inteiramente não-decrescentes.

Elementos não-crescentes: não são necessariamente exclusivamente decrescentes; eles simplesmente não aumentam. 
Elementos não-decrescentes: não são necessariamente exclusivamente crescentes; eles simplesmente não diminuem.

*/

class Program {
    func isMonotonic(array: [Int]) -> Bool {
        // se o array tiver menos de 2 elementos, ele é monotônico
        if array.count <= 2 {
            return true
        }

        // determina a direção inicial do array
        var direction = array[1] - array[0]
        for i in 2..<array.count {
            // se a direção for 0, atualize a direção
            if direction == 0 {
                direction = array[i] - array[i - 1]
                continue
            }
            // verifica se a direção foi quebrada
            if breaksDirection(direction, array[i - 1], array[i]) {
                return false
            }
        }
        // se a direção não foi quebrada, o array é monotônico
        return true
    }

    // função auxiliar para verificar se a direção foi quebrada
    func breaksDirection(_ direction: Int, _ previousInt: Int, _ currentInt: Int) -> Bool {
        let difference = currentInt - previousInt
        if direction > 0 {
            return difference < 0
        }
        return difference > 0
    }
}