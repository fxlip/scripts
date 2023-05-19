/*

Aqui estão três funções que percorrem uma Árvore de Busca Binária (BST) e adicionam os valores dos nós em uma array de entrada, retornando essa array. 

As três funções realizam o percurso da BST utilizando as técnicas de travessia em ordem (in-order), pré-ordem (pre-order) e pós-ordem (post-order), respectivamente.

As técnicas de travessia em ordem, pré-ordem e pós-ordem são utilizadas para visitar os nós de uma árvore em uma ordem específica. 

Com essas funções é possível obter os valores dos nós de uma BST.

Cada nó de uma BST possui um valor inteiro, um nó filho à esquerda (left) e um nó filho à direita (right). 
Para garantir que a BST seja válida, é importante que cada nó satisfaça a propriedade da BST: 
    o valor do nó é estritamente maior que os valores de todos os nós à sua esquerda; 
    o valor do nó é menor ou igual aos valores de todos os nós à sua direita; 
    e seus nós filhos são nós válidos de uma BST ou nulos (none/null).

*/

package com.algoexpert.program

open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null
}

fun inOrderTraverse(tree: BST?, array: MutableList<Int>): List<Int> {
    // Verifica se o nó atual não é nulo
    tree?.let {
        // Percorre o nó filho à esquerda
        inOrderTraverse(tree.left, array)

        // Adiciona o valor do nó atual à lista
        array.add(tree.value)

        // Percorre o nó filho à direita
        inOrderTraverse(tree.right, array)
    }

    // Retorna a lista resultante
    return array
}

fun preOrderTraverse(tree: BST?, array: MutableList<Int>): List<Int> {
    // Verifica se o nó atual não é nulo
    tree?.let {
        // Adiciona o valor do nó atual à lista
        array.add(tree.value)

        // Percorre o nó filho à esquerda
        preOrderTraverse(tree.left, array)

        // Percorre o nó filho à direita
        preOrderTraverse(tree.right, array)
    }

    // Retorna a lista resultante
    return array
}

fun postOrderTraverse(tree: BST?, array: MutableList<Int>): List<Int> {
    // Verifica se o nó atual não é nulo
    tree?.let {
        // Percorre o nó filho à esquerda
        postOrderTraverse(tree.left, array)

        // Percorre o nó filho à direita
        postOrderTraverse(tree.right, array)

        // Adiciona o valor do nó atual à lista
        array.add(tree.value)
    }

    // Retorna a lista resultante
    return array
}