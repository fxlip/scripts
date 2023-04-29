/*
Função que recebe uma Árvore Binária de Busca (BST) e um valor inteiro alvo, retornando o valor mais próximo desse valor alvo contido na BST. 
Cada nó da BST possui um valor inteiro, um nó filho à esquerda e um nó filho à direita.

Um nó é considerado um nó válido de BST se e somente se satisfaz a propriedade da BST: 
seu valor é estritamente maior do que os valores de todos os nós à sua esquerda; 
seu valor é menor ou igual aos valores de todos os nós à sua direita; 
e seus nós filhos são nós válidos de BST ou none/null.
*/

function findClosestValueInBst(tree, target) {
    return findClosestValueHelper(tree, target, tree.value);
}
  
function findClosestValueHelper(node, target, closest) {
    if (node === null) {
      return closest; // Chegou no final da árvore, retorna o valor mais próximo encontrado até agora
    }
  
    if (Math.abs(target - closest) > Math.abs(target - node.value)) {
      // Se o valor do nó atual está mais próximo do valor alvo do que o valor mais próximo encontrado até agora,
      // atualiza o valor mais próximo
      closest = node.value;
    }
  
    if (target < node.value) {
      // Se o valor alvo é menor que o valor do nó atual, move-se para a subárvore esquerda
      return findClosestValueHelper(node.left, target, closest);
    } else if (target > node.value) {
      // Se o valor alvo é maior que o valor do nó atual, move-se para a subárvore direita
      return findClosestValueHelper(node.right, target, closest);
    } else {
      // Se o valor alvo é igual ao valor do nó atual, retorna o valor do nó atual
      return node.value;
    }
}

class BST {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

exports.findClosestValueInBst = findClosestValueInBst;