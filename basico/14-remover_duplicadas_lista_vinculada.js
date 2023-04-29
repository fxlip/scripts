/*

Input: cabeçalho com uma lista cujos nós estão em ordem classificada em relação aos seus valores. 

Essa função retorna uma versão modificada da lista que não contém nenhum nó com valores duplicados. 

A lista é modificada local ao invés de ser criada uma nova lista.
A lista modificada ainda tem seus nós classificados em relação aos seus valores.

Cada nó da LinkedList tem um valor inteiro;
E um nó next apontando para o próximo nó da lista ou para none/null se for o final da lista.

*/

class LinkedList {
    constructor(value) {
      this.value = value;
      this.next = null;
    }
}

function removeDuplicatesFromLinkedList(linkedList) {
    // Cria um ponteiro atual para o nó cabeçalho da lista ligada
    let currentNode = linkedList;
  
    // Enquanto o nó atual não for nulo
    while (currentNode !== null) {
      // Cria um ponteiro para o próximo nó diferente
      let nextDistinctNode = currentNode.next;
  
      // Enquanto o próximo nó diferente não for nulo e seu valor for igual ao nó atual
      while (nextDistinctNode !== null && nextDistinctNode.value === currentNode.value) {
        // Avança o ponteiro para o próximo nó diferente
        nextDistinctNode = nextDistinctNode.next;
      }
  
      // Atualiza o ponteiro 'next' do nó atual para o próximo nó diferente
      currentNode.next = nextDistinctNode;
  
      // Move o ponteiro atual para o próximo nó diferente
      currentNode = nextDistinctNode;
    }
  
    // Retorna o cabeçalho da lista ligada modificada
    return linkedList;
}

exports.LinkedList = LinkedList;
exports.removeDuplicatesFromLinkedList = removeDuplicatesFromLinkedList;