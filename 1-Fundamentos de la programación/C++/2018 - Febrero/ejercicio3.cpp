#include <iostream>
#include <array>
using namespace std;

const int TAM=9;

typedef array<int,TAM> TFila;
typedef array<TFila,TAM>TMatriz;
typedef array<bool,TAM+1> TArray;

void reseteo_array(TArray& a){

    for(int i=1;i<TAM+1;i++){
        a[i]=false;
    }
}

bool filaok(const TMatriz& m, int f){

    TArray num_aparecidos;
    bool valida=true;
    int c=0;

    reseteo_array(num_aparecidos);

    while(c<TAM && valida){

        if(m[f][c]==0){

            c++;
        }else if((m[f][c]>=1 && m[f][c]<=9)&&(!num_aparecidos[m[f][c]])){

            num_aparecidos[m[f][c]]=true;
            c++;
        }else{

            valida=false;
        }
    }

    //return c>=TAM;
    return valida;
}

bool filasok(const TMatriz& m){
    int i=0;

    while(i<TAM && filaok(m,i)){
        i++;
    }

    return i>=TAM;
}

bool columnaok(const TMatriz& m, int c){

    TArray num_aparecidos;
    bool valida=true;
    int f=0;

    reseteo_array(num_aparecidos);

    while(f<TAM && valida){

        if(m[f][c]==0){

            f++;
        }else if((m[f][c]>=1 && m[f][c]<=9)&&(!num_aparecidos[m[f][c]])){

            num_aparecidos[m[f][c]]=true;
            f++;
        }else{

            valida=false;
        }
    }

    //return f>=TAM;
    return valida;
}

bool columnasok(const TMatriz& m){
    int i=0;

    while(i<TAM && columnaok(m,i)){
        i++;
    }

    return i>=TAM;
}

bool regionok (const TMatriz& m, int f_cen_reg, int c_cen_reg){

    TArray num_aparecidos;
    bool valida=true;
    int f=f_cen_reg-1,c;

    reseteo_array(num_aparecidos);

    while (f<=f_cen_reg+1 && valida){
        c=c_cen_reg-1;
        while (c<=c_cen_reg+1 && valida){

            if (m[f][c]==0){

                c++;
            }else if((m[f][c]>=1 && m[f][c]<=9) && !num_aparecidos[m[f][c]]){

                num_aparecidos[m[f][c]]=true;
                c++;
            }else{

                valida = false;
            }
        }
        f++;
    }

    return valida;
}

bool regionesok(const TMatriz& m){

    return regionok(m,1,1) && regionok(m,1,4) && regionok(m,1,7) && regionok(m,4,1) && regionok(m,4,4) && regionok(m,4,7) && regionok(m,7,1) && regionok(m,7,4) && regionok(m,7,7);
}

bool tableroValido(const TMatriz& m){

    return filasok(m) && columnasok(m) && regionesok(m);
}

int main() {
    TMatriz tablero1 = {{
                        {{5,3,0,0,7,0,0,0,0}},
                        {{6,0,0,1,9,5,0,0,0}},
                        {{0,9,8,0,0,0,0,6,0}},
                        {{8,0,0,0,6,0,0,0,3}},
                        {{4,0,0,8,0,3,0,0,1}},
                        {{7,0,0,0,2,0,0,0,6}},
                        {{0,6,0,0,0,0,2,8,0}},
                        {{0,0,0,4,1,9,0,0,5}},
                        {{0,0,0,0,8,0,0,7,9}}
                        }};

    TMatriz tablero2 = {{
                        {{5,3,0,0,7,0,0,0,0}},
                        {{6,0,0,1,9,5,0,0,0}},
                        {{0,9,8,0,0,0,0,6,0}},
                        {{8,0,3,0,6,0,0,0,3}},
                        {{4,0,0,8,0,3,0,0,1}},
                        {{7,0,0,0,2,0,0,0,6}},
                        {{0,6,0,0,0,0,2,8,0}},
                        {{0,0,0,4,1,9,0,0,5}},
                        {{0,0,0,0,8,0,0,7,9}}
                        }};

    TMatriz tablero3 = {{
                        {{5,3,0,0,7,0,0,0,0}},
                        {{6,0,0,1,9,5,0,0,0}},
                        {{0,9,8,0,2,0,0,6,0}},
                        {{8,0,0,0,6,0,0,0,3}},
                        {{4,0,0,8,0,3,0,0,1}},
                        {{7,0,0,0,2,0,0,0,6}},
                        {{0,6,0,0,0,0,2,8,0}},
                        {{0,0,0,4,1,9,0,0,5}},
                        {{0,0,0,0,8,0,0,7,9}}
                        }};

    TMatriz tablero4 = {{
                        {{5,3,0,0,7,0,6,0,0}},
                        {{6,0,0,1,9,5,0,0,0}},
                        {{0,9,8,0,0,0,0,6,0}},
                        {{8,0,0,0,6,0,0,0,3}},
                        {{4,0,0,8,0,3,0,0,1}},
                        {{7,0,0,0,2,0,0,0,6}},
                        {{0,6,0,0,0,0,2,8,0}},
                        {{0,0,0,4,1,9,0,0,5}},
                        {{0,0,0,0,8,0,0,7,9}}
                        }};

    if (tableroValido(tablero1)) {
        cout << "El tablero1 es un sudoku VALIDO" << endl;
    } else {
        cout << "El tablero1 es un sudoku NO VALIDO" << endl;
    }

    if (tableroValido(tablero2)) {
        cout << "El tablero2 es un sudoku VALIDO" << endl;
    } else {
        cout << "El tablero2 es un sudoku NO VALIDO" << endl;
    }

    if (tableroValido(tablero3)) {
        cout << "El tablero3 es un sudoku VALIDO" << endl;
    } else {
        cout << "El tablero3 es un sudoku NO VALIDO" << endl;
    }

    if (tableroValido(tablero4)) {
        cout << "El tablero4 es un sudoku VALIDO" << endl;
    } else {
        cout << "El tablero4 es un sudoku NO VALIDO" << endl;
    }

    return 0;
}
