/*
 * ejercicio2.cpp
 *
 *  Created on: 05/02/2016
 *      Alumno:
 *      Titulaci�n:
 *      Grupo:
 *      PC usado:
 */


#include <iostream>
using namespace std;

const int MAX = 8;

typedef int TArray[MAX];

/* ordena los elementos del array a de menor a mayor
 * por el m�todo de Selecci�n
*/
void ordenar(TArray& a) {


}

int main() {
	TArray a = { 2, 7, 12, 89, 5, 2, 9, 10 };
	
	/* Mostramos el array antes de ordenarlo */
	cout << "El array antes de ordenarlo: ";
	for (int i = 0; i < MAX; i++) {
		cout << a[i] << " ";
	}
	cout << endl;
	
	/* ordenamos el array */
	ordenar(a);
	
	/* Mostramos el array despu�s de ordenarlo */
	cout << "El array despu�s de ordenarlo: ";
	for (int i = 0; i < MAX; i++) {
		cout << a[i] << " ";
	}
	cout << endl;

	return 0;
}