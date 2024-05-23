#include <stdio.h>
#include <stdlib.h>
#include "Familia.h"


int main(int argc, char *argv[])
{
	PtrPersona miFamilia=NULL;
	int ok;
	char nombreFichTexto[MAX_NOMBRE]="miFamilia.txt"; 
	char nombreFichBinario[MAX_NOMBRE]="miFamilia.dat"; 
	
	char nombreEliminada[MAX_NOMBRE]; 	
	
	setvbuf(stdout, NULL, _IONBF, 0); 
	
	//Parte 2:
	miFamilia = crearFamilia();
	
	if(miFamilia==NULL){
		printf("Familia sin miembros\n");
		exit(-1);
	}
	
	mostrarFamilia(miFamilia);
	
	ok = guardarFicheroTexto(nombreFichTexto, miFamilia);
	printf("Se han almacenado %d personas en %s\n", ok, nombreFichTexto);
	    
	ok = guardarFicheroBinario(nombreFichBinario, &miFamilia);
	printf("Se han almacenado %d personas en %s\n", ok, nombreFichBinario);
		
	printf("Introduzca el nombre (no compuesto) de la persona a eliminar: ");
	scanf("%s", nombreEliminada);		   
	eliminarPersona(&miFamilia, nombreEliminada,&ok);
	if(ok){
		printf("Se ha eliminado a %s\n", nombreEliminada);
	}   
	mostrarFamilia(miFamilia);
	   
	destruirFamilia(&miFamilia);
	   
}