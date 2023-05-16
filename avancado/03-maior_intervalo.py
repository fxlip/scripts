"""

Função que recebe um array de inteiros e retorna um array de comprimento 2 
representando o maior intervalo de inteiros contido nesse array.

"""

def largestRange(array):
    # Inicializa o melhor intervalo e o maior comprimento
    best_range = []
    longest_length = 0
    
    # Cria um dicionário para armazenar os números do array
    nums = {}
    for num in array:
        nums[num] = True
    
    # Percorre cada número do array
    for num in array:
        # Se o número já foi visitado, pula para o próximo
        if not nums[num]:
            continue
        
        # Marca o número como visitado
        nums[num] = False
        
        # Inicializa o comprimento atual do intervalo
        current_length = 1
        
        # Verifica os números à esquerda e à direita do número atual
        left = num - 1
        right = num + 1
        
        # Enquanto o número à esquerda estiver no dicionário, aumenta o comprimento do intervalo e move para a esquerda
        while left in nums:
            nums[left] = False
            current_length += 1
            left -= 1
        
        # Enquanto o número à direita estiver no dicionário, aumenta o comprimento do intervalo e move para a direita
        while right in nums:
            nums[right] = False
            current_length += 1
            right += 1
        
        # Se o comprimento atual do intervalo for maior que o maior comprimento, atualiza o maior comprimento e o melhor intervalo
        if current_length > longest_length:
            longest_length = current_length
            best_range = [left + 1, right - 1]
    
    # Retorna o melhor intervalo encontrado
    return best_range