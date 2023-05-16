"""

Função que recebe um array bidimensional de tamanho n x m (que pode ser quadrado quando n == m) 
e retorna um array unidimensional com todos os elementos do array em ordem de zigue-zague.

A ordem de zigue-zague começa no canto superior esquerdo do array bidimensional, 
desce um elemento e prossegue em um padrão de zigue-zague até o canto inferior direito.

"""

def zigzagTraverse(array):
    # Inicializa as variáveis de altura e largura do array
    height = len(array) - 1
    width = len(array[0]) - 1
    
    # Inicializa o array de resultado e as variáveis de linha e coluna
    result = []
    row, col = 0, 0
    
    # Inicializa a variável de direção (para baixo ou para cima)
    goingDown = True
    
    # Enquanto não estiver fora dos limites do array
    while not isOutOfBounds(row, col, height, width):
        # Adiciona o elemento atual ao array de resultado
        result.append(array[row][col])
        
        # Se estiver indo para baixo
        if goingDown:
            # Se estiver na primeira coluna ou na última linha, muda a direção
            if col == 0 or row == height:
                goingDown = False
                # Se estiver na última linha, move para a direita
                if row == height:
                    col += 1
                # Senão, move para baixo
                else:
                    row += 1
            # Senão, move para baixo e para a esquerda
            else:
                row += 1
                col -= 1
        # Se estiver indo para cima
        else:
            # Se estiver na primeira linha ou na última coluna, muda a direção
            if row == 0 or col == width:
                goingDown = True
                # Se estiver na última coluna, move para baixo
                if col == width:
                    row += 1
                # Senão, move para a direita
                else:
                    col += 1
            # Senão, move para cima e para a direita
            else:
                row -= 1
                col += 1
    
    # Retorna o array de resultado
    return result

# Função auxiliar para verificar se está fora dos limites do array
def isOutOfBounds(row, col, height, width):
    return row < 0 or row > height or col < 0 or col > width