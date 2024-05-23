/*
 * Lista.h
 *
 */

#ifndef LISTA_H_
#define LISTA_H_

struct TCarta{
	char palo; //'B', 'C', 'E', 'O'
	int valor; //entre 1 y 12
};
typedef struct TCarta TCarta;

typedef struct TNodo *TLista;
struct TNodo{
	TCarta carta;
	TLista sig;
};


/**********     PARTE 1     *****************/

/* Crea una lista vacia */
void crear(TLista *lista);

/* Muestra el contenido de la lista.
 *   - Si la lista es vacia muestra el mensaje "Lista vacia..."
 *   - Si la lista no esta vacia la muestra en el formato:
 *       <valor>:<palo> <valor>:<palo> <valor>:<palo>
 */
void mostrar(TLista lista);

/* Inserta la carta en la lista ordenada primero por el valor de forma ascendente
 * y para el mismo valor, por el palo en orden ascendente.
 */
void insertarOrdenado(TLista *lista, TCarta carta);


/** Elimina toda la memoria dinamica reservada para la lista */
void destruir(TLista *lista);

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
int descartar(TLista *lista1, TLista *lista2);

/* Borra una carta de la lista, teniendo en cuenta que la lista esta ordenada.
 *
 * Se puede suponer que la carta a borrar estara en la lista.
 */
void borrar(TLista *lista, TCarta carta);

/* Suma y devuelve el valor de todas las cartas de la lista, independientemente
 *  de su palo.
 */
int sumar(TLista lista);


#endif /* LISTA_H_ */
