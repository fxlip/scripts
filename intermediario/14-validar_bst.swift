/*

Função que recebe uma árvore de busca binária potencialmente inválida e retorna um booleano.

Cada nó da BST possui um valor inteiro, um nó filho esquerdo e um nó filho direito.

Um nó é considerado um nó válido da BST somente se ele satisfizer a propriedade da BST: 
    seu valor é estritamente maior que os valores de todos os nós à sua esquerda; 
    sseu valor é menor ou igual aos valores de todos os nós à sua direita; 
    e seus nós filhos são nós válidos da BST ou nulos.

Uma BST é válida somente se todos os seus nós forem nós válidos da BST.

*/

class Program {
    // Esta é uma classe de entrada. Não a edite.
    class BST {
        var value: Int?       // Valor do nó
        var left: BST?        // Nó filho esquerdo
        var right: BST?       // Nó filho direito

        init(value: Int) {
            self.value = value
            left = nil
            right = nil
        }
    }

    // Função principal para validar a BST
    func validateBst(tree: BST) -> Bool {
        // Chamada ao método auxiliar para realizar a validação com os valores mínimos e máximos iniciais
        return validateBstHelper(tree, minVal: Int.min, maxVal: Int.max)
    }
  
    // Método auxiliar para validar a BST usando recursão
    func validateBstHelper(_ tree: BST?, minVal: Int, maxVal: Int) -> Bool {
        // Se chegarmos ao final da árvore (nó nulo), retorna verdadeiro
        if tree == nil {
            return true
        }
    
        // Verifica o valor atual do nó
        if let value = tree?.value {
            // Se o valor estiver fora do intervalo válido, retorna falso
            if value < minVal || value >= maxVal {
                return false
            }
        
        // Chama recursivamente o método auxiliar para o filho esquerdo e o filho direito, ajustando os valores mínimos e máximos
        return validateBstHelper(tree?.left, minVal: minVal, maxVal: value) && validateBstHelper(tree?.right, minVal: value, maxVal: maxVal)
        }
        
    return false
  }
}