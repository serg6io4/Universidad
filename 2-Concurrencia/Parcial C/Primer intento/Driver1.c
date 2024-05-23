#include <stdio.h>
#include <stdlib.h>
#include "Familia.h"


int main(int argc, char *argv[])
{
	PtrPersona miFamilia=NULL;
	PtrPersona personaBuscada;
	char nombreBuscada[MAX_NOMBRE]; 
	
	setvbuf(stdout, NULL, _IONBF, 0); 
	
	//Parte 1:
	miFamilia = crearFamilia();
	
	if(miFamilia==NULL){
		printf("Familia sin miembros\n");
		exit(-1);
	}
	
	mostrarFamilia(miFamilia);
	
	printf("Introduzca el nombre (no compuesto) de la persona a buscar: ");
	scanf("%s", nombreBuscada);
	buscarPersona(miFamilia, nombreBuscada, &personaBuscada); 
	if(personaBuscada!=NULL)
	{
		printf("%s es parte de la familia y su edad es %d\n", personaBuscada->nombre, personaBuscada->edad);
			
	}else{
		printf("%s no es parte de la familia\n", nombreBuscada);
	}
	destruirFamilia(&miFamilia);
}