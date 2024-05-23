#include <iostream>
#include <array>
using namespace std;

const int TAM=7;

typedef array <int,TAM> TFila;
typedef array <TFila,TAM> TMatriz;

void inicializar_matriz(TMatriz& m){

    for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){
            m[i][j]=0;
        }
    }
}

void rellena_fila(TMatriz& m, int f, int c){

    for(int i=1;i<c;i++){
        m[f][i]=m[f][i-1]+m[f-1][i];
    }
}

void pascal(TMatriz& m){

    int f=1, c=TAM-1;

    for(int i=0;i<TAM;i++){

        m[0][i]=1;
        m[i][0]=1;
    }

    while(c>0 && f<TAM-1){

        rellena_fila(m,f,c);
        f++;
        c--;
    }
}

void muestra_triangulo(const TMatriz& m){

    for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){

            if(m[i][j]!=0){

                cout << m[i][j] << " ";
            }
        }
        cout << endl;
    }
}

int main(){

    TMatriz m;

    inicializar_matriz(m);

    cout << "El triangulo de Pascal de orden " << TAM << " seria (rotado 45 grados):" << endl;

    pascal(m);
    muestra_triangulo(m);

    return 0;
}
