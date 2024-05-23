/*
 * ejercicio2.cpp
 *
 *  Created on: 05/02/2016
 *      Alumno:
 *      Titulación:
 *      Grupo:
 *      PC usado:
 */


#include <iostream>
using namespace std;

const int MAX = 8;

typedef int TArray[MAX];

void intercambiar(int& x, int& y){
	int aux;

	aux = x;
	x = y;
	y = aux;
}

int posicionMenor(const TArray& a, int pos) {
	int res = pos;

	for (int i = pos+1; i < MAX; i++) {
		if (a[i] < a[res]) {
			res = i;
		}
	}
	return res;
}

/* ordena los elementos del array a de menor a mayor
 * por el método de Selección
*/
void ordenar(TArray& a) {
	int posMenor;
	for (int i = 0; i < MAX-1; i++) {
		posMenor = posicionMenor(a,i);
		intercambiar(a[i],a[posMenor]);
	}

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

	/* Mostramos el array después de ordenarlo */
	cout << "El array después de ordenarlo: ";
	for (int i = 0; i < MAX; i++) {
		cout << a[i] << " ";
	}
	cout << endl;

	return 0;
}
