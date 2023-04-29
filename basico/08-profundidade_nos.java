/*

A distância entre um nó em uma Árvore Binária e a raiz da árvore é chamada de profundidade do nó.

Essa função recebe uma Árvore Binária e retorna a soma das profundidades de seus nós.

Cada nó BinaryTree possui um valor inteiro, um nó filho à esquerda e um nó filho à direita. 
Os nós filhos podem ser nós BinaryTree ou none/null.

*/
import java.util.*;

class Program {

    public static int nodeDepths(BinaryTree root) {
        // Chama a função auxiliar recursiva com a raiz da árvore e profundidade inicial 0
        return calculateNodeDepths(root, 0);
    }

    // Função auxiliar recursiva para calcular a soma das profundidades dos nós
    public static int calculateNodeDepths(BinaryTree node, int depth) {
        if (node == null) { // Caso base: se o nó for nulo, retorne 0
            return 0;
        }
        // Soma a profundidade atual com as profundidades dos nós filhos à esquerda e à direita
        return depth + calculateNodeDepths(node.left, depth + 1) + calculateNodeDepths(node.right, depth + 1);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
