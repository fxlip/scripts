/*

Input: classe Node que possui um nome e um array de nós filhos opcionais. 
Quando reunidos, os nós formam uma estrutura em forma de árvore acíclica.

Método depthFirstSearch na classe Node: 
- recebe um array vazio
- percorre a árvore usando a abordagem de Busca em Profundidade (navegando especificamente na árvore da esquerda para a direita)
- armazena todos os nomes dos nós no array de entrada e o retorna

*/

class Node {
    constructor(name) {
        this.name = name;
        this.children = [];
    }

    addChild(name) {
        this.children.push(new Node(name));
        return this;
    }

    depthFirstSearch(array) {
        // Adiciona o nome do nó atual ao array
        array.push(this.name);
        
        // Percorre todos os nós filhos do nó atual
        for (const child of this.children) {
            // Chama recursivamente a função depthFirstSearch para cada nó filho
            child.depthFirstSearch(array);
        }
        
        // Retorna o array com os nomes dos nós após percorrer a árvore
        return array;
    }
}

exports.Node = Node;