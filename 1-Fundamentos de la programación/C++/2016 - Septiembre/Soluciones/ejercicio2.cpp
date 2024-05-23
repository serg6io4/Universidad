/*
 * ejercicio2.cpp
 *
 *  Created on: 02/09/2016
 *      Alumno:
 *      Titulación:
 *      Grupo:
 *      PC usado:
 */

#include <iostream>

using namespace std;

const unsigned MAX = 10;

typedef unsigned TElementos[MAX];

struct Conjunto {
	TElementos elementos;
	unsigned numElem;
};

void leer(Conjunto& c) {

	do {
		cout << "Introduzca el numero de elementos a leer (<= " << MAX << "): ";
		cin >> c.numElem;
	} while (c.numElem > MAX);

	cout << "Introduzca " << c.numElem << " numeros naturales diferentes: ";
	for (unsigned i = 0; i < c.numElem; i++) {
		cin >> c.elementos[i];
	}
}

void escribir(const Conjunto& c) {

	cout << "Los elementos del conjunto son: ";
	for (unsigned i = 0; i < c.numElem; i++) {
		cout << c.elementos[i] << " ";
	}
	cout << endl;
}

bool esta(unsigned elem, const Conjunto& c) {
	unsigned cont = 0;

	while ((cont < c.numElem) && (elem != c.elementos[cont])) {
		cont++;
	}

	return (cont < c.numElem);
}

void calcularInterseccion(const Conjunto& c1, const Conjunto& c2,
		Conjunto& res) {

	res.numElem = 0;
	for (unsigned i = 0; i < c1.numElem; i++) {
		if (esta(c1.elementos[i], c2)) {
			res.elementos[res.numElem] = c1.elementos[i];
			res.numElem++;
		}
	}

}

void calcularUnion(const Conjunto& c1, const Conjunto& c2, Conjunto& res,
		bool& exito) {
	unsigned cont;

	res.numElem = 0;
	for (unsigned i = 0; i < c1.numElem; i++) {
		res.elementos[res.numElem] = c1.elementos[i];
		res.numElem++;
	}

	cont = 0;
	while ((cont < c2.numElem) && (res.numElem < MAX)) {
		if (!esta(c2.elementos[cont], c1)) {
			res.elementos[res.numElem] = c2.elementos[cont];
			res.numElem++;
		}
		cont++;
	}

	exito = cont >= c2.numElem;

}

int main() {

	Conjunto c1, c2, c3, c4;
	bool exito;

	cout << "Primer conjunto:\n";
	leer(c1);

	cout << "\nSegundo conjunto:\n";
	leer(c2);

	calcularInterseccion(c1, c2, c3);
	cout << "\nInterseccion:\n";
	escribir(c3);

	calcularUnion(c1, c2, c4, exito);
	if (exito) {
		cout << "\nUnion:\n";
		escribir(c4);
	} else {
		cout << "\nLa Union no se ha podido realizar\n";
	}

	return 0;

}
