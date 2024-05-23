#include <iostream>
#include <array>
#include <string>
using namespace std;

const int TAM_CAR=5;
const int MAX_PAL_DIST=20;

struct TRegistro{

    string pal;
    int num_car;
};

typedef array<TRegistro,MAX_PAL_DIST> TArray;

struct TDatos{

    TArray a;
    int nelem;
};

bool aparece(const string& patron, char c, int pos){

    int i=pos;

    while(i<(int)patron.size() && c!= patron[i]){
        i++;
    }

    return i<(int)patron.size();

}

bool letras_rep(const string& patron){

    bool repet=false;
    int i=0;

    while(i<(int)patron.size()&& !repet){
        if(aparece(patron,patron[i],i+1)){
            repet=true;
        }
        i++;
    }

    return repet;

}

bool esta(const string& pal,const TDatos& d){

    int i=0;

    while(i<d.nelem && d.a[i].pal != pal){
        i++;
    }

    return i<d.nelem;
}

int comun(const string& patron, const string& pal){

    int res=0;

    for(int i=0; i<(int)patron.size();i++){
        if(aparece(pal,patron[i],0)){
            res++;
        }
    }

    return res;
}

void muestra_resultado(const TDatos& d){

    cout << "Palabras y numero de letras que coinciden con el patron:" << endl;

    for(int i=0;i<d.nelem;i++){
        cout << d.a[i].pal << " " << d.a[i].num_car << endl;
    }
}

int main(){

    TDatos d;
    string patron,pal;

    do{
        cout << "Introduce un patron (long = " << TAM_CAR << ", sin letras repetidas): ";
        cin >> patron;
    }while(patron.size() != TAM_CAR || letras_rep(patron));

    d.nelem=0;
    cout << "Introduce un texto (FIN para terminar):\n";
    cin >> pal;

    while(pal!="FIN" && d.nelem<MAX_PAL_DIST){
        if(!esta(pal,d)){

            d.a[d.nelem].pal= pal;
            d.a[d.nelem].num_car= comun(patron,pal);
            d.nelem++;
        }
        cin >> pal;
    }

    muestra_resultado(d);

    return 0;
}
