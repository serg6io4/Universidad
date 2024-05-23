/* -------------------------------------------------------------------------------
   -- Estructura de Datos. Grado en Informática/ Software / Computadores. UMA.
   -- Práctica evaluable 2023-2024
   -- Puntuación máxima: 1.5 puntos
   -------------------------------------------------------------------------------
*/

package dataStructures.searchTree;

import com.sun.source.tree.Tree;
import dataStructures.list.*;
import dataStructures.tuple.Tuple2;

import java.util.Iterator;


/**
 * SimpleSplayTree es un arbol binario de busqueda no-balanceado.
 * Las claves (key) definen una relacion de orden ({@link Comparable}).
 *
 * @param <K> Tipo de las claves (key).
 * @param <V> Tipo de los valores (value).
 */
public class SimpleSplayTree<K extends Comparable<? super K>, V> implements Iterable<Tuple2<K, V>> {
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;

        public Node(K k, V v) {
            key = k;
            value = v;
            left = null;
            right = null;
        }

    }

    private Node<K, V> root;
    private int size;

    /**
     * (0,05 puntos)
     * Crea un SimpleSplayTree vacio.
     */
    public SimpleSplayTree() {
        //Para crear un arbol vacio, tanto los valores clave valor son vacios
        //además de sus hijos
        root =  new Node<K,V>(null, null);
    }

    /**
     * (0,05 puntos)
     * Determina si el arbol esta vacio
     * @return true si el arbol está vacio
     */
    public boolean isEmpty() {
        //si es nulo está vacio
        return root == null;
    }

    /**
     * (0,05 puntos)
     *
     * @return numero de elementos almacenados en el arbol
     */
    public int size() {
        //devuelvo el tamaño de la clase
        return this.size;
    }


    /**
     * (0,25 puntos)
     * Rota un nodo a la izquierda. El nodo derecho pasa a ser la raiz
     * Solo se aplica si el nodo y su hijo derecho no son nulos.
     * En otro caso no modifica el nodo
     *
     * @param node el nodo a rotar
     * @param <K>
     * @param <V>
     * @return el nuevo nodo raiz
     */
    private static <K extends Comparable<? super K>, V> Node<K, V> rotateLeft(Node<K, V> node) {
        //Si el nodo y su hijo derecho no son nulos
        if(node != null && node.right != null){
            Node<K,V> rt = node.right;
            Node<K,V> rlt = rt.left;
            node.right = rlt;
            rt.left = node;

        }
        //En caso contrario, devuelvo el mismo
        return node;
    }

    /**
     * (0,25 puntos)
     * Rota un nodo a la derecha. El nodo izquierdo pasa a ser la raiz
     * Solo se aplica si el nodo y su rama izquierda no son nulas.
     * En otro caso no modifica el nodo
     *
     * @param node el nodo a rotar
     * @param <K>
     * @param <V>
     * @return el nuevo nodo raiz
     */
    private static <K extends Comparable<? super K>, V> Node<K, V> rotateRight(Node<K, V> node) {
        //En caso de que no sean nulos ni el nodo, ni su hijo izquierdo, procedo
        if(node!=null && node.left!=null){
            Node<K,V> lt = node.left;
            Node<K,V> lrt = lt.right;
            node.left = lrt;
            lt.right=node;
        }
        //devuelvo lo mismo en caso contrario
        return node;
    }

    /**
     * (0,25 puntos)
     * Inserta el par (k,v) en el arbol si la clave no esta previamente.
     * En otro caso, actualiza el valor asociado a la clave k.
     * Tras la insercion/actualizacion el nodo con clave k y valor v
     * se convierte en la raiz del arbol.
     *
     * @param k la clave a insertar
     * @param v el valor asociado a la clave
     */
    public void insert(K k, V v) {
        root = insertRec(root, k, v);
    }
    private Node<K,V> insertRec(Node<K,V> root, K k, V v) {
        //Si no hay nada me creo un SimpleSplayTree
        if(root == null){
            root = new Node<K,V>(k,v);
            //Si es igual a la raiz, cambio el valor
        }else if(k.compareTo(root.key) == 0){
            root.value = v;
            //Si es menor, me voy por la izquierda
        }else if(k.compareTo(root.key)<0){
            //Si inserto por la izquierda roto hacia la derecha
            root.left = rotateRight(insertRec(root.left, k, v));
        }else{//Voy hacia la derecha roto por la izquierda
            root.right = rotateLeft(insertRec(root.right, k, v));
        }
        return root;
    }

    /**
     * (0,25 puntos)
     * Busca la clave k en el arbol.
     * Si está, devuelve el valor <V> asociado a k
     * y el arbol resultante tiene en la raiz el nodo con clave k.
     * En otro caso, devuelve null y arbol resultante tiene en la raíz
     * el último nodo que se ha visitado durante la busqueda.
     *
     * @param k la clave a buscar
     * @return el valor asociado a k o null si k no esta en el arbol
     */
    public V search(K k) {
        //Aquí me llegará el arbol con el primer elemento que he buscado
        Node<K,V> nodo = auxSearch(root, k);
        //devuelvo el valor
    	return nodo.value;
    }
    private Node<K,V> auxSearch(Node<K,V> root, K k){
        if(root==null){
            //En caso de no encontrarlo devuelvo nulo
            return null;
        }else if(root.key.compareTo(k)==0){
            //Si lo encuentro lo dejo como está
            return root;
        }else if(root.key.compareTo(k)<0){
            //Si me voy por la izquierda tengo que rotar el arbol hacia la derecha
            //para que el nodo este en arriba
            return rotateRight(auxSearch(root.left, k));
        }else{
            //Si me voy para la derecha tengo que rotar el arbol hacia la derecha
            //para mantener el nodo arriba
            return rotateLeft(auxSearch(root.right, k));
        }

    }

    /**
     * (0,1 puntos)
     * Determina si la clave k esta en el arbol.
     * El arbol resultante se modifica con la misma estrategia que
     * en el metodo search.
     *
     * @param k la clave a buscar
     * @return true si k esta en el arbol
     */
    public boolean isElem(K k) {
        //Tengo que buscar y llevar el nodo arriba del todo
        //y luego simplemente buscar si su clave es igual
        Node<K,V> nodo = auxSearch(root, k);
        return nodo.key.compareTo(k)==0;
    }

    /**
     * (0,25 puntos)
     * Recorre in-orden el arbol y devuelve el resultado en una lista.
     * El arbol no se modifica al recorrerlo.
     *
     * @param node la raiz del arbol a recorrer en in-orden.
     * @return lista de tuplas de pares (k,v)
     */
    public static <K, V> List<Tuple2<K, V>> inOrderRec(Node<K, V> node) {
        //El funcionamiento es el siguiente, como inOrder es Izquierda-Raiz-Centro
        //Voy a ir llamando recursivamente a la izquierda hasta que no tenga nodo
        //Una vez hecho eso, imprimirá el primero por la izquierda, luego la raiz y luego la derecha
        List<Tuple2<K,V>> lista = new ArrayList<>();
        if(node.left!=null){
            inOrderRec(node.left);
        }
        lista.append(new Tuple2<K,V>(node.key, node.value));
        if(node.right!= null){
            inOrderRec(node.right);
        }
        return lista;
    }

	/***** NO MODIFICAR *****/
	public List<Tuple2<K, V>> inOrder() {
        return inOrderRec(root);
    }
    
    public Iterator<Tuple2<K, V>> iterator() {
        return inOrder().iterator();
    }

    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        return className + "(" + toStringRec(this.root) + ")";
    }

    private static String toStringRec(Node<?, ?> tree) {
        return tree == null ? "null" : "Node<" + toStringRec(tree.left) + ","
                + tree.key + "," + tree.value + "," + toStringRec(tree.right) + ">";
    }

}

