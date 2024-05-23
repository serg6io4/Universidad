/*
 * ejercicio1.cpp
 *
 *  Created on: 02/09/2016
 *      Alumno:
 *      Titulación:
 *      Grupo:
 *      PC usado:
 */

#include <iostream>
using namespace std;

const unsigned TAM = 4;

typedef int TMatriz[TAM][TAM];

/*  devuelve true si la matriz m es una matriz identidad
 *  o bien false si no lo es
 */
bool identidad(const TMatriz& m) {
	bool esIdentidad = true;
	unsigned fil,col;

	fil = 0;
	while ((fil < TAM) && esIdentidad) {
		col = 0;
		while ((col < TAM) && esIdentidad) {
			if ((fil == col) && (m[fil][col] != 1)) {
				esIdentidad = false;
			} else if ((fil != col) && (m[fil][col] != 0)) {
				esIdentidad = false;
			}
			col++;
		}
		fil++;
	}

	return esIdentidad;
}

int main() {
	TMatriz m =
			{ { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };

	/* Mostramos una matriz identidad */
	cout << "Mostramos el contenido de una matriz identidad:\n";
	for (unsigned f = 0; f < TAM; f++) {
		for (unsigned c = 0; c < TAM; c++) {
			cout << m[f][c] << " ";
		}
		cout << endl;
	}
	cout << endl;
	/*---------------------------------*/
	/* Probamos nuestra función identidad */
	if (identidad(m)) {
		cout << "La matriz mostrada SI es una matriz identidad";
	} else {
		cout << "La matriz mostrada NO es una matriz identidad";
	}
	cout << endl << endl;

	/* Mostramos una matriz NO identidad */
	m[0][2] = 5;
	cout << "Mostramos el contenido de una matriz NO identidad:\n";
	for (unsigned f = 0; f < TAM; f++) {
		for (unsigned c = 0; c < TAM; c++) {
			cout << m[f][c] << " ";
		}
		cout << endl;
	}
	cout << endl;
	/*---------------------------------*/
	/* Probamos nuestra función identidad */
	if (identidad(m)) {
		cout << "La matriz mostrada SI es una matriz identidad";
	} else {
		cout << "La matriz mostrada NO es una matriz identidad";
	}
	cout << endl;

	return 0;
}

