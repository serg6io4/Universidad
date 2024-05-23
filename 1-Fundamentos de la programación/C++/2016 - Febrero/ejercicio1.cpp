/*
 * ejercicio1.cpp
 *
 *  Created on: 05/02/2016
 *      Alumno:
 *      Titulación:
 *      Grupo:
 *      PC usado:
 */


#include <iostream>
using namespace std;

const int FILAS = 2;
const int COLUMNAS = 4;
const int NO_VALIDA = -1;

typedef int TMatriz[FILAS][COLUMNAS];

/* devuelve la posición (fil y col) de la matriz m donde está elem
*  o bien -1 (para fil y col) si elem no está en m
*/
void buscar(const TMatriz& m, int elem, int& fil, int& col) {

}

int main() {
	TMatriz m = {{2, 7, 12, 89},
		     {5, 2, 9, 10}};
	int fil,col;
	/* Mostramos la matriz proporcionada */
	cout << "Mostramos el contenido de la matriz proporcionada:\n";
	for (int f = 0; f < FILAS; f++) {
		for (int c = 0; c < COLUMNAS; c++) {
			cout << m[f][c] << " ";
		}
		cout << endl;
	}
	cout << endl;
	/*---------------------------------*/
	/* Probamos nuestra función buscar */
	/* primera prueba */
	buscar(m, 10, fil, col);
	cout << "10";
	if (fil == -1) {
		cout << " no se encuentra en la matriz";
	} else {
		cout << " está en la fila " << fil << ", columna " << col << " de la matriz";
	}
	cout << endl;
	/* segunda prueba */
	buscar(m, 2, fil, col);
	cout << "2";
	if (fil == -1) {
		cout << " no se encuentra en la matriz";
	} else {
		cout << " está en la fila " << fil << ", columna " << col << " de la matriz";
	}
	cout << endl;
	/* tercera prueba */
	buscar(m, 27, fil, col);
	cout << "27";
	if (fil == -1) {
		cout << " no se encuentra en la matriz";
	} else {
		cout << " está en la fila " << fil << ", columna " << col << " de la matriz";
	}
	cout << endl;

	return 0;
}