"""

Função que recebe um array não vazio de inteiros distintos e um inteiro representando uma soma alvo. 

A função encontra todos os quadrupletos no array que somam a soma alvo;
e retornar um array bidimensional de todos esses quadrupletos, sem ordem específica.

Se nenhum grupo de quatro números somar a soma alvo, a função retorna um array vazio."

"""

def fourNumberSum(array, targetSum):
    # Inicializa um dicionário para armazenar pares de soma e um array para armazenar os quadrupletos
    allPairSums = {}
    quadruplets = []
    
    # Itera pelos elementos do array
    for i in range(1, len(array) - 1):
        # Verifica pares à direita do elemento atual que somam com o elemento atual
        for j in range(i + 1, len(array)):
            currentSum = array[i] + array[j]
            difference = targetSum - currentSum
            if difference in allPairSums:
                # Adiciona os quadrupletos encontrados no array de resultados
                for pair in allPairSums[difference]:
                    quadruplets.append(pair + [array[i], array[j]])
        
        # Verifica pares à esquerda do elemento atual que somam com o elemento atual
        for k in range(0, i):
            currentSum = array[i] + array[k]
            if currentSum not in allPairSums:
                allPairSums[currentSum] = [[array[k], array[i]]]
            else:
                allPairSums[currentSum].append([array[k], array[i]])
    
    return quadruplets