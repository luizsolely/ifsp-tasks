#include <iostream>
#include <string>
#include <algorithm>
#include <cctype>

using namespace std;

bool ehPalindromo(string texto) {
    string filtrado = "";

    for (int i = 0; i < texto.length(); i++) {
        if (!isspace(texto[i])) {
            filtrado += tolower(texto[i]);
        }
    }

    string reverso = filtrado;
    reverse(reverso.begin(), reverso.end());

    return filtrado == reverso;
}

int main() {
    string mensagem;

    cout << "Digite uma mensagem: ";
    getline(cin, mensagem);

    if (ehPalindromo(mensagem)) {
        cout << "É um palíndromo!" << endl;
    } else {
        cout << "Não é um palíndromo." << endl;
    }

    return 0;
}
