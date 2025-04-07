#include <iostream>
#include <fstream>

using namespace std;

int main() {
    ifstream arquivo("nomes.txt");
    string linha;

    if (!arquivo) {
        cout << "Erro ao abrir o arquivo." << endl;
        return 1;
    }

    while (getline(arquivo, linha)) {
        string palavras[20];
        int total = 0;

        string palavra = "";
        for (int i = 0; i < linha.length(); i++) {
            if (linha[i] == ' ') {
                if (palavra != "") {
                    palavras[total++] = palavra;
                    palavra = "";
                }
            } else {
                palavra += linha[i];
            }
        }
        if (palavra != "") {
            palavras[total++] = palavra;
        }

        string sobrenome = palavras[total - 1];
        for (int i = 0; i < sobrenome.length(); i++) {
            cout << (char)toupper(sobrenome[i]);
        }
        cout << ", ";

        for (int i = 0; i < total - 1; i++) {
            cout << palavras[i][0] << ". ";
        }

        cout << endl;
    }

    arquivo.close();
    return 0;
}
