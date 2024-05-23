/* TAREA VOLUNTARIA Nº1 (DyV)
 * ENUNCIADO: Calcular la mediana de dos vectores de tamaño n en tiempo O(logn)
 * HECHO POR: Sergio Camacho Marín y Juan Antonio Domínguez Arcas
 * GRADO, CURSO: Ingeniería Informática, 2ºC
 */

import java.lang.Math;

public class Mediana {
	
	public static int MedianaRec(int[] x, int infx, int supx, int[] y, int infy, int supy) {
		
		int nelem = supx - infx + 1, mediox, medioy;
		
		//CASO BASE: 2 Vectores de 1 elemento cada uno. Me quedo con el minimo de los 2
		if((infx >= supx) && (infy >= supy)){	
			
			return Math.min(x[supx], y[supy]);
		}
		
		//CASO BASE: 2 vectores de 2 elementos cada uno
		if(nelem == 2) {
			
			if(x[supx] < y[infy]) {
				
				/*Si tengo, por ejemplo, [2,3] y [4,5], la mediana puede ser ó 3 ó 4.
				 * Decido quedarme con el mas pequeño */
				
				return x[supx];
				
			}else if(y[supy] < x[infx]) {
				
				/*Si tengo, por ejemplo, [8,9] y [3,5], la mediana puede ser ó 5 ó 8.
				 * Hago la misma decisión de antes*/
				
				return y[supy];
				
			}else {
				/*En otro caso, el maximo de los inferiores. Por ejemplo, si tengo
				 * [5,6] y [4,6] no se cumple ninguna de las condiciones anteriores,
				 * entonces la mediana sera el maximo entre 4 y 5, que sera 5 en este
				 * caso concreto*/
				
				return Math.max(x[infx], y[infy]);
			}
		}
		
		//CASO GENERAL
		
		//Calculo la posicion media de los vectores x e y
		nelem = (nelem - 1)/2;
		mediox = infx + nelem;
		medioy = infy + nelem;
		
		if(x[mediox] == y[medioy]) {
			
			//Si el elemento de la posicion media coincide, la mediana es esa
			
			return x[mediox];
			
		}else if(x[mediox] < y[medioy]) {
			
			/*Si el elemento de x es mas pequeño, llamo a la funcion recursivamente con la mitad 
			 * superior del vector x y la mitad inferior del vector y*/
			
			return MedianaRec(x, supx - nelem, supx, y, infy, medioy);
			
		}else {
			/*En caso contrario, hago lo mismo descrito arriba, la mitad inferior del vector x y la
			 * mitad superior del vector y*/
			
			return MedianaRec(x, infx, mediox, y, supy - nelem, supy);
		}
	}
	
	public static void main(String[] args) {
		
		int[] x = {2, 3, 4, 5, 7};
		int[] y = {1, 1, 5, 6, 7};
		
		int res = MedianaRec(x, 0, x.length - 1, y, 0, y.length - 1);
		
		System.out.println("La mediana de los 2n elementos es: " + res);
	}
}
