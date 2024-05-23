#include <iostream>
#include <array>
#include <string>
using namespace std;

const int MAX_PAL_DIST=20;

struct TRegistro{
    string palabra;
    int prim_pos;
    int ult_pos;
    /*Datos que se mostraran al final del programa. Contiene:
        La palabra del texto
        Las posiciones donde aparece por primera y ultima vez en el texto*/
};

typedef array<TRegistro, MAX_PAL_DIST> TArray;

struct TDatos{
    TArray a;
    int nelem;
    /* Datos necesarios para llevar conteo. Contiene:
        Array de tipo TRegistro
        nelem: numero de palabras introducidas en el array*/
};

int busca_indice(const TDatos& datos,const string& palabra){
    int i=0;

    while ((palabra!= datos.a[i].palabra) && (i< datos.nelem)){
        i++;
    }
    /* Esta funcion devuelve el valor de un indice:
        Devolvera i=nelem si ha recorrido todas las posiciones ocupadas del array y no coincide
            ninguna con la introducida de teclado
        Devolvera otro numero si la palabra introducida coincide con alguna palabra del array*/
    return i;
}

void mostrar_resultado(const TDatos& datos){

    cout << "Palabras y posiciones primera y ultima:\n";

    for(int i=0; i<datos.nelem;i++){

        cout<< datos.a[i].palabra << " "
            << datos.a[i].prim_pos << " "
            << datos.a[i].ult_pos << endl;
    }
}

int main(){
    TDatos datos;
    string pal;
    int indpalabra, postexto=1;
    /* "datos" contiene un array de tipo TRegistro y nelem
        "pal" son las palabras que se introducen de teclado
        "indpalabra" se usa para la funcion busca_indice, que su procedimiento esta comentado
        "postexto" se usa para levar la cuenta de la posicion de la palabra en el texto.
            Se inicializa a 1 porque la primera palabra esta en la posicion 1 si o si*/

    cout << "Introduce un texto (la palabra FIN termina): ";

    datos.nelem=0;

    cin >> pal;
    while(pal != "FIN"){
        indpalabra= busca_indice(datos,pal);

        if(indpalabra<datos.nelem){

            datos.a[indpalabra].ult_pos= postexto;
            /* Si el indice es menor quiere decir que la palabra ya esta en el array,
                por lo que se actualiza la ultima posicion de la palabra*/
        }else{

            datos.a[datos.nelem].palabra=pal;
            datos.a[datos.nelem].prim_pos=postexto;
            datos.a[datos.nelem].ult_pos=postexto;

            datos.nelem++;

            /*Si el indice devuelto es mayor o igual que el numero de elementos almacenado en el array,
                se ingresa la palabra y las posiciones primera y ultima (como es la primera vez que se ve
                    esa palabra la primera y ultima posicion es la misma)
                Se incrementa el numero de elementos porque se acaba de introducir uno nuevo*/
        }
        cin >> pal; //Se lee una nueva palabra para la siguiente iteracion del bucle
        postexto++; //Se incrementa "postexto" porque se "avanza" en el texto
    }

    mostrar_resultado(datos); //Muestra la solucion por pantalla

    return 0;
}
