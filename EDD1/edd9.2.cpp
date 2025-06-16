#include <iostream>
#include <string>
using namespace std;

#define MAX 5

struct Fila
{
	float nos[MAX];
	int ini;
	int fim;
};

Fila* init()
{
	Fila *f = new Fila;
	f->ini = 0;
	f->fim = 0;
	return f;
}

int isEmpty(Fila *f)
{
	return (f->ini == f->fim);
}

int incrementa(int i)
{
	return (i == MAX?0:++i);
}

int count(Fila *f)
{
	int qtde = 0;
	int i = f->ini;
	while (i != f->fim)
	{
		qtde++;
		i = incrementa(i);
	}
	return qtde;
}

void print(Fila *f)
{
	cout << "---------------------" << endl;
	cout << "ELEMENTOS NA FILA: " << count(f) << endl;
	cout << "---------------------\n\n" << endl;
}

int enqueue(Fila *f, float v)
{
	int podeEnfileirar = (incrementa(f->fim) != f->ini);
	if (podeEnfileirar)
	{
		f->nos[f->fim] = v;
		f->fim = incrementa(f->fim);
	}
	return (podeEnfileirar);
}

int dequeue(Fila *f)
{
	int ret;
	if (isEmpty(f))
	{
		ret = -1;
	}
	else
	{
		ret = f->nos[f->ini];
		f->ini = incrementa(f->ini);
	}
	return ret;
}

void freeFila(Fila *f)
{
	free(f);
}

int main(int argc, char** argv)
{
	int senha = 0;
	
	Fila* senhasGeradas;
	Fila* senhasAtendidas;
	senhasGeradas = init();
	senhasAtendidas = init();
	
	bool isTerminated = false;

	while(!isTerminated) {

		int option = -1;
		cout << "\nESCOLHA UMA OPCAO: \n[0] - SAIR\n[1] - GERAR SENHA\n[2] - REALIZAR ATENDIMENTO\n" << endl;
		cout << "SENHAS PENDENTES: " << endl;
		print(senhasGeradas);
		
		cout << "DIGITE [0] - [1] - [2]: ";
		cin >> option;

		if(option != 0 && option != 1 && option != 2) {
			cout << "OPCAO INVALIDA - " << option << " - TENTE NOVAMENTE\n";
			continue;
		}

		switch(option) {
		case 0:
			if(count(senhasGeradas) == 0) {
			    cout << "\n-----------------------------------" << endl;
	            cout << "FIM DO PROGRAMA - SENHAS ATENDIDAS: " << count(senhasAtendidas) << endl;
	            cout << "-------------------------------------" << endl;
			    isTerminated = true;
			    break;
			}
			
			cout << "\nREALIZE O ATENDIMENTO DE TODAS AS SENHAS ANTES DE FINALIZAR O PROGRAMA." << endl;
			break;
		case 1:
			cout << "\nSENHA GERADA: " << (enqueue(senhasGeradas, ++senha) ? to_string(senha) : "LIMITE ATINGIDO - REALIZE O ATENDIMENTO") << "\n" << endl;
			break;
		case 2:
		    if (count(senhasGeradas) == 0) {
                cout << "\nFILA VAZIA - GERE UMA PARA COMEÇAR." << endl;
                break;
            }

            int senhaAtendida = dequeue(senhasGeradas);
            enqueue(senhasAtendidas, senhaAtendida);

            cout << "\nSENHA ATENDIDA: " << senhaAtendida << "\n" << endl;
            break;
		}
	}

	freeFila(senhasGeradas);

	return 0;
}