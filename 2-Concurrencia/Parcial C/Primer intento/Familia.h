#ifndef FAMILIA_H
#define FAMILIA_H

#define MAX_NOMBRE 20 //longitud maxima de los nombres

typedef struct Persona* PtrPersona;

struct Persona{
	char nombre[MAX_NOMBRE];
	int edad;
	PtrPersona p1; //progenitor1
	PtrPersona p2; //progenitor2
	PtrPersona sig;
};


//Una familia es una lista enlazada de personas en el orden en el que se insertan los datos

//Parte 1: obligatoria para aprobar

/* Crea una familia con los datos que un usuario introduce por teclado:
 *  - nombre de la persona: si el nombre es "*"" se se da por finalizada la lectura de datos.
 *  - edad
 *  - nombre del progenitor 1/2: si el nombre es "-"" o no se encuentra aun ese nombre en la familia,
 *                               se asume que no tiene progenitor 1/2.
 */
PtrPersona crearFamilia();

/* Busca en la familia una persona con el nombre dado.
 * Devuelve una referencia a los datos de la persona en la lista.
 * Si la persona no forma parte de la familia, esta referencia valdrá NULL. 
 */
void buscarPersona (PtrPersona familia, const char *nombre, PtrPersona *persona);

/* Muestra por pantalla la información de los miembros de la familia.
 * Para cada persona eso incluy nombre, edad, nombre de los progenitores si existen.
 */
void mostrarFamilia(PtrPersona familia);

/* Elimina todos los miembros de una familia, liberando correctamente la memoria de la estructura*/
void destruirFamilia(PtrPersona *familia);


//Parte 2: opcional - hasta notable
/* Elimina a la persona cuyo nombre coincide con el que se pasa como parametro.
 * Si no hay una persona con ese nombre, la familia no se modifica.
 * Si existe una persona con ese nombre, ademas de eliminarlo de la lista, actualiza correctamente
 * los progenitores del resto de personas que siguen en la familia.
 * ok almacena si se ha borrado la persona de la familia.
 */
void eliminarPersona(PtrPersona *familia, char *nombre, int *ok);

/* Guarda en un fichero de texto la informacion de la familia. El alumno elige el
 * formato en el que se almacena dicha informacion.
 * Esta funcion devuelve el numero de personas que se han guardado en el fichero.
 */
int guardarFicheroTexto(char *nombreFichero, PtrPersona familia);

/* Guarda en un fichero de binario la informacion de la familia. El alumno elige el
 * formato en el que se almacena dicha informacion, pero debe ser compatible con
 * el formato utilizado en la funcion cargarFicheroBinario.
 * Esta funcion devuelve el numero de personas que se han guardado en el fichero.
 */
int guardarFicheroBinario(char *nombreFichero, const PtrPersona *familia);

//Parte3: opcional - sobresaliente - matricula -- 

/* Crea una nueva familia utilizando la informacion leida de un fichero binario.
 * El fichero almacena la informacion con el formato que produce la funcion guardarFicheroBinario.
 * Esta funcion devuelve en nPersonas el numero de personas que se han guardado en el fichero.
 */
PtrPersona cargarFicheroBinario(char *nombreFichero, int *nPersonas);

/* Muestra por pantalla el arbol de ascendentes de la persona con el nombre dado.
 * Si no hay personas con ese nombre, se muestra un mensaje.
 * Si hay una persona con ese nombre, la raiz de dicho arbol sera esta persona.
 */
void mostrarArbolAscendentes(PtrPersona familia, char *nombre);


#endif /*FAMILIA_H*/
