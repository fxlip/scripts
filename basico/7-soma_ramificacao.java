/*

Função que recebe uma Árvore Binária e retorna uma lista das somas de seus ramos.
Ordenadas da soma do ramo mais à esquerda até a soma do ramo mais à direita.

Uma soma de ramo é a soma de todos os valores em um ramo de Árvore Binária. 
Um ramo de Árvore Binária é um caminho de nós em uma árvore que começa no nó raiz e termina em qualquer nó folha.

Cada nó de BinaryTree tem um valor inteiro, um nó filho esquerdo e um nó filho direito. 
Os nós filhos podem ser nós de BinaryTree ou none/null.

*/
import java.util.*;

class Program {
    // Esta é a classe do nó raiz de entrada.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // Função principal para calcular as somas dos ramos
    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> sums = new ArrayList<Integer>(); // Inicializa a lista de somas
        calculateBranchSums(root, 0, sums); // Chama a função recursiva para calcular as somas
        return sums; // Retorna a lista de somas
    }

    // Função recursiva para calcular as somas dos ramos
    public static void calculateBranchSums(BinaryTree node, int runningSum, List<Integer> sums) {
        if (node == null) { // Caso base: se o nó for nulo, retorne
            return;
        }

        // Atualiza a soma com o valor do nó atual
        int newRunningSum = runningSum + node.value;

        // Se o nó for uma folha (não tiver filhos à esquerda ou à direita)
        if (node.left == null && node.right == null) {
            sums.add(newRunningSum); // Adiciona a soma atualizada à lista de somas
            return;
        }

        // Chamadas recursivas para os nós filhos à esquerda e à direita
        calculateBranchSums(node.left, newRunningSum, sums);
        calculateBranchSums(node.right, newRunningSum, sums);
    }
}