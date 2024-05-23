/********************************************************************
 * Estructuras de Datos. 2º Curso. ETSI Informática. UMA
 * PRACTICA 4ª. Ejercicio 12.b de la tercera relación
 *              Implementar el TAD Bolsa en java
 *
 * (completa y sustituye los siguientes datos)
 * Titulación: Grado en Ingeniería [Informática | del Software | de Computadores].
 * Alumno: APELLIDOS, NOMBRE
 * Fecha de entrega:  DIA | MES | AÑO
 ********************************************************************
 */

package dataStructures.bag;

import java.util.NoSuchElementException;

public class SortedLinkedBag<T extends Comparable<? super T>> implements Bag<T> {

	static private class Node<E> {
		E elem;
		int count;
		Node<E> next;

		Node(E x, int n, Node<E> node) {
			elem = x;
			count = n;
			next = node;
		}
	}

	private Node<T> first; // Mantener esta lista enlazada ordenada por "elem"

	public SortedLinkedBag() {
		first = null;
	}

	/**
	 * Devuelve si el bag esta vacio
	 */
	public boolean isEmpty() {

		return first==null;
	}

	/**
	 * Inserta un elemento en el bag
	 * Si ya esta, incrementa su contador
	 * en otro caso, lo incluye con contador 1
	 */
	public void insert(T item) {
		Node<T> previous = null;
		Node<T> current = first;

		while (current != null && current.elem.compareTo(item) < 0) {
			previous = current;
			current = current.next;
		}

		if(isEmpty()){
			current = new Node<>(item, 1, null);
		}else if(current != null && current.elem.equals(item)){
			current.count++;
		}else if (previous == null) {
			first = new Node<T>(item, 1, current);
		} else {
			previous.next = new Node<>(item, 1, null);
		}
	}

	/**
	 * Devuelve las ocurrencias de "item".
	 * Devuelve 0 si no esta
	 */
	public int occurrences(T item) {
		Node<T> current = first;
		int result = 0;

		while (current != null && current.elem.compareTo(item) < 0) {
			current = current.next;
		}

		if (current != null && current.elem.equals(item)) {

			result = current.count ;

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
		Node<T> previous = null;
		Node<T> current = first;

		while(current!=null && current.elem.compareTo(item)<0){
			previous = current;
			current = current.next;
		}
		boolean encontrado = (current!=null) && (current.elem.equals(item));
		if(!encontrado){
			//throw new NoSuchElementException("No existe ese elemento en bolsa");
		} else{
			if(current.count>1){
				current.count--;
			}else{
				if(previous == null){
					first = current.next;
				}else{
					previous.next = current.next;
				}

			}
		}

	}

	/**
	 * Deuelve una representación textual del bag
	 */
	public String toString() {
		String text = "SortedLinkedBag(";
		for (Node<T> p = first; p != null; p = p.next) {
			text += "(" + p.elem + ", " + p.count + ") ";
		}
		return text + ")";
	}
}
