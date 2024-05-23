/*Nombre: Sergio Camacho Marín
 * Titulación: Ingeniería informática
 * Grupo: 3A*/

#include <stdio.h>
#include <stdlib.h>
#include "Lista.h"

//No me ha dado errores a la hora de ejecutarlo.

/* Crea una lista vacia */
void crear(TLista *lista){
	*lista=NULL;
}

/* Muestra el contenido de la lista.
 *   - Si la lista es vacia muestra el mensaje "Lista vacia..."
 *   - Si la lista no esta vacia la muestra en el formato:
 *       <valor>:<palo> <valor>:<palo> <valor>:<palo>
 */
void mostrar(TLista lista){
	if(lista==NULL){
		printf("Lista vacia...");
	}else{
		while (lista!=NULL) {
					printf("( %i , %c )", lista->carta.valor, lista->carta.palo);
					fflush(stdout);
					lista = (lista)->sig;
				}
	}
}

/* Inserta la carta en la lista ordenada primero por el valor de forma ascendente
 * y para el mismo valor, por el palo en orden ascendente.
 */
void insertarOrdenado(TLista *lista, TCarta carta){
	TLista nuevo= malloc(sizeof(struct TNodo));
	nuevo->carta= carta;
	nuevo->sig=NULL;
	if (*lista==NULL){
		*lista=nuevo;
	}else{
		TLista ant = *lista;
		if(ant->carta.valor>nuevo->carta.valor){
			nuevo->sig=ant;
			*lista=nuevo;
		}else{
			//Miro por valor hasta llegar a su sitio
			while(nuevo->carta.valor>ant->sig->carta.valor
					&& ant->sig!=NULL){
				ant=ant->sig;
			}
			//Aquí llego al número indicado y ahora tengo que clasificar por palo
			while(ant->sig!=NULL && (ant->sig->carta.palo<nuevo->carta.palo
					&& ant->sig->carta.valor==nuevo->carta.valor)){//como ascii(B<C<E<O) y que sea el mismo valor
				ant=ant->sig;
			}
			//Aquí ya tengo el palo y el número y lo añado
			nuevo->sig = ant->sig;//inserto por la derecha
			ant->sig = nuevo;//inserto por la izquierda
		}
	}
}


/** Elimina toda la memoria dinamica reservada para la lista */
void destruir(TLista *lista){
	TLista auxiliar;//Para borrar el anterior
		while (*lista!=NULL) {
			auxiliar = *lista;
			*lista = (*lista)->sig;
			free(auxiliar);

		}
		*lista = NULL;//Tengo que dejarla a NULL
}

/**********     PARTE 2     *****************/

/* Descarta la primera carta de la lista2 que pueda ser insertada en la lista1
 * siguiendo el siguiente criterio:
 *
 * Para descartar una carta de la lista2 se hara lo siguiente:
 *   - se comprueba si en la lista1 existe una carta con el mismo valor y un
 *     palo diferente.
 *   - si existe, la carta se elimina de lista2 y se inserta en lista1 de forma que lista1
 *     siga estando ordenada.
 *
 * La funcion devuelve 1 si el jugador ha podido descartarse de alguna carta
 * y 0 en otro caso.
 *
 * Se puede suponer que las cartas de lista2 no estan en lista1.
 */
int descartar(TLista *lista1, TLista *lista2);//No me ha dado tiempo.

/* Borra una carta de la lista, teniendo en cuenta que la lista esta ordenada.
 *
 * Se puede suponer que la carta a borrar estara en la lista.
 */
void borrar(TLista *lista, TCarta carta){
	TLista ptr=*lista;
	TLista aux=ptr->sig;
	while(aux!=NULL && (aux->carta.valor!=carta.valor && aux->carta.palo!=carta.palo)){
		ptr=aux;
		aux=aux->sig;
	}
	if (aux != NULL) {
		ptr->sig = (aux)->sig;
		free(aux);
	}

}

/* Suma y devuelve el valor de todas las cartas de la lista, independientemente
 *  de su palo.
 */
int sumar(TLista lista){
	int suma=0;
	while(lista!=NULL){
		suma+=lista->carta.valor;
		lista=(lista)->sig;
	}
	return suma;
}
