/*
 * ejercicio4.cpp
 *
 *  Created on: 02/09/2016
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

void codificar(const string& pal, string& palCodif) {
	palCodif = "";

	for (unsigned i = 0; i < pal.size(); i++) {
		switch (pal[i]) {
			case 'A':  	palCodif += "APA";
						break;
			case 'E':  	palCodif += "EPE";
						break;
			case 'I':  	palCodif += "IPI";
						break;
			case 'O':  	palCodif += "OPO";
						break;
			case 'U':  	palCodif += "UPU";
						break;
			default: 	palCodif += pal[i];
						break;
		}
	}

}

bool estaAlmacenada(const string& pal, const TDatos& datos) {
	unsigned i = 0;

	while ((i < datos.nPal) && (pal != datos.pal[i])) {
		i++;
	}

	return i < datos.nPal;
}


void escribir(const TDatos& datos) {
	cout << "Las palabras codificadas son:\n";
	for (unsigned i = 0; i < datos.nPal; i++) {
		cout << datos.pal[i] << " ";
	}
}

int main()
{
	TDatos datos;
	string pal, palCodif;

	cout << "Introduzca el texto (FIN para terminar):\n";

	datos.nPal = 0;

	cin >> pal;

	while (pal != "FIN") {
		codificar(pal,palCodif);
		if (!estaAlmacenada(palCodif,datos)) {
			datos.pal[datos.nPal] = palCodif;
			datos.nPal++;
		}
		cin >> pal;
	}

	escribir(datos);

    return 0;
}






