function twoNumberSum(array, targetSum) {
    const numbersSeen = new Set(); // Inicializa um conjunto vazio

    for (const num of array) { // Itera pelos números da matriz de entrada
      const potentialMatch = targetSum - num; // Calcula o valor que, somado a num, resultaria na soma alvo
      if (numbersSeen.has(potentialMatch)) { // Verifica se já encontramos esse valor antes
        return [num, potentialMatch]; // Se sim, retorna um array com os dois números
      } else {
      numbersSeen.add(num); // Caso contrário, adiciona o número atual ao conjunto
      }
    }

    return []; // Se não encontramos dois números cuja soma é igual à soma alvo, retorna uma matriz vazia
}

// Do not edit the line below.
exports.twoNumberSum = twoNumberSum;