#include <iostream>
#include <array>
using namespace std;

const int N=3;
const int M=4;

typedef array <int,M> TFila;
typedef array <TFila,N> TMatriz;

struct TRegistro{

    int num;
    int veces;
};

typedef array <TRegistro,N*M> TArray;

struct TDatos{

    TArray a;
    int nelem;
};

void leer_datos(TMatriz& m, int& k){

    cout << "Introduce k: ";
    cin >> k;

    cout << "Introduce la matriz " << N << "x" << M << " (por filas):" << endl;
    for (int i=0;i<N;i++){
        for(int j=0;j<M;j++){

            cin >> m[i][j];
        }
    }
}

int busca_pos(int elem_m,const TDatos& d){

    int i=0;

    while((elem_m!=d.a[i].num)&&(i<d.nelem)){
        i++;
    }

    return i;
}

void frecuencias(const TMatriz& m, TDatos& d){

    int pos;
    d.nelem=0;

    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){

            pos= busca_pos(m[i][j],d);
            if(pos<d.nelem){

                d.a[pos].veces++;
            }else{

                d.a[pos].num= m[i][j];
                d.a[pos].veces=1;
                d.nelem++;
            }
        }
    }
}

int busca_mayor_frec(const TDatos& d){

    int pos=0;

    for(int i=1;i<d.nelem;i++){
        if(d.a[i].veces>d.a[pos].veces){
            pos=i;
        }
    }

    return pos;
}

void escribir_resultado(int k,TDatos& d){

    int ind_may_frec; //indice mayor frecuencia

    if (k>d.nelem){

        k=d.nelem;
    }
    cout << "Los valores que mas se repiten son: ";
    for(int i=0;i<k;i++){

        ind_may_frec=busca_mayor_frec(d);
        d.a[ind_may_frec].veces=-1;
        cout << d.a[ind_may_frec].num << " ";
    }

}

int main(){

    TMatriz m;
    int k;
    TDatos datos;

    leer_datos(m,k);
    frecuencias(m,datos);
    escribir_resultado(k,datos);

    return 0;
}
