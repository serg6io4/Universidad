#include <iostream>
#include <array>
using namespace std;

const int F=2;
const int C=3;
const int FF=2*F;

typedef array<int,C> TFila;
typedef array<TFila,F> TMatriz;

//typedef array<int,FF> TFila2;
typedef array<TFila,FF> TEscala;

void introduce_datos(TMatriz& m, TEscala& t){

    cout << "Introduce una matriz M de " << F << "x" << C << ":" << endl;

//Introduce valores a la matriz M
    for(int f=0;f<F;f++){
        for(int c=0;c<C;c++){
            cin >> m[f][c];
        }
    }

//Inicializa toda la matriz T a 0
     for(int i=0;i<FF;i++){
        for(int j=0;j<C;j++){
            t[i][j]=0;
        }
     }

//filas pares matriz T
     for(int a=0;a<F;a++){
        for(int b=0;b<C;b++){
            t[2*a][b]=m[a][b];
        }
     }
}

int mediaM (const TMatriz& m){

    int suma=0;

    for(int i=0;i<F;i++){
        for(int j=0;j<C;j++){
            suma+= m[i][j];
        }
    }
    return suma/(F*C);
}

bool celda_valida(int f, int c){

    return f>=0 && c>=0 && f<FF && c<C;
}

int calcula_valor_pos(const TEscala& t, int f, int c, int media){

    int suma=0, cont=0;

    for (int i=f-1; i<=f+1;i++){
        for(int j=c-1;j<=c+1;j++){
            if(celda_valida(i,j) && !(i==f && j==c)){
                if(t[i][j]==0){
                    suma+=media;

                }else{
                    suma+=t[i][j];

                }
                cont++;
            }
        }
    }
    return suma/cont;
}

void crea_escala(TEscala& t, int mediaM){

    for(int i=1;i<FF;i+=2){
        for(int j=0;j<C;j++){
            t[i][j]=calcula_valor_pos(t,i,j,mediaM);
        }
    }

}

void muestra_escala(const TEscala& t){

    cout << "La matriz T (" << FF << "x" << C << ") es la siguiente:" << endl;

    for(int i=0;i<FF;i++){
        for(int j=0;j<C;j++){
            cout << t[i][j] << " ";
        }
        cout << endl;
    }
}

int main(){
    TMatriz m;
    TEscala t;
    int media=0;

    introduce_datos(m,t);
    media=mediaM(m);
    crea_escala(t,media);
    muestra_escala(t);

    return 0;
}
