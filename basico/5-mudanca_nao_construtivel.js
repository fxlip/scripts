/*
Função que encontra a menor quantia de dinheiro que não pode ser formada usando as moedas que você possui. 
As moedas são representadas por um array de inteiros positivos e podem ter valores repetidos.

Exemplo = [1, 2, 5]
Combinações possíveis:
 - Com a moeda de 1, você pode formar a quantia 1.
 - Com as moedas de 1 e 2, você pode formar as quantias 1, 2 e 3.
 - Com todas as moedas (1, 2 e 5), você pode formar as quantias 1, 2, 3, 5, 6 e 7.

No entanto, não é possível formar a quantia 4 usando as moedas disponíveis. 
Pois é a menor quantia de dinheiro que não pode ser criada com essas moedas.

Se não possuir nenhuma moeda a menor quantia de dinheiro que não pode ser criada é 1.
Já que não há moedas disponíveis para formar qualquer quantia.
*/

function nonConstructibleChange(coins) {
    coins.sort((a, b) => a - b); // Ordena a matriz de moedas em ordem crescente
  
    let currentChange = 0; // Inicializa um contador para a quantidade de troco que pode ser construído
  
    for (const coin of coins) {
      // Se a moeda atual for maior que o troco construído até o momento + 1,
      // significa que não podemos criar o troco "currentChange + 1"
      if (coin > currentChange + 1) {
        return currentChange + 1;
      }
  
      // Atualiza a quantidade de troco que pode ser construído, adicionando o valor da moeda atual
      currentChange += coin;
    }
  
    // Se todas as moedas foram percorridas e ainda não encontramos o troco não construível,
    // significa que podemos criar todos os trocos até "currentChange", então retornamos "currentChange + 1"
    return currentChange + 1;
}

exports.nonConstructibleChange = nonConstructibleChange;
  