/********************************************************************
 * Estructuras de Datos. 2º Curso. ETSI Informática. UMA
 * PRACTICA 4ª. Ejercicio 12.c de la tercera relación
 *              Implementar el TAD Bolsa en java
 *
 * (completa y sustituye los siguientes datos)
 * Titulación: Grado en Ingeniería [Informática | del Software | de Computadores].
 * Alumno: APELLIDOS, NOMBRE
 * Fecha de entrega:  DIA | MES | AÑO
 ********************************************************************
 */

package dataStructures.bag;

import java.util.Arrays;

public class SortedArrayBag<T extends Comparable<? super T>> implements Bag<T> {

	private final static int INITIAL_CAPACITY = 5;

	protected T[] value; // Mantener este array ordenado
	protected int[] count; // Mantener este array con valores positivos
	protected int nextFree;

	public SortedArrayBag() {
		this(INITIAL_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public SortedArrayBag(int n) {
		value = (T[]) new Comparable[n]; // Cada elemento es null
		count = new int[n]; // Cada elemento es 0
		nextFree = 0;
	}

	/**
	 * Asegura que cabe un elemento nuevo
	 */
	private void ensureCapacity() {
		if (nextFree == value.length) {
			value = Arrays.copyOf(value, 2 * value.length);
			count = Arrays.copyOf(count, 2 * count.length);
		}
	}

	/**
	 * Devuelve si el bag esta vacio
	 */
	public boolean isEmpty() {
		return nextFree == 0;
	}

	/**
	 * Localiza la posicion donde esta o deberia estar un elemento. Si "item"
	 * aparece en el array "value", devuelve su indice en otro caso, devuelve el
	 * indice donde "item" deberia estar
	 * 
	 * @param item
	 *            el elemento a localizar
	 * @return indice donde esta o deberia estar "item"
	 */
	private int locate(T item) {
		int lower = 0;
		int upper = nextFree - 1;
		int mid = 0;
		boolean found = false;

		// Busqueda binaria
		while (lower <= upper && !found) {
			mid = lower + ((upper - lower) / 2); // == (lower + upper) / 2;
			found = value[mid].equals(item);
			if (!found) {
				if (value[mid].compareTo(item) > 0) {
					upper = mid - 1;
				} else {
					lower = mid + 1;
				}
			}
		}

		if (found)
			return mid; // El indice donde "item" esta almacenado
		else
			return lower; // el indice donde "item" deberia insertarse
	}

	/**
	 * Inserta un elemento en el bag
	 * Si ya esta, incrementa su contador
	 * en otro caso, lo incluye con contador 1
	 */
	public void insert(T item) {
		int i = locate(item);
		ensureCapacity();
		if (value[i] != null && value[i].equals(item)) {

			count[i]++;

		} else if(isEmpty() || i == nextFree) {

			value[nextFree] = item;
			count[nextFree] = 1;
			nextFree++;
		}else{
			//desplaza los elementos a derecha
			moveToRight(i);
			value[i] = item;
			count[i] = 1;
			nextFree++;

		}

	}
	private void moveToRight(int index) {
		for (int i = 0; i < (nextFree - index); i++) {
			value[nextFree - i] = value[nextFree - i - 1];
			count[nextFree - i] = count[nextFree - i - 1];
		}
	}
	private void moveToLeft(int index) {
		// Move count and value one to the left.
		for (int i = 0; i < (nextFree - index) && (i < value.length - 1); i++) {
			value[index + i] = value[index + i + 1];
			count[index + i] = count[index + i + 1];
		}
	}


	/**
	 * Mueve el array hacia la izquierda sobre la posici�n index (incluida)
	 * @param index �ndice desde el que mover el array.
	 */


	/**
	 * Devuelve las ocurrencias de "item".
	 * Devuelve 0 si no esta
	 */
	public int occurrences(T item) {
		int result = 0;
		int i = locate(item);
		if (value[i] != null && value[i].equals(item)) {

			result = count[i];

		}
		return result;
	}

	/**
	 * Elimina "item" del bag.
	 * Si aparece mas de una vez se decrementa el contador
	 * Si solo apercce una vez se elimina
	 * Si no esa, no se hace nada
	 */
	public void delete(T item) {
		int i = locate(item);
		if(!isEmpty() && value[i].equals(item)){
			if(count[i]>1){
				count[i]--;
			}else if(i == nextFree){
				count[i]=0;
				value[i]=null;
				nextFree--;
			}else{
				moveToLeft(i);
				nextFree--;
			}
			}
		}



	/**
	 * Deuelve una representación textual del bag
	 */
	public String toString() {
		String text = "SortedArrayBag(";
		for (int i = 0; i < nextFree; i++) {
			text += "(" + value[i] + ", " + count[i] + ") ";
		}
		return text + ")";
	}
}
