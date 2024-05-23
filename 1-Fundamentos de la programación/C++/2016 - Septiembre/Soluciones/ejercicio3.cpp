/*
 * ejercicio3.cpp
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


unsigned comparar(const string& cad2, const string& cad1, unsigned pos) {
	unsigned res = 0, contCad2;

	contCad2 = 0;
	while ((contCad2 < cad2.size()) && (pos < cad1.size())) {
		if (cad2[contCad2] == cad1[pos]) {
			res++;
		}
		contCad2++;
		pos++;
	}

	return res;
}

void desplazar(const string& cad1, const string& cad2,
					unsigned& despl, unsigned& numCar) {
	unsigned coincidencias;
	despl = 0;
	numCar = 0;
	for (unsigned i = 0; i < cad1.size(); i++) {
		coincidencias = comparar(cad2,cad1,i);
		if (coincidencias > numCar) {
			numCar = coincidencias;
			despl = i;
		}
	}
}


int main() {
	unsigned desplazamiento, numCaracteres;
	string cadena1, cadena2;

	cout << "Introduzca cadena1 y cadena2: ";
	cin >> cadena1 >> cadena2;
	desplazar(cadena1,cadena2,desplazamiento,numCaracteres);
	cout << "El desplazamiento menor es: " << desplazamiento << endl;
	cout << "El número de caracteres es: " << numCaracteres << endl;

	return 0;
}




