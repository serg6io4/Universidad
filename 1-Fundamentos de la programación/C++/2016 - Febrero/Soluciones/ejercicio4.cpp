/*
 * ejercicio4.cpp
 *
 *  Created on: 05/02/2016
 *      Alumno:
 *      Titulaci�n:
 *      Grupo:
 *      PC usado:
 */


#include <iostream>
#include <string>

using namespace std;


unsigned buscar(char c, const string& cad) {
	unsigned pos = 0;

	while ((pos < cad.size()) && (cad[pos] != c)) {
		pos++;
	}

	return pos;
}

void coincidencias(const string& cad1, const string& cad2,
					unsigned& cPos, unsigned& cNoPos) {
	unsigned tope, pos;
	string auxCad1 = cad1, auxCad2 = cad2; // para poder modificarse

	// primero contamos coincidencias en la misma posici�n
	cPos = 0;
	if (auxCad1.size() < auxCad2.size()) {
		tope = auxCad1.size();
	} else {
		tope = auxCad2.size();
	}
	for (unsigned i = 0; i < tope; i++) {
		if (auxCad1[i] == auxCad2[i]) {
			cPos++;
			auxCad1[i] = ' '; // para no tratarlo m�s
			auxCad2[i] = ' '; // para no tratarlo m�s
		}
	}

	// ahora contamos coincidencias en distinta posici�n
	cNoPos = 0;
	for (unsigned i = 0; i < auxCad2.size(); i++) {
		if (auxCad2[i] != ' ') {
			pos = buscar(auxCad2[i],auxCad1);
			if (pos < auxCad1.size()) {
				cNoPos++;
				auxCad1[pos] = ' '; // para no tratarlo m�s
			}
		}
	}
}


int main() {
	unsigned coincidenciasPosicion, coincidenciasNoPosicion;
	string cadena1, cadena2;

	cout << "Introduzca cadena1 y cadena2: ";
	cin >> cadena1 >> cadena2;
	coincidencias(cadena1,cadena2,coincidenciasPosicion,coincidenciasNoPosicion);
	cout << "El n�mero de caracteres coincidentes en la misma posici�n son: "
		 << coincidenciasPosicion << endl;
	cout << "El n�mero de caracteres coincidentes en distinta posici�n son: "
			 << coincidenciasNoPosicion << endl;

	return 0;
}


