#include <iostream>
#include <array>
#include <string>
using namespace std;

const int MAX_PAL_DIST=20;

struct TRegistro{

    string pal;
    int suma_car;

};

typedef array<TRegistro,MAX_PAL_DIST> TArray;

struct TDatos{

    TArray a;
    int nelem;
};

int suma_caracteres(const string& pal){
    int suma=0;

    for (int i=0;i<(int)pal.size();i++){
        suma+=pal[i];
    }

    return suma;
}

bool esta(const string& pal, const TDatos& d){

    int i=0;

    while(i<d.nelem && pal!=d.a[i].pal){
        i++;
    }

    return i<d.nelem;
}

void muestra_resultado(const TDatos& d, int suma_patron){

    cout << "Las palabras que cumplen la condicion son:" << endl;

    for(int i=0;i<d.nelem;i++){
        if(d.a[i].suma_car==suma_patron){
            cout << d.a[i].pal << " ";
        }
    }
}

int main(){

    TDatos d;
    string patron,pal;
    int suma_patron;

    d.nelem=0;

    cout << "Introduce el patron: ";
    cin >> patron;

    if(patron!="FIN"){
        suma_patron= suma_caracteres(patron);

        cout << "Introduce el texto (FIN para terminar):\n";
        cin >> pal;

        while (pal!= "FIN" && d.nelem<MAX_PAL_DIST){
            if(!esta(pal,d)){

                d.a[d.nelem].pal= pal;
                d.a[d.nelem].suma_car= suma_caracteres(pal);
                d.nelem++;
            }
            cin >> pal;
        }
    }

    muestra_resultado(d,suma_patron);

    return 0;
}
