/*
 * ejercicio3.cpp
 *
 *  Created on: 05/02/2016
 *      Alumno:
 *      Titulación:
 *      Grupo:
 *      PC usado:
 */


#include <iostream>
#include <string>

using namespace std;

const unsigned MAX_PAL_DIST = 20;

typedef string TPalabras[MAX_PAL_DIST];

struct TDatos {
	TPalabras pal;
	unsigned nPal;
};

unsigned buscarPosicion(char c, const string& pal, unsigned pos) {
	unsigned cont = pos;

	while ((cont < pal.size()) && (c != pal[cont])) {
		cont++;
	}

	return cont;
}

bool contieneRelativo(const string& pal, const string& patron) {
	unsigned i = 0, pos = 0;
	bool seguir = true;

	while ( (i < patron.size()) && seguir) {
		pos = buscarPosicion(patron[i],pal,pos);
		if (pos < pal.size()) {
			pos++;
			i++;
		} else {
			seguir = false;
		}
	}

	return i >= patron.size();
}

bool estaAlmacenada(const string& pal, const TDatos& datos) {
	unsigned i = 0;

	while ((i < datos.nPal) && (pal != datos.pal[i])) {
		i++;
	}

	return i < datos.nPal;
}


void escribir(const string& patron, const TDatos& datos) {
	cout << "Las palabras que contienen a " << patron << " de forma relativa son:\n";
	for (unsigned i = 0; i < datos.nPal; i++) {
		cout << datos.pal[i] << " ";
	}
}

int main()
{
	TDatos datos;
	string pal, patron;

	cout << "Introduzca el patrón: ";

	cin >> patron;

	cout << "Introduzca el texto (FIN para terminar):\n";

	datos.nPal = 0;

	cin >> pal;

	while (pal != "FIN") {
		if ((contieneRelativo(pal,patron)) && (!estaAlmacenada(pal,datos))) {
			datos.pal[datos.nPal] = pal;
			datos.nPal++;
		}
		cin >> pal;
	}

	escribir(patron,datos);

    return 0;
}


