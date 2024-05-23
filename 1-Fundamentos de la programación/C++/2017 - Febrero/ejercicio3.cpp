#include <iostream>
#include <array>
#include <string>
using namespace std;

const int MAX_PAL_DIST=20;

typedef array<string,MAX_PAL_DIST> TArray;

struct TDatos{
    TArray a;
    int nelem;
};

bool esta(const string& pal, const TDatos& d){

    int i=0;

    while(i<d.nelem && pal!=d.a[i]){
        i++;
    }
    return i<d.nelem;
}

bool letras_ordenadas(const string& pal){

    int i=0;

    while(pal[i]<=pal[i+1] && i<(int)pal.size()-1){
        i++;
    }

    return i>=(int)pal.size()-1;
}

void muestra_resultado(const TDatos& d){

    cout << "Las palabras cuyos caracteres estan ordenados son:" << endl;

    for(int i=0;i<d.nelem;i++){
        cout << d.a[i] << " ";
    }
}

int main(){

    TDatos d;
    string pal;

    cout << "Introduce el texto (FIN para terminar):" << endl;
    cin>>pal;

    d.nelem=0;

    while (pal!="FIN" && d.nelem<MAX_PAL_DIST){
        if(!esta(pal,d) && letras_ordenadas(pal)){
            d.a[d.nelem]=pal;
            d.nelem++;
        }
        cin >> pal;
    }

    muestra_resultado(d);

    return 0;
}
