#include <iostream>
using namespace std;

struct No {
    int dado;
    No* ant;
};

struct PilhaLista {
    No* topo;
};

PilhaLista* initLista() {
    PilhaLista* p = new PilhaLista();
    p->topo = NULL;
    return p;
}

int isEmptyLista(PilhaLista* p) {
    return (p->topo == NULL);
}

void pushLista(PilhaLista* p, int v) {
    No* no = new No;
    no->dado = v;
    no->ant = p->topo;
    p->topo = no;
}

int popLista(PilhaLista* p) {
    if (isEmptyLista(p)) return -1;
    No* no = p->topo;
    int v = no->dado;
    p->topo = no->ant;
    delete no;
    return v;
}

struct PilhaVetor {
    int dados[30];
    int topo;
};

PilhaVetor* initVetor() {
    PilhaVetor* p = new PilhaVetor();
    p->topo = -1;
    return p;
}

int isEmptyVetor(PilhaVetor* p) {
    return (p->topo == -1);
}

void pushVetor(PilhaVetor* p, int v) {
    if (p->topo < 29)
        p->dados[++p->topo] = v;
}

int popVetor(PilhaVetor* p) {
    if (isEmptyVetor(p)) return -1;
    return p->dados[p->topo--];
}

int main() {
    PilhaLista* impares = initLista();
    PilhaVetor* pares = initVetor();

    int atual, anterior = -2147483648;

    cout << "Digite 30 numeros inteiros em ordem crescente:\n";
    for (int i = 0; i < 30; i++) {
        do {
            cout << "Numero " << i + 1 << ": ";
            cin >> atual;
            if (atual <= anterior)
                cout << "Erro: precisa ser maior que o anterior!\n";
        } while (atual <= anterior);
        anterior = atual;

        if (atual % 2 == 0)
            pushVetor(pares, atual);
        else
            pushLista(impares, atual);
    }

    cout << "\n--- Pares (vetor) em ordem decrescente ---\n";
    while (!isEmptyVetor(pares))
        cout << popVetor(pares) << " ";

    cout << "\n\n--- Impares (lista encadeada) em ordem decrescente ---\n";
    while (!isEmptyLista(impares))
        cout << popLista(impares) << " ";

    cout << "\n";
    return 0;
}