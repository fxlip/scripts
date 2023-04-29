/*

Dia de tirar fotos na escola local e você é o fotógrafo responsável por tirar as fotos das turmas. 
A turma que você vai fotografar tem um número par de alunos.
Todos esses alunos estão usando camisas vermelhas ou azuis. 
Na verdade, exatamente metade da turma está usando camisas vermelhas e a outra metade está usando camisas azuis. 

Você é responsável por organizar os alunos em duas fileiras antes de tirar a foto. 

Cada fileira deve conter o mesmo número de alunos e deve seguir as seguintes diretrizes:

- Todos os alunos usando camisas vermelhas devem estar na mesma fileira.
- Todos os alunos usando camisas azuis devem estar na mesma fileira.
- Cada aluno na fileira de trás deve ser estritamente mais alto do que o aluno diretamente à sua frente na fileira da frente.

São dois arrays de entrada: 
Um contendo as alturas de todos os alunos com camisas vermelhas;
Outro contendo as alturas de todos os alunos com camisas azuis. 

Esses arrays sempre terão o mesmo comprimento e cada altura será um número inteiro positivo. 

Supondo que cada turma tem pelo menos 2 alunos;
Essa função retorna se uma foto da turma que segue as diretrizes declaradas pode ser tirada.

*/
import java.util.*;

class Program {

    public boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        // Ordena os arrays de alturas em ordem decrescente
        Collections.sort(redShirtHeights, Collections.reverseOrder());
        Collections.sort(blueShirtHeights, Collections.reverseOrder());
        
        // Verifica qual cor de camisa está na fileira da frente
        String shirtColorInFirstRow = redShirtHeights.get(0) < blueShirtHeights.get(0) ? "RED" : "BLUE";
        
        // Percorre os arrays de alturas
        for (int i = 0; i < redShirtHeights.size(); i++) {
            // Compara as alturas dos alunos com base na cor da camisa na fileira da frente
            if (shirtColorInFirstRow == "RED") {
                if (redShirtHeights.get(i) >= blueShirtHeights.get(i)) {
                    return false;
                }
            } else {
                if (blueShirtHeights.get(i) >= redShirtHeights.get(i)) {
                    return false;
                }
            }
        }
        
        // Se todas as condições forem atendidas, retorna true
        return true;
    }
}

