#include <iostream>
#include <string>
using namespace std;

struct Funcionario {
    int prontuario;
    string nome;
    double salario;
    Funcionario* prox;
};

class ListaFuncionarios {
private:
    Funcionario* inicio;

    bool prontuarioExiste(int prontuario) const {
        Funcionario* atual = inicio;
        while (atual != nullptr) {
            if (atual->prontuario == prontuario) return true;
            atual = atual->prox;
        }
        return false;
    }

public:
    ListaFuncionarios() {
        inicio = nullptr;
    }

    ~ListaFuncionarios() {
        Funcionario* atual = inicio;
        while (atual != nullptr) {
            Funcionario* temp = atual;
            atual = atual->prox;
            delete temp;
        }
    }

    void incluir(int prontuario, const string& nome, double salario) {
        if (prontuarioExiste(prontuario)) {
            cout << "Erro: prontuário já cadastrado!" << endl;
            return;
        }

        Funcionario* novo = new Funcionario{prontuario, nome, salario, inicio};
        inicio = novo;

        cout << "Funcionário incluído com sucesso!" << endl;
    }

    void excluir(int prontuario) {
        Funcionario* atual = inicio;
        Funcionario* anterior = nullptr;

        while (atual != nullptr && atual->prontuario != prontuario) {
            anterior = atual;
            atual = atual->prox;
        }

        if (atual == nullptr) {
            cout << "Funcionário não encontrado." << endl;
            return;
        }

        if (anterior == nullptr) {
            inicio = atual->prox;
        } else {
            anterior->prox = atual->prox;
        }

        delete atual;
        cout << "Funcionário excluído com sucesso!" << endl;
    }

    void pesquisar(int prontuario) const {
        Funcionario* atual = inicio;
        while (atual != nullptr) {
            if (atual->prontuario == prontuario) {
                cout << "Funcionário encontrado:" << endl;
                imprimirFuncionario(*atual);
                return;
            }
            atual = atual->prox;
        }
        cout << "Funcionário não encontrado." << endl;
    }

    void listar() const {
        if (inicio == nullptr) {
            cout << "Nenhum funcionário cadastrado." << endl;
            return;
        }

        double totalSalarios = 0.0;
        Funcionario* atual = inicio;

        cout << "\n==== LISTA DE FUNCIONÁRIOS ====" << endl;
        while (atual != nullptr) {
            imprimirFuncionario(*atual);
            totalSalarios += atual->salario;
            atual = atual->prox;
        }

        cout << "Total de salários: R$ " << totalSalarios << endl;
    }

private:
    void imprimirFuncionario(const Funcionario& f) const {
        cout << "Prontuário: " << f.prontuario << endl;
        cout << "Nome      : " << f.nome << endl;
        cout << "Salário   : R$ " << f.salario << endl;
        cout << "---------------------------" << endl;
    }
};

int main() {
    ListaFuncionarios sistema;
    int opcao;

    do {
        cout << "\n=== MENU ===" << endl;
        cout << "0 - Sair" << endl;
        cout << "1 - Incluir funcionário" << endl;
        cout << "2 - Excluir funcionário" << endl;
        cout << "3 - Pesquisar funcionário" << endl;
        cout << "4 - Listar funcionários" << endl;
        cout << "Escolha: ";
        cin >> opcao;

        if (cin.fail()) {
            cin.clear();
            cin.ignore(10000, '\n');
            cout << "Entrada inválida!" << endl;
            continue;
        }

        switch (opcao) {
            case 0:
                break;

            case 1: {
                int prontuario;
                string nome;
                double salario;

                cout << "Digite o prontuário: ";
                cin >> prontuario;
                cin.ignore(); // limpa o '\n'

                cout << "Digite o nome: ";
                getline(cin, nome);

                cout << "Digite o salário: ";
                cin >> salario;

                sistema.incluir(prontuario, nome, salario);
                break;
            }

            case 2: {
                int prontuario;
                cout << "Digite o prontuário a excluir: ";
                cin >> prontuario;
                sistema.excluir(prontuario);
                break;
            }

            case 3: {
                int prontuario;
                cout << "Digite o prontuário para pesquisa: ";
                cin >> prontuario;
                sistema.pesquisar(prontuario);
                break;
            }

            case 4:
                sistema.listar();
                break;

            default:
                cout << "Opção inválida!" << endl;
        }

    } while (opcao != 0);

    return 0;
}
