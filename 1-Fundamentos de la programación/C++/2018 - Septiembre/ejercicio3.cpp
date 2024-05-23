#include <iostream>
#include <array>
using namespace std;

const int TAM=5;

typedef array<char,TAM> TFila;
typedef array<TFila,TAM> TMatriz;

void leer_datos(int& num_gen,TMatriz& m){

    cout << "Introduce numero de generaciones: ";
    cin >> num_gen;

    cout << "Introduce la generacion inicial:" << endl;
    for (int i=0;i<TAM;i++){
        for (int j=0; j<TAM;j++){

            cin >> m[i][j];
        }
    }
}

void mostrar_gen(const TMatriz& m, int gen){

    if (gen==1){

        cout << "Generacion " << gen << " (inicial):" << endl;
    }else{

        cout << "Generacion " << gen << ":" << endl;
    }

    for(int i=0;i<TAM;i++){
        for (int j=0;j<TAM;j++){

            cout << m[i][j];
        }
        cout << endl;
    }
}

bool celdavalida(int f, int c){
    bool ok;

    ok=(f>=0 && c>=0 && f<TAM && c<TAM);

    return ok;
}

int calcula_vecinos(const TMatriz& m, int f, int c){

    int suma=0;

    for(int i=f-1;i<=f+1;i++){
        for(int j=c-1;j<=c+1;j++){
            if(celdavalida(i,j) && m[i][j]=='x' && !(f==i && c==j)){
                suma++;
            }
        }
    }

    return suma;
}

void generar_gen(const TMatriz& gen_act, TMatriz& gen_sgte){

   int vecinos;

   for(int i=0;i<TAM;i++){
       for(int j=0;j<TAM;j++){

            vecinos= calcula_vecinos(gen_act,i,j);

            if(gen_act[i][j]== 'o'){

                if(vecinos==3){

                    gen_sgte[i][j]='x';
                }else{

                    gen_sgte[i][j]='o';
                }
            }else{

                if(vecinos==2 || vecinos==3){

                    gen_sgte[i][j]='x';
                }else{

                    gen_sgte[i][j]='o';
                }
            }
       }
   }
}

void copiar_matriz(TMatriz& gen_act,const TMatriz& gen_sgte){

    for(int i=0;i<TAM;i++){
        for(int j=0; j<TAM;j++){

            gen_act[i][j]=gen_sgte[i][j];
        }
    }
}

int main(){

    TMatriz act,sgte;
    int num_gen;

    leer_datos(num_gen,act);

    mostrar_gen(act,1);

    for(int i=2;i<=num_gen;i++){

        generar_gen(act,sgte);
        mostrar_gen(sgte,i);
        copiar_matriz(act,sgte);
    }

    return 0;
}
