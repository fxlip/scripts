/*

Classe BST para uma Árvore de Busca Binária.
    - Inserção de valores com o método insert.
    - Remoção de valores com o método remove; 
    (este método remove apenas a primeira ocorrência de um valor dado)
    - Busca de valores com o método contains.

Não é possível remover valores de uma árvore com apenas um nó. 
Chamar o método ´remove´ em uma árvore com apenas um nó não irá fazer nada.

Cada nó da BST possui:
    - um valor inteiro, 
    - um nó filho à esquerda (left) 
    - e um nó filho à direita (right). 

Um nó é considerado válido na BST se e somente se ele satisfizer a propriedade da BST: 
- seu valor é estritamente maior do que os valores de todos os nós à sua esquerda; 
- seu valor é menor ou igual aos valores de todos os nós à sua direita; 
- e seus nós filhos são nós válidos da BST ou nulos (null).

*/

package com.algoexpert.program
class BST(var value: Int) {
    var left: BST? = null
    var right: BST? = null

    // Método para inserir um novo valor na árvore binária de busca
    fun insert(value: Int): BST {
        if (value < this.value) {
            if (left == null) {
                left = BST(value)
            } else {
                left!!.insert(value)
            }
        } else {
            if (right == null) {
                right = BST(value)
            } else {
                right!!.insert(value)
            }
        }
        return this
    }

    // Método para verificar se um valor está presente na árvore binária de busca
    fun contains(value: Int): Boolean {
        if (value < this.value) {
            return left?.contains(value) ?: false
        } else if (value > this.value) {
            return right?.contains(value) ?: false
        } else {
            return true
        }
    }

    // Método para remover um valor da árvore binária de busca
    fun remove(value: Int, parent: BST? = null): BST? {
        if (value < this.value) {
            left?.remove(value, this)
        } else if (value > this.value) {
            right?.remove(value, this)
        } else {
            if (left != null && right != null) {
                // Se o nó a ser removido tem dois filhos, substitua seu valor pelo menor valor do filho direito e remova esse valor do filho direito.
                this.value = right!!.getMinValue()
                right!!.remove(this.value, this)
            } else if (parent == null) {
                // Se o nó a ser removido é a raiz e tem apenas um filho, substitua seu valor pelo valor do filho e atualize os filhos da raiz.
                if (left != null) {
                    this.value = left!!.value
                    right = left!!.right
                    left = left!!.left
                } else if (right != null) {
                    this.value = right!!.value
                    left = right!!.left
                    right = right!!.right
                }
            } else if (parent.left == this) {
                // Se o nó a ser removido tem apenas um filho, atualize o pai para apontar para o filho.
                parent.left = left ?: right
            } else if (parent.right == this) {
                parent.right = left ?: right
            }
        }
        return this
    }

    // Método para obter o menor valor da árvore binária de busca.
    fun getMinValue(): Int {
        return if (left == null) value else left!!.getMinValue()
    }
}