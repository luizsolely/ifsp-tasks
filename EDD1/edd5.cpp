#include <iostream>
#include <string>
#include <ctime>

using namespace std;

class Data {
private:
    int dia;
    int mes;
    int ano;

public:
    Data() : dia(0), mes(0), ano(0) {}

    Data(int dia, int mes, int ano) : dia(dia), mes(mes), ano(ano) {}

    int getDia() const {
        return dia;
    }

    void setDia(int dia) {
        this->dia = dia;
    }

    int getMes() const {
        return mes;
    }

    void setMes(int mes) {
        this->mes = mes;
    }

    int getAno() const {
        return ano;
    }

    void setAno(int ano) {
        this->ano = ano;
    }
};

class Contato {
private:
    string email;
    string nome;
    string telefone;
    Data dtnasc;

public:
    Contato() : email(""), nome(""), telefone(""), dtnasc() {}

    Contato(const string& email, const string& nome, const string& telefone, const Data& dtnasc)
        : email(email), nome(nome), telefone(telefone), dtnasc(dtnasc) {}

    string getEmail() const {
        return email;
    }

    void setEmail(const string& email) {
        this->email = email;
    }

    string getNome() const {
        return nome;
    }

    void setNome(const string& nome) {
        this->nome = nome;
    }

    string getTelefone() const {
        return telefone;
    }

    void setTelefone(const string& telefone) {
        this->telefone = telefone;
    }

    Data getDtnasc() const {
        return dtnasc;
    }

    void setDtnasc(const Data& dtnasc) {
        this->dtnasc = dtnasc;
    }

    int idade() const {
        time_t t = time(nullptr);
        tm* tempoLocal = localtime(&t);
        int anoAtual = tempoLocal->tm_year + 1900;
        return anoAtual - dtnasc.getAno();
    }
};

int main() {
    Contato contatos[5];

    for (int i = 0; i < 5; i++) {
        cout << "\nCadastro do Contato #" << (i + 1) << endl;

        string nome, email, telefone;
        int dia, mes, ano;

        cout << "Nome: ";
        getline(cin, nome);

        cout << "Email: ";
        getline(cin, email);

        cout << "Telefone: ";
        getline(cin, telefone);

        cout << "Dia de nascimento: ";
        cin >> dia;
        cout << "Mês de nascimento: ";
        cin >> mes;
        cout << "Ano de nascimento: ";
        cin >> ano;
        cin.ignore();

        Data dataNascimento(dia, mes, ano);
        contatos[i] = Contato(email, nome, telefone, dataNascimento);
    }

    cout << "\n--- Contatos Cadastrados ---\n";
    for (int i = 0; i < 5; i++) {
        cout << "Nome: " << contatos[i].getNome() << endl;
        cout << "Email: " << contatos[i].getEmail() << endl;
        cout << "Telefone: " << contatos[i].getTelefone() << endl;
        cout << "Idade: " << contatos[i].idade() << " anos" << endl;
        cout << "----------------------------\n";
    }

    return 0;
}
