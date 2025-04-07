#include <iostream>
#include <windows.h>
#include <string>

using namespace std;

void gotoxy(short x, short y) {
    COORD coord = {x, y};
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}

void espera(int ms) {
    Sleep(ms);
}

int main() {
    string mensagem;

    cout << "Digite a mensagem: ";
    getline(cin, mensagem);

    int largura_console = 80;
    int x_inicio = (largura_console - mensagem.length()) / 2;

    gotoxy(x_inicio, 5);
    cout << mensagem;

    espera(1000);

    for (int i = 0; i < mensagem.length(); i++) {
        char letra = mensagem[i];

        for (int y = 6; y <= 20; y++) {
            gotoxy(x_inicio + i, y - 1);
            cout << " ";

            gotoxy(x_inicio + i, y);
            cout << letra;

            espera(30);
        }
    }

    gotoxy(0, 22);
    cout << endl;

    return 0;
}

