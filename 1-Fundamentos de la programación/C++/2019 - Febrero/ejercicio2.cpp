#include <iostream>
#include <string>
#include <array>
using namespace std;

const int TAM = 6;
typedef array<char, TAM> TFila;
typedef array<TFila, TAM> TMatriz;

void buscar_cifrado(const TMatriz& m, char caracter, int& f, int& c){

    for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){
            if(caracter==m[i][j]){

                f=i;
                c=j;
            }
        }
    }
}

void cifrar(const TMatriz& m,const string& texto, string& cifrado){

    int f1,f2,c1,c2;
    cifrado="";

    for(int i=0;i<int(texto.size()-1);i+=2){

        buscar_cifrado(m,texto[i],f1,c1);
        buscar_cifrado(m,texto[i+1],f2,c2);
        cifrado+=m[f1][f2];
        cifrado+=m[c1][c2];
    }
}

int main() {
    TMatriz clave = {{ {{'p','k','a','f','5','v'}},
                       {{'e','o','9','t','y','0'}},
                       {{'s','3','z','7','d','j'}},
                       {{'r','b','n','u','m','1'}},
                       {{'2','w','4','h','8','g'}},
                       {{'c','x','6','q','i','l'}},
                    }};
    string texto = "holayadios";
    string cifrado;

    cifrar(clave,texto,cifrado);

    cout << "El texto cifrado es: " << cifrado << endl;

    return 0;
}
