#include <iostream>
#include <array>
using namespace std;

const int F=3;
const int C=3;

typedef array <int,F> TFila;
typedef array <TFila,C> TMatriz;

void leer_matriz(TMatriz& m){

    cout << "Introduce una matriz de " << F << "x" << C << ":\n";

    for (int i=0; i<F; i++){
        for (int j=0;j<C;j++){
            cin >> m[i][j];
        }
    }
}

bool celdavalida(int f, int c){
    return f>=0 && c>=0 && f<F && c<C;
}

bool mayor_igual(const TMatriz& m, int f, int c, int fvec, int cvec){
    return !(celdavalida(fvec,cvec)) || m[f][c]>= m[fvec][cvec];
}

bool es_cima(const TMatriz& m, int f, int c){
    return mayor_igual(m,f,c,f+1,c) && mayor_igual(m,f,c,f-1,c) && mayor_igual(m,f,c,f,c+1) && mayor_igual(m,f,c,f,c-1);
}

void mostrar_resultado(const TMatriz& m){

    cout << "Las cimas de la matriz son:\n";

    for(int i=0;i<F;i++){
        for(int j=0;j<C;j++){
            if(es_cima(m,i,j)){
                cout << "Fila " << i << " columna " << j << " valor " << m[i][j] << endl;
            }
        }
    }
}

int main(){

    TMatriz m;

    leer_matriz(m);
    mostrar_resultado(m);

    return 0;
}
