#include <iostream>
#include <iomanip>

using namespace std;

#define LIN 15
#define COL 40

void reserveSeat(bool seats[LIN][COL]) {
    int lin, col;
    
    do {
        cout << "DIGITE A FILEIRA [1-15] (DIGITE 0 PARA SAIR): " << endl;
        cin >> lin;
        if (lin < 0 || lin > 15) {
            cout << "FILEIRA INVÁLIDA. TENTE NOVAMENTE." << endl;
        }
        if (lin == 0) {
            return;
        }
    } while (lin < 1 || lin > 15);

    do {
        cout << "DIGITE A POLTRONA [1-40] (DIGITE 0 PARA SAIR): " << endl;
        cin >> col;
        if (col < 1 || col > 40) {
            cout << "POLTRONA INVÁLIDA. TENTE NOVAMENTE." << endl;
        }
        if (col == 0) {
            return;
        }
    } while (col < 1 || col > 40);

    if (seats[lin - 1][col - 1] == false) {
        seats[lin - 1][col - 1] = true;
        cout << " --- RESERVA REALIZADA COM SUCESSO --- " << endl;
    } else {
        cout << "POLTRONA ESCOLHIDA EM USO. TENTE NOVAMENTE" << endl;
    }
}


void showSeats(bool arr[LIN][COL]) {
    cout << " --- MAPA DE OCUPAÇÃO --- " << endl;
    for (int i = 0; i < LIN; i++) {
        cout << setw(2) << i+1 << " ";
        for (int j = 0; j < COL; j++) {
            cout << (arr[i][j] ? "#" : ".") << " ";
        }
        cout << endl;
    }
    cout << "'.' representa lugar vago" << endl;
    cout << "'#' representa lugar ocupado" << endl;
}

double calculateBilling(bool arr[LIN][COL]) {

    double faturamento = 0.0;
    
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 40; j++) {
            if(arr[i][j] == true) {
                faturamento += 50.0;
            }
        }
    }
    
    for (int i = 5; i < 11; i++) {
        for (int j = 0; j < 40; j++) {
            if(arr[i][j] == true) {
                faturamento += 30.0;
            }
        }
    }
    
    for (int i = 11; i < 16; i++) {
        for (int j = 0; j < 40; j++) {
            if(arr[i][j] == true) {
                faturamento += 15.0;
            }
        }
    }
    
    return faturamento;
    
}

int main()
{
	bool seats[LIN][COL];
	double faturamento = 0.0;
	int action = 0;
	int lin = 0;
	int col = 0;

	for (int i = 0; i < LIN; i++) {
		for (int j = 0; j < COL; j++) {
			seats[i][j] = false;
		}
	}

	do {

		cout << "  -- PROJETO BILHETERIA -- " << endl;
		cout << "  -- OPÇÃO 0 - FINALIZAR" << endl;
		cout << "  -- OPÇÃO 1 - RESERVAR" << endl;
		cout << "  -- OPÇÃO 2 - MAPA" << endl;
		cout << "  -- OPÇÃO 3 - FATURAMENTO" << endl;

		cin >> action;

		switch(action) {
		case 0:
			cout << "ENCERRANDO O PROGRAMA" << endl;
			return 0;
			break;
		case 1:
            reserveSeat(seats);
			break;
		case 2:
			showSeats(seats);
			break;
		case 3:
			cout << setw(25) << "FATURAMENTO TOTAL: R$" << fixed << setprecision(2) << calculateBilling(seats) << endl;
			break;
		default:
			cout << "OPÇÃO INVÁLIDA [0, 1, 2, 3]:" << endl;
		}

	} while (true);

	return 0;
}

