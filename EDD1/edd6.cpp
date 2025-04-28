#include <iostream>
#include <string>
#include <ctime>
#include <sstream>
#include <vector>

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

    string formatarCitacao() {
        size_t pos = this->nome.find_last_of(" ");
    
        if (pos != string::npos) {
            string sobrenome = this->nome.substr(pos + 1);
            string nome = this->nome.substr(0, pos);
            stringstream ss(nome);
            string nomeFormatado;
            string inicial;
        
            while (ss >> inicial) {
                nomeFormatado += inicial.substr(0, 1) + ". ";
            }

            if (!nomeFormatado.empty()) {
                nomeFormatado.pop_back();
            }
        
            return sobrenome + ", " + nomeFormatado;
        }
    
        return this->nome;
    }
};

int main() {
    Contato contatos[3];

    for (int i = 0; i < 3; i++) {
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
        cout << "M s de nascimento: ";
        cin >> mes;
        cout << "Ano de nascimento: ";
        cin >> ano;
        cin.ignore();

        Data dataNascimento(dia, mes, ano);
        contatos[i] = Contato(email, nome, telefone, dataNascimento);
    }

    int mediaGeral = 0;
    int maioresDeIdade = 0;
    
    for (int i = 0; i < 3; i++) {
        mediaGeral += contatos[i].idade();
    }
    
    mediaGeral /= 3;
    
    for (int i = 0; i < 3; i++) {
        if (contatos[i].idade() >= 18) {
            maioresDeIdade++;
        }
    }

    cout << endl << "Media Geral: " << mediaGeral << endl;
    
    for (int i = 0; i < 3; i++) {
        if (contatos[i].idade() > mediaGeral) {
            cout << "Contato cuja idade e maior que a media: " << contatos[i].formatarCitacao() << endl;
        }
    }
    
    cout << "Qtd. de contatos maiores de idade: " << maioresDeIdade << endl;

    int idadeMaxima = contatos[0].idade();
    vector<int> indicesMaisVelhos;
    
    for (int i = 0; i < 3; i++) {
        if (contatos[i].idade() > idadeMaxima) {
            idadeMaxima = contatos[i].idade();
            indicesMaisVelhos.clear();
            indicesMaisVelhos.push_back(i);
        } else if (contatos[i].idade() == idadeMaxima) {
            indicesMaisVelhos.push_back(i);
        }
    }

    cout << "Contatos mais velhos: " << endl;
    for (int i : indicesMaisVelhos) {
        cout << "Nome: " << contatos[i].getNome() << endl;
        cout << "Email: " << contatos[i].getEmail() << endl;
        cout << "Telefone: " << contatos[i].getTelefone() << endl;
        cout << endl;
    }
    
    return 0;
}
