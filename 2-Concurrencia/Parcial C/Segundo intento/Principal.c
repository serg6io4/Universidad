/*
 ============================================================================
 Name        : Principal.c -- v4
 Author      :
 Version     :
 Copyright   : Your copyright notice
 Description : Programa principal para examen PSC Junio 2020
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include "Lista.h"

/* Dado un fichero f, ya abierto en modo binario, leer una línea de ese fichero
 * y guardar las cartas en la lista que se pasa como parámetro.
 *
 * El formato de cada línea es:
 * <num_total> <num_B> <valorB1>...<valorBn> <num_C>...<num_E>...<num_O>
 * <valorO1>...<valorOn>
 *
 * Ejemplo de lista con las 4 cartas 7:B 7:E 8:E 3:O
 *  4 1 7 0 2 7 8 1 3
 * Debe suponerse que la lista se ha creado previamente. Los datos se
 * guardaran en la lista de forma ordenada, primero por el valor ascendente y
 * luego, para el mismo valor, por el palo ascendente.
 * En los dos casos el orden es ascendente.
 */
void leerLinea(FILE *f, TLista *lista);


/* Dado el nombre de un fichero de texto (parámetro nombre) que contiene
 * tres líneas con cartas, lee del fichero esas tres líneas. El contenido
 * de la primera línea lo guarda en mazo, el de la segunda en jugador1 y
 * el de la tercera en jugador2.
 *
* El formato de cada línea es:
 * <num_total> <num_B> <valorB1>...<valorBn> <num_C>...<num_E>...<num_O>
 * <valorO1>...<valorOn>
 *
 * Ejemplo de lista con las 4 cartas 7:B 7:E 8:E 3:O
 *  4 1 7 0 2 7 8 1 3
 *
 * Las líneas se almacenarán en las listas correspondiente de forma ordenada,
 * primero por valor ascendente y luego por palo ascendente.
 */
void crearDesdeFichero(char *nombre, TLista *mazo, TLista *jugador1, TLista *jugador2);



int main(void) {
	setvbuf(stdout,NULL,_IONBF,0);
	TLista mazo, jugador1, jugador2;
	int d1,d2;

	//Crea las listas mazo, jugador1 y jugador2
	crear(&mazo);
	crear(&jugador1);
	crear(&jugador2);

	/* PARTE 1 y 2 */
	TCarta carta;

	carta.palo = 'O';
	carta.valor = 3;
	insertarOrdenado(&mazo,carta);

	carta.palo = 'O';
	carta.valor = 1;
	insertarOrdenado(&mazo,carta);

	carta.palo = 'O';
	carta.valor = 2;
	insertarOrdenado(&mazo,carta);

	carta.palo = 'O';
	carta.valor = 4;
	insertarOrdenado(&mazo,carta);

	carta.palo = 'B';
	carta.valor = 4;
	insertarOrdenado(&mazo,carta);

	carta.palo = 'C';
	carta.valor = 3;
	insertarOrdenado(&mazo,carta);

	carta.palo = 'B';
	carta.valor = 6;
	insertarOrdenado(&mazo,carta);

	carta.palo = 'C';
	carta.valor = 2;
	insertarOrdenado(&mazo,carta);

	carta.palo = 'E';
	carta.valor = 1;
	insertarOrdenado(&mazo,carta);

	carta.palo = 'C';
	carta.valor = 1;
	insertarOrdenado(&mazo,carta);

	carta.palo = 'O';
	carta.valor = 10;
	insertarOrdenado(&mazo,carta);

	carta.palo = 'B';
	carta.valor = 1;
	insertarOrdenado(&jugador2,carta);

	carta.palo = 'B';
	carta.valor = 3;
	insertarOrdenado(&jugador2,carta);

	carta.palo = 'C';
	carta.valor = 4;
	insertarOrdenado(&jugador2,carta);

	carta.palo = 'E';
	carta.valor = 5;
	insertarOrdenado(&jugador2,carta);

	carta.palo = 'O';
	carta.valor = 5;
	insertarOrdenado(&jugador1,carta);

	carta.palo = 'E';
	carta.valor = 4;
	insertarOrdenado(&jugador1,carta);

	carta.palo = 'O';
	carta.valor = 8;
	insertarOrdenado(&jugador1,carta);

	carta.palo = 'O';
	carta.valor = 12;
	insertarOrdenado(&jugador1,carta);


	/*PARTE3: Descomentar para cargar los datos desde fichero y comentar el codigo anterior*/
	//crearDesdeFichero("cartas.dat", &mazo, &jugador1, &jugador2);

	/*printf("Mazo Inicial: ");
	mostrar(mazo);
	printf("Cartas con las que juega Jugador 1: ");
	mostrar(jugador1);
	printf("Cartas con las que juega Jugador 2: ");
	mostrar(jugador2);
	printf("\n");

	printf("---------------------------------------------------\n");
	printf("Los jugadores empiezan a descartarse cartas:\n\n");
	do{
		d1 = descartar(&mazo,&jugador1);
		if (d1 > 0) {
			printf("Jugador 1 descarta cartas. Le quedan por descartar: ");
			mostrar(jugador1);
		}
		d2 = descartar(&mazo,&jugador2);
		if (d2 > 0) {
			printf("Jugador2 descarta cartas. Le quedan por descartar: ");
			mostrar(jugador2);
		}
	}while(d1 > 0 || d2 >0);
	printf("\nLos jugadores ya no pueden descartarse mas cartas\n");
	printf("---------------------------------------------------\n\n");

	printf("Mazo despues de descartar: ");
	mostrar(mazo);
	printf("Jugador 1 despues de descartar todas las cartas posibles: ");
	mostrar(jugador1);
	printf("Jugador 2 despues de descartar todas las cartas posibles: ");
	mostrar(jugador2);

	int suma1 = sumar(jugador1);
	int suma2 = sumar(jugador2);

	if (suma1 < suma2){
		printf("Jugador 1 gana");
	}else if (suma2 < suma1){
		printf("Jugador 2 gana");
	}else{
		printf("Empate");
	}*/
	destruir(&mazo);
	destruir(&jugador1);
	destruir(&jugador2);

	return 0;
}


/* Salida PARTE 1 2 y 3 juntas
Mazo Inicial: 1:C 1:E 1:O 2:C 2:O 3:C 3:O 4:B 4:O 6:B 10:O
Cartas con las que juega Jugador 1: 4:E 5:O 8:O 12:O
Cartas con las que juega Jugador 2: 1:B 3:B 4:C 5:E

---------------------------------------------------
Los jugadores empiezan a descartarse cartas:

Jugador 1 descarta cartas. Le quedan por descartar: 5:O 8:O 12:O
Jugador2 descarta cartas. Le quedan por descartar: 3:B 4:C 5:E
Jugador2 descarta cartas. Le quedan por descartar: 4:C 5:E
Jugador2 descarta cartas. Le quedan por descartar: 5:E

Los jugadores ya no pueden descartarse mas cartas
---------------------------------------------------

Mazo despues de descartar: 1:B 1:C 1:E 1:O 2:C 2:O 3:B 3:C 3:O 4:B 4:C 4:E 4:O 6:B 10:O
Jugador 1 despues de descartar todas las cartas posibles: 5:O 8:O 12:O
Jugador 2 despues de descartar todas las cartas posibles: 5:E
Jugador 2 gana
*/
