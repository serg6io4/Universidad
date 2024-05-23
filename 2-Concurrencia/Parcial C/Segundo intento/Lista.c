
#include <stdio.h>
#include <stdlib.h>
#include "lista.h"

void crearLista(TLista *lista) {
	*lista = NULL;
}

int buscar(TLista *lista, struct Punto p) {
	int ok = 0;
	TLista aux=*lista;
	while (aux != NULL && ok == 0) {
		if ((aux)->punto.x == p.x) {
			ok = 1;
		}
		aux = (aux)->sig;
	}
	return ok;
}

void insertarPunto(TLista *lista, struct Punto punto, int * ok) {

	TLista aux = malloc(sizeof(struct Nodo));
	aux->punto = punto;
	aux->sig = NULL;
	if (*lista == NULL) {
		*lista = aux;
		*ok = 1;
	} else {
		int encontrado = buscar(lista, punto);
		if (encontrado == 0) {
			TLista ant = *lista;
			if(ant->punto.x>aux->punto.x){
				aux->sig=ant;
				*lista=aux;
				*ok=1;
			}else{
			while (ant->sig != NULL && aux->punto.x > ant->sig->punto.x) {
				ant = ant->sig;
			}
			aux->sig = ant->sig;
			ant->sig = aux;
			*ok = 1;
			}
		} else {
			*ok = 0;
		}
	}
}
void eliminar_primero(TLista *lista) {
TLista ptr;
ptr = *lista;
*lista = (*lista)->sig;
free(ptr);
}
void eliminarPunto(TLista *lista, float x, int* ok) {

	TLista ant;
	TLista aux;
	if(*lista!=NULL){
		if((*lista)->punto.x==x){
			eliminar_primero(lista);
			*ok=1;
		}else{
			ant = *lista;
			aux=(*lista)->sig;
			while ((aux!= NULL) && (aux->punto.x!=x )) {
				ant=aux;
				aux=aux->sig;
			}
			if (aux != NULL) {
				ant->sig = (aux)->sig;
				free(aux);
				*ok = 1;
			}
		}
	}
}

void mostrarLista(TLista lista) {
	if (lista == NULL) {
		printf("La lista esta vacia");
	} else {
		while (lista != NULL) {
			printf("( %0.2f , %0.2f )", lista->punto.x, lista->punto.y);
			fflush(stdout);
			lista = (lista)->sig;
		}
	}
}

void destruir(TLista *lista) {
	TLista aux;
	while (*lista != NULL) {
		aux = *lista;
		*lista = (*lista)->sig;
		free(aux);

	}
	*lista = NULL;
}

void leePuntos(TLista *lista, char * nFichero) {
	int ok;
	crearLista(lista);
	FILE *ptr = fopen(nFichero, "rb");
	if (ptr == NULL)
		perror("No se puede abrir el fichero");
	else {
		struct Punto punto;
		while (fread(&punto, sizeof(struct Punto), 1, ptr) == 1) {
			insertarPunto(lista, punto, &ok);
		}
		fclose(ptr);
	}

}

