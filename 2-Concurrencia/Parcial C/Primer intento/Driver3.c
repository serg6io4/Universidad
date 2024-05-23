#include <stdio.h>
#include <stdlib.h>
#include "Familia.h"

int main(int argc, char *argv[])
{
	PtrPersona miFamilia= NULL;	
	int nPersonas;
	char nombreFichBinario[MAX_NOMBRE]="miFamilia.dat"; 
	
	char nombrePersona[MAX_NOMBRE];

	 
	setvbuf(stdout, NULL, _IONBF, 0); 
	
	//Parte 3:
	
	miFamilia = cargarFicheroBinario(nombreFichBinario, &nPersonas);
	printf("Se han cargado %d personas del fichero %s", nPersonas, nombreFichBinario);
	
	mostrarFamilia(miFamilia);
	
	printf("Introduzca el nombre (no compuesto) de la persona para generar su árbol: ");
	scanf("%s", nombrePersona);		 
	mostrarArbolAscendentes(miFamilia, nombrePersona);
	
	destruirFamilia(&miFamilia);
	
}