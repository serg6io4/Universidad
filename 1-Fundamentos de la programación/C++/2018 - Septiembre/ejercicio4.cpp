#include <iostream>
#include <array>
#include <string>
using namespace std;

const int MAX_PAL_DIST=20;

typedef array<string,MAX_PAL_DIST> TArray;

struct TDatos{

    TArray texto;
    int nelem;
};

bool letra_aparece(char c,const string& pal){

    int i=0;

    while(i<(int)pal.size() && c!= pal[i]){
        i++;
    }

    return i<(int)pal.size();
}

bool mismasletras(const string& pal1, const string& pal2){

    int i=0;

    while(i<(int)pal1.size() && letra_aparece(pal1[i],pal2)){
        i++;
    }

    return i>= (int)pal1.size();
}

bool esta(const TDatos& d,const string& pal){

    int i=0;

    while(i<d.nelem && pal!=d.texto[i]){
        i++;
    }

    return i<d.nelem;
}

void mostrar_resultado(TDatos& d){

    cout << "Las palabras que son locogramas de la primera son:" << endl;

    for(int i=0;i<d.nelem;i++){
        cout << d.texto[i] << endl;
    }
}

int main(){

    TDatos d;
    string pal, prim_pal;

    cout << "Introduce un texto (FIN para terminar): ";

    d.nelem=0;
    cin >> prim_pal;

    if (prim_pal != "FIN"){

        cin >> pal;
        while (pal != "FIN"){
            if((prim_pal.size()==pal.size()) && mismasletras(prim_pal,pal) && mismasletras(pal,prim_pal) && esta(d,pal)==false){

            d.texto[d.nelem]=pal;
            d.nelem++;
            }

            cin >> pal;
        }
    }

    mostrar_resultado(d);

    return 0;
}
