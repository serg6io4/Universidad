#include <iostream>
#include <array>
using namespace std;

const int TAM=10;

typedef array<int,TAM> TArray;

struct TLista{
    TArray num;
    int pos_num;
};

bool esta(int valor, const TLista& l){
    bool ok;
    int i=0;

    while(i<l.pos_num && valor!=l.num[i]){
        i++;
    }

    ok=i<l.pos_num;

    return ok;
}

void leer_lista(TLista& l, int num_lista){

    int valor;

    cout << "Introduce Lista " << num_lista << ": ";
    cin >> valor;
    l.pos_num=0;

    while(valor!=0 && l.pos_num<TAM){
        if (esta(valor,l)==false){

            l.num[l.pos_num]=valor;
            l.pos_num++;
        }
        if(l.pos_num<TAM){

            cin >> valor;
        }
    }
}

void mostrar_lista(const TLista& l, int num_lista){

    cout << "Lista " << num_lista << ": ";

    for(int i=0;i<l.pos_num;i++){
        cout << l.num[i] << " ";
    }

    cout << endl;
}

void trios_numeros(const TLista& l1, const TLista& l2, const TLista& l3){

    cout << "Los trios de numeros son:" << endl;

    for(int i=0;i<l1.pos_num;i++){
        for(int j=0;j<l2.pos_num;j++){
            for (int k=0;k<l3.pos_num;k++){

                if(l1.num[i]+l2.num[j]==l3.num[k]){
                    cout << l1.num[i] << " " << l2.num[j] << " " << l3.num[k] << endl;
                }
            }
        }
    }
}

int main(){
    TLista lista1, lista2, lista3;

    leer_lista(lista1,1);
    leer_lista(lista2,2);
    leer_lista(lista3,3);

    mostrar_lista(lista1,1);
    mostrar_lista(lista2,2);
    mostrar_lista(lista3,3);

    trios_numeros(lista1,lista2,lista3);

    return 0;
}
