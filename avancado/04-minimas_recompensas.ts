/*

Função que recebe uma lista de notas e retorna o número mínimo de recompensas que pode ser dada aos alunos

Imagine que você é um professor que acabou de corrigir o exame final de uma turma. 
Você tem uma lista de notas dos alunos no exame final em uma ordem específica (não necessariamente ordenada) 
e deseja recompensar seus alunos. 

Você decide fazer isso de maneira justa, dando-lhes recompensas arbitrárias seguindo duas regras:

1. Todos os alunos devem receber pelo menos uma recompensa.
2. Qualquer aluno deve receber estritamente mais recompensas do que um aluno adjacente (um aluno imediatamente à esquerda ou à direita) 
com uma nota menor e deve receber estritamente menos recompensas do que um aluno adjacente com uma nota maior.

*/

export function minRewards(scores: number[]): number {
    // Inicializa o array de recompensas com 1 para cada aluno
    const rewards = scores.map(_ => 1);
  
    // Percorre o array da esquerda para a direita
    for (let i = 1; i < scores.length; i++) {
      // Se a nota do aluno atual é maior que a nota do aluno anterior, aumenta sua recompensa
      if (scores[i] > scores[i - 1]) {
        rewards[i] = rewards[i - 1] + 1;
      }
    }
  
    // Percorre o array da direita para a esquerda
    for (let i = scores.length - 2; i >= 0; i--) {
      // Se a nota do aluno atual é maior que a nota do aluno seguinte, aumenta sua recompensa
      if (scores[i] > scores[i + 1]) {
        rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
      }
    }
  
    // Retorna a soma das recompensas
    return rewards.reduce((a, b) => a + b);
}