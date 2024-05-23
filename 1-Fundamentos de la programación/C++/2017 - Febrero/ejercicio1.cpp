/*
 * ejercicio1.cpp
 *
 *  Created on: 03/02/2017
 *      Alumno:
 *      Titulación:
 *      Grupo:
 *      PC usado:
 */

#include <iostream>
#include <cmath>
using namespace std;

const unsigned TAM = 10;

typedef unsigned TArray[TAM];

bool esPrimo(unsigned num){

    bool primo=true;

    for(int i=2;i<=(int)sqrt(num);i++){
        if(num%i==0){
            primo=false;
        }
    }

    return primo;
}

/*  devuelve el mayor número primo almacenado en el array
 *  o bien 0 si no hay ningún número primo
 */
unsigned mayorPrimo(const TArray& a) {

    int res=0;

    for(int i=0; i<(int)TAM;i++){
        if(esPrimo(a[i])&&((int)a[i]>res)){
            res=a[i];
        }
    }

    return res;
}

// muestra por pantalla el contenido del array
void escribir(const TArray& a) {
    for (unsigned i = 0; i < TAM; i++) {
		cout << a[i] << " ";
	}
	cout << endl;

}

int main() {
	TArray a1 = {6,4,12,0,8,9,46,15,21,12}, a2 = {8,22,3,6,2,7,56,11,5,9};
	unsigned mayor;

	/* Mostramos el array 1 */
	cout << "El contenido del array 1 de prueba es: ";
	escribir(a1);

	/* Probamos nuestra función mayorPrimo */
	mayor = mayorPrimo(a1);
	if (mayor == 0) {
		cout << "En el array no hay ningun primo\n";
	} else {
		cout << "El mayor primo del array es: " << mayor << endl;
	}
	cout << endl << endl;

	/* Mostramos el array 2 */
	cout << "El contenido del array 2 de prueba es: ";
	escribir(a2);

	/* Probamos nuestra función mayorPrimo */
	mayor = mayorPrimo(a2);
	if (mayor == 0) {
		cout << "En el array no hay ningun primo\n";
	} else {
		cout << "El mayor primo del array es: " << mayor << endl;
	}
	cout << endl << endl;


	return 0;
}

