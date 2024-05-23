/* -------------------------------------------------------------------------------
   -- Estructura de Datos. Grado en Informática/ Software / Computadores. UMA.
   -- Práctica evaluable 2023-2024
   -- Puntuación máxima: 1.5 puntos
   -------------------------------------------------------------------------------
*/

package dataStructures.searchTree;

import dataStructures.list.*;
import dataStructures.tuple.Tuple2;
import org.w3c.dom.Node;

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
        root = null;
        size = 0;
    }

    /**
     * (0,05 puntos)
     * Determina si el arbol esta vacio
     * @return true si el arbol está vacio
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * (0,05 puntos)
     *
     * @return numero de elementos almacenados en el arbol
     */
    public int size() {
        return size;
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
            return rt;
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
            return lt;
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
        //Si me pasa un valor nulo no hago nada
        if(k != null){
           root = insertRec(root, k, v);
           size++;
        }
    }
    private Node<K,V> insertRec(Node<K,V> nodo, K k, V v){
        if(nodo == null){
            return new Node<K,V>(k, v);
        }
        int comp = k.compareTo(nodo.key);
        if(comp<0){
            nodo.left = insertRec(nodo.left, k, v);
        }else if(comp>0){
            nodo.right = insertRec(nodo.right, k, v);
        }else{
            nodo.value = v;
        }
        return splay(nodo, k);
    }

    private Node<K,V> splay(Node<K,V> nodo, K k) {
        if(nodo == null || nodo.key.equals(k)){
            return nodo;
        }
        int comp = k.compareTo(nodo.key);
        if(comp<0){
            //subarbol izquierdo
            if(nodo.left==null){
                return nodo;
            }

            if(k.compareTo(nodo.left.key)<0){
                nodo.left.left = splay(nodo.left.left, k);
                nodo = rotateRight(nodo);
            }else if(k.compareTo(nodo.left.key)>0){
                nodo.left.right = splay(nodo.left.right, k);
                if(nodo.left.right !=null){
                    nodo.left = rotateLeft(nodo.left);
                }
            }
            return (nodo.left == null) ? nodo : rotateRight(nodo);
        }else{
            if(nodo.right == null){
                return nodo;
            }
            if(k.compareTo(nodo.right.key)<0){
                nodo.right.left = splay(nodo.right.left, k);
                if(nodo.right.left != null){
                    nodo.right = rotateRight(nodo.right);
                }
            }else if(k.compareTo(nodo.right.key)>0){
                nodo.right.right = splay(nodo.right.right, k);
                nodo = rotateLeft(nodo);
            }
            return (nodo.right == null) ? nodo : rotateLeft(nodo);
        }
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
        if(k==null){
            return null;
        }
        root = searchRec(root, k);
        if(root!=null && root.key.equals(k)){
            return root.value;
        }
    	return null;
    }

    private Node<K, V> searchRec(Node<K, V> nodo, K k) {
        if (nodo == null) {
            return null;
        }

        int comp = k.compareTo(nodo.key);
        if (comp < 0) {
            if (nodo.left == null) {
                // La clave no está presente, devolvemos el nodo actual y hacemos splay
                return splay(nodo, k);
            }
            int compLeft = k.compareTo(nodo.left.key);
            if (compLeft < 0) {
                nodo.left.left = searchRec(nodo.left.left, k);
                nodo = rotateRight(nodo);
            } else if (compLeft > 0) {
                nodo.left.right = searchRec(nodo.left.right, k);
                nodo.left = rotateLeft(nodo.left);
            }

            return (nodo.left == null) ? nodo : rotateRight(nodo);
        } else if (comp > 0) {
            if (nodo.right == null) {
                // La clave no está presente, devolvemos el nodo actual y hacemos splay
                return splay(nodo, k);
            }
            int compRight = k.compareTo(nodo.right.key);
            if (compRight < 0) {
                nodo.right.left = searchRec(nodo.right.left, k);
                nodo.right = rotateRight(nodo.right);
            } else if (compRight > 0) {
                nodo.right.right = searchRec(nodo.right.right, k);
                nodo = rotateLeft(nodo);
            }

            return (nodo.right == null) ? nodo : rotateLeft(nodo);
        } else {
            // La clave ya está en la raíz, hacemos splay en el nodo objetivo
            return splay(nodo, k);
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
        if(k == null){
            return false;
        }
        root = searchRec(root, k);
        return root!=null && root.key.equals(k);
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
        List<Tuple2<K,V>> result = new ArrayList<>();
        enOrden(node, result);
        return result;
    }

    private static <K,V> void enOrden(Node<K,V> node, List<Tuple2<K,V>> result) {
        if(node!=null){
            enOrden(node.left, result);
            result.append(new Tuple2<>(node.key, node.value));
            enOrden(node.right, result);
        }
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

