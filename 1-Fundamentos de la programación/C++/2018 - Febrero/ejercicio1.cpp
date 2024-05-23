#include <iostream>
using namespace std;

const unsigned TAM = 9;

typedef unsigned TArray[TAM];

int repeticiones(const TArray& a, int pos){

    int res=1;

    for(int i= pos+1;i<(int)TAM;i++){
        if(a[pos]==a[i]){
            res++;
        }
    }

    return res;
}

// funcion que calcula el valor dominante del array a
int valorDominante(const TArray& a) {

    int res=-1, pos=0;

    while(pos<=(int)TAM/2 && repeticiones(a,pos)<=(int)TAM/2){
        pos++;
    }

    if(pos<=(int)TAM/2){
        res=a[pos];
    }

    return res;
}

int main() {
    TArray a1 = {3,4,3,2,3,1,3,3,1},
           a2 = {4,4,3,2,3,1,3,3,1},
           a3 = {1,3,2,1,4,4,4,4,4};

    cout << "El elemento dominante del primer array es: "
         << valorDominante(a1) << endl;
    cout << "El elemento dominante del segundo array es: "
         << valorDominante(a2) << endl;
    cout << "El elemento dominante del tercer array es: "
         << valorDominante(a3) << endl;

    return 0;
}
