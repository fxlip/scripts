/*

Input: lista com pelo menos um nó.

Função que retorna o nó do meio de uma lista ligada. 
Se houver dois nós do meio (uma lista de comprimento par), a função retorna o segundo desses nós.

Cada nó da LinkedList tem um valor inteiro;
E um nó next apontando para o próximo nó da lista ou para none/null se for o final da lista.

*/
import java.util.*;

class Program {
    public static class LinkedList {
        public int value;
        public LinkedList next;
        
        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList middleNode(LinkedList linkedList) {
        // Cria dois ponteiros, um lento e um rápido, ambos iniciando no cabeçalho da lista ligada
        LinkedList slowPointer = linkedList;
        LinkedList fastPointer = linkedList;

        // Enquanto o ponteiro rápido e o próximo não forem nulos
        while (fastPointer != null && fastPointer.next != null) {
            // Move o ponteiro lento um passo à frente
            slowPointer = slowPointer.next;
            
            // Move o ponteiro rápido dois passos à frente
            fastPointer = fastPointer.next.next;
        }

        // Retorna o nó do meio, apontado pelo ponteiro lento
        return slowPointer;
    }
}
