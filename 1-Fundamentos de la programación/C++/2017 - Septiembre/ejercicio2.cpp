#include <iostream>
#include <array>
using namespace std;

const int TAM=10;

typedef array<int,TAM> TArray;

int mayorLongitud(const TArray& a){

    int ant=0,longitud=0,mayor_long=0;

    for(int i=0;i<TAM;i++){
        if(ant<=a[i]){
            longitud++;
        }else{
            if(longitud>mayor_long){
                mayor_long=longitud;
            }
            longitud=1;
        }
        ant=a[i];
    }

    if(longitud>mayor_long){
        mayor_long=longitud;
    }

    return mayor_long;
}

void leer_array(TArray& a){

    cout << "Introduce " << TAM << " numeros naturales: ";

    for(int i=0;i<TAM;i++){

        cin>>a[i];
    }
}

int main(){

    TArray a;

    leer_array(a);

    cout << "La longitud de la mayor sub-sucesion es: " << mayorLongitud(a) << endl;


    return 0;
}
