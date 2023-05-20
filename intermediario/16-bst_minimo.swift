/*

Função que constrói uma Árvore de Busca Binária (BST) a partir de uma matriz classificada de inteiros distintos e retorna a raiz da BST, minimizando a altura da árvore.

Essa função utiliza uma abordagem de divisão e conquista para construir a BST com altura mínima. 

Ela seleciona o elemento do meio da matriz como a raiz da BST e, em seguida, 
constrói recursivamente as subárvores esquerda e direita usando a metade inferior e superior da matriz, respectivamente. 

Esse processo é repetido até que toda a matriz seja percorrida.

*/

class Program {
  static func minHeightBST(_ array: [Int]) -> BST? {
    return constructBST(array, start: 0, end: array.count - 1)
  }

  static func constructBST(_ array: [Int], start: Int, end: Int) -> BST? {
    // Caso base: se o índice de início for maior que o índice de fim, não há elementos para construir a árvore
    if start > end {
      return nil
    }

    // Encontra o índice do meio da matriz
    let mid = (start + end) / 2

    // Cria um novo nó da árvore com o valor do elemento do meio
    let bst = BST(value: array[mid])

    // Constrói recursivamente a subárvore esquerda usando os elementos do início até o elemento anterior ao meio
    bst.left = constructBST(array, start: start, end: mid - 1)

    // Constrói recursivamente a subárvore direita usando os elementos a partir do próximo elemento após o meio até o fim
    bst.right = constructBST(array, start: mid + 1, end: end)

    // Retorna o nó da árvore construído
    return bst
  }

  class BST {
    var value: Int
    var left: BST?
    var right: BST?

    init(value: Int) {
      self.value = value
    }

    func insert(value: Int) {
      if value < self.value {
        if let left = self.left {
          // Se o valor for menor que o valor do nó atual, insere na subárvore esquerda
          left.insert(value: value)
        } else {
          // Se a subárvore esquerda for nula, cria um novo nó e o atribui como subárvore esquerda
          left = BST(value: value)
        }
      } else {
        if let right = self.right {
          // Se o valor for maior ou igual ao valor do nó atual, insere na subárvore direita
          right.insert(value: value)
        } else {
          // Se a subárvore direita for nula, cria um novo nó e o atribui como subárvore direita
          right = BST(value: value)
        }
      }
    }
  }
}