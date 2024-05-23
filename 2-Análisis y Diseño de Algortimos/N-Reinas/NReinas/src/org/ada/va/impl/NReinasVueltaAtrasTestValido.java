package org.ada.va.impl;

import static org.junit.Assert.assertTrue;
import java.util.Iterator;
import org.junit.Test;

public class NReinasVueltaAtrasTestValido extends NReinasVueltaAtrasTest {
	
	@Test
	public void testValidoTam5() {
		NReinasVueltaAtras nr = new NReinasVueltaAtras(5);
		Integer[] solucion = nr.getSolucion();
		int n = solucion.length;
		
		for (Iterator<Integer[]> i=valoresValidosTam5.iterator(); i.hasNext(); ) {
			Integer[] valido = i.next();
			for(int k=0; k<n; k++) {
				solucion[k] = valido[k];
			}
			for(int k=0; k<n; k++) {
				assertTrue(nr.valido(k));
			}
			// Una peque�a variacion
			for(int k=0; k<n; k++) {
				solucion[k] = valido[(k+1)%n];
			}
			if (!incluido(solucion,valoresValidosTam5)) {
				assertTrue(!nr.valido(n-1));
			}
		}
	}
	
	@Test
	public void testValidoTam10() {
		NReinasVueltaAtras nr = new NReinasVueltaAtras(10);
		Integer[] solucion = nr.getSolucion();
		int n = solucion.length;
		
		for (Iterator<Integer[]> i=valoresValidosTam10.iterator(); i.hasNext(); ) {
			Integer[] valido = i.next();
			for(int k=0; k<n; k++) {
				solucion[k] = valido[k];
			}
			for(int k=0; k<n; k++) {
				assertTrue(nr.valido(k));
			}
			// Una peque�a variacion
			for(int k=0; k<n; k++) {
				solucion[k] = valido[(k+1)%n];
			}
			if (!incluido(solucion,valoresValidosTam10)) {
				assertTrue(!nr.valido(n-1));
			}
		}
	}

	@Test
	public void testValidoParcial() {
		NReinasVueltaAtras nr = new NReinasVueltaAtras(10);

		nr.setSolucion(new Integer[]{1,8,5,8,4,3,6,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{9,1,6,4,5,5,5,2,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{5,2,8,1,2,8,4,2,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{1,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{7,5,3,6,2,8,3,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{4,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{3,0,9,8,3,6,9,8,6,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{0,4,6,2,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{3,4,0,1,6,9,3,7,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{9,4,4,0,2,7,0,8,8,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{3,6,9,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{3,4,4,5,4,0,5,8,null,null});  
		assertTrue(nr.valido(7));
		 
		nr.setSolucion(new Integer[]{5,3,3,6,1,5,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{1,2,7,2,3,9,0,6,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{5,2,4,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{5,2,5,9,4,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{6,5,1,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{9,9,2,7,5,3,5,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{1,4,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{5,6,7,1,6,1,2,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{9,2,2,6,6,9,5,null,null,null});  
		assertTrue(nr.valido(6));
		 
		nr.setSolucion(new Integer[]{1,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{8,0,6,7,2,6,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{4,2,0,8,6,9,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{0,1,6,9,4,8,6,6,6,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{7,2,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{6,8,7,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{7,8,4,9,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{8,9,null,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(1));
		 
		nr.setSolucion(new Integer[]{4,4,null,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(1));
		 
		nr.setSolucion(new Integer[]{6,1,8,5,1,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{2,0,3,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{8,4,2,8,3,8,4,7,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{2,4,7,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{9,0,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{5,4,2,3,9,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{6,5,1,6,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{0,6,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{0,3,3,1,5,4,9,4,7,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{4,7,2,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{0,1,1,7,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{9,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{4,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{4,2,5,8,6,1,6,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{3,3,7,3,3,0,4,5,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{9,6,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{7,3,7,0,1,2,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{1,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{2,6,9,5,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{5,8,3,0,6,1,4,0,1,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{6,7,2,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{2,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{9,2,7,7,0,4,8,null,null,null});  
		assertTrue(nr.valido(6));
		 
		nr.setSolucion(new Integer[]{4,1,5,3,9,5,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{3,9,4,0,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{2,3,9,7,3,1,0,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{0,5,6,3,0,1,5,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{3,8,2,4,4,4,5,6,2,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{1,6,4,4,7,2,7,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{7,6,8,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{3,6,5,1,5,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{9,9,5,6,2,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{2,8,0,6,0,9,6,9,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{1,9,2,3,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{4,9,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{9,1,6,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{9,2,2,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{0,1,4,9,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{2,5,8,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{2,6,7,7,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{0,1,4,9,8,3,8,0,3,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{4,5,9,0,5,0,9,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{4,2,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{8,4,9,8,9,9,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{6,9,6,5,9,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{0,3,2,0,3,6,5,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{3,5,8,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{8,6,2,5,3,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{0,8,0,5,6,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{7,2,4,9,0,8,7,0,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{1,9,7,1,6,3,8,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{9,0,4,7,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{3,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{3,8,1,5,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{3,4,null,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(1));
		 
		nr.setSolucion(new Integer[]{1,1,4,9,1,7,8,4,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{2,2,5,9,5,8,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{5,4,7,3,8,3,8,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{1,2,0,3,9,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{2,3,4,4,7,4,9,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{4,7,2,7,8,8,8,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{2,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{0,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{9,8,2,7,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{4,3,6,9,4,5,0,4,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{3,9,0,2,2,0,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{7,6,3,4,0,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{6,7,9,2,0,3,1,9,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{3,4,0,5,7,7,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{7,2,0,9,0,5,7,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{5,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{0,0,null,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{2,8,0,6,0,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{2,5,5,9,2,0,1,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{4,2,5,6,2,8,0,8,8,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{1,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{8,2,2,7,9,2,5,1,9,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{0,2,7,5,0,1,4,6,8,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{9,8,1,4,0,3,4,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{0,9,0,0,8,0,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{7,6,4,7,4,7,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{2,0,1,7,3,1,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{9,4,3,1,9,2,3,8,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{2,4,0,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{0,9,0,6,1,6,3,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{0,1,5,5,6,7,2,0,8,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{5,4,6,0,9,7,2,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{6,6,7,8,9,0,null,null,null,null});  
		assertTrue(nr.valido(5));
		 
		nr.setSolucion(new Integer[]{8,8,9,9,9,3,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{2,3,4,6,2,7,7,7,7,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{7,8,8,7,0,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{0,1,4,7,1,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{0,9,7,3,1,9,8,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{0,0,7,0,8,6,5,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{4,8,1,6,0,1,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{1,4,7,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{1,8,7,6,9,4,8,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{0,2,0,7,1,8,1,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{9,4,9,2,0,6,7,0,6,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{0,1,0,0,1,7,9,null,null,null});  
		assertTrue(nr.valido(6));
		 
		nr.setSolucion(new Integer[]{3,6,9,8,2,5,0,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{2,8,4,9,0,9,5,0,5,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{5,6,3,7,8,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{9,5,9,2,0,8,0,7,1,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{4,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{3,1,0,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{3,3,2,0,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{2,3,9,4,8,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{2,8,7,4,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{2,2,0,1,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{4,7,3,2,9,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{7,1,8,5,1,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{9,6,3,6,6,2,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{9,5,0,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{0,4,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{1,2,9,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{7,7,2,1,4,5,5,1,7,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{6,5,0,1,4,8,8,1,2,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{7,2,4,3,7,0,5,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{8,6,9,1,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{1,4,0,9,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{0,0,8,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{6,2,1,2,2,4,0,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{0,6,0,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{8,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{5,5,3,8,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{7,8,7,4,5,7,8,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{5,8,7,3,8,7,0,3,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{7,6,9,5,5,4,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{5,6,null,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(1));
		 
		nr.setSolucion(new Integer[]{6,0,8,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{5,6,9,8,6,6,0,1,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{0,7,3,8,6,8,8,6,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{9,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{9,5,9,1,4,4,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{9,3,2,5,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{3,9,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{6,0,3,2,7,7,5,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{9,8,1,2,2,9,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{5,8,1,4,3,2,2,6,5,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{7,4,6,1,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{5,7,2,2,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{0,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{0,0,5,7,8,0,0,8,8,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{4,5,5,2,7,0,2,1,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{4,7,6,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{8,1,9,4,9,9,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{6,8,4,9,6,2,2,5,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{7,9,2,1,9,9,3,null,null,null});  
		assertTrue(nr.valido(6));
		 
		nr.setSolucion(new Integer[]{3,6,6,6,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{9,9,1,0,5,3,8,null,null,null});  
		assertTrue(nr.valido(6));
		 
		nr.setSolucion(new Integer[]{4,6,7,5,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{5,8,9,4,3,1,null,null,null,null});  
		assertTrue(nr.valido(5));
		 
		nr.setSolucion(new Integer[]{8,5,7,1,8,6,3,7,7,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{9,0,1,4,4,0,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{0,5,1,0,1,1,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{8,8,2,7,4,0,5,null,null,null});  
		assertTrue(nr.valido(6));
		 
		nr.setSolucion(new Integer[]{1,9,0,6,6,9,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{6,7,0,0,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{9,3,6,1,9,1,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{1,2,1,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{9,1,2,3,4,2,5,0,7,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{9,3,9,2,6,4,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{5,1,9,3,6,9,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{9,1,6,4,7,9,3,2,7,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{0,1,null,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(1));
		 
		nr.setSolucion(new Integer[]{7,3,7,0,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{4,2,6,9,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{3,9,4,9,4,2,4,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{9,5,0,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{6,7,3,4,2,6,6,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{4,6,8,4,3,4,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{2,8,7,1,1,9,7,1,2,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{7,8,null,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(1));
		 
		nr.setSolucion(new Integer[]{8,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{9,7,8,1,0,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{2,0,3,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{4,9,5,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{6,2,4,4,4,9,4,5,7,null});  
		assertTrue(nr.valido(8));
		 
		nr.setSolucion(new Integer[]{8,9,1,3,8,7,2,3,9,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{3,3,null,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(1));
		 
		nr.setSolucion(new Integer[]{2,4,2,8,8,1,4,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{1,4,1,6,2,8,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{3,5,8,9,4,5,1,5,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{6,5,6,1,4,0,7,5,7,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{8,3,8,2,3,8,5,3,8,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{8,2,2,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{7,7,8,0,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{5,6,1,8,9,9,2,null,null,null});  
		assertTrue(nr.valido(6));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{0,6,7,2,8,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{0,9,7,0,4,7,3,4,9,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{9,3,2,9,3,6,1,7,9,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{2,5,5,5,6,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{3,5,7,5,1,9,1,1,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{6,6,2,0,7,3,9,5,8,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{9,0,6,9,0,7,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{2,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{5,9,9,7,3,9,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{4,6,3,6,4,3,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{2,8,6,0,5,1,2,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{1,6,4,8,1,7,7,8,7,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{4,0,5,8,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{6,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{7,1,0,7,8,1,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{4,9,9,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{6,9,1,8,1,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{6,8,2,9,7,3,1,0,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{3,9,3,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{2,2,6,9,2,6,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{1,4,8,9,0,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{3,2,7,0,5,7,5,3,3,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{2,5,0,3,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{9,0,9,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{5,1,8,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{5,5,4,7,2,8,9,8,5,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{3,4,1,2,1,9,2,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{2,8,9,5,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{0,5,7,0,1,2,2,1,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{3,1,4,7,3,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{7,9,7,6,1,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{8,8,1,8,9,5,8,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{4,0,5,1,8,3,0,9,4,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{2,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{3,8,4,5,9,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{2,0,6,2,3,6,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{6,0,9,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{3,4,null,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{9,0,2,8,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{4,7,8,8,7,0,3,null,null,null});  
		assertTrue(nr.valido(6));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{8,2,7,2,6,5,3,0,7,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{7,1,9,5,6,1,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{1,9,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{4,9,4,9,5,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{1,0,3,3,9,7,null,null,null,null});  
		assertTrue(nr.valido(5));
		 
		nr.setSolucion(new Integer[]{2,5,4,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{2,8,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{9,7,6,8,4,4,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{2,3,8,1,5,8,9,7,7,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{6,8,2,8,8,6,9,null,null,null});  
		assertTrue(nr.valido(6));
		 
		nr.setSolucion(new Integer[]{7,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{5,9,4,7,3,6,null,null,null,null});  
		assertTrue(nr.valido(5));
		 
		nr.setSolucion(new Integer[]{7,0,1,7,2,5,7,7,8,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{2,3,6,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{8,4,7,0,4,7,5,7,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{9,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{1,1,6,9,2,4,9,5,3,null});  
		assertTrue(nr.valido(8));
		 
		nr.setSolucion(new Integer[]{8,8,4,5,2,3,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{7,9,2,3,8,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{8,7,null,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(1));
		 
		nr.setSolucion(new Integer[]{4,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{3,4,null,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(1));
		 
		nr.setSolucion(new Integer[]{0,8,7,6,1,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{0,5,0,4,3,0,4,7,2,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{3,6,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{6,2,0,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{0,6,5,5,3,9,7,1,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{6,9,7,4,1,9,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{3,5,8,9,9,9,6,1,null,null});  
		assertTrue(nr.valido(7));
		 
		nr.setSolucion(new Integer[]{8,1,6,8,4,7,8,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{4,3,8,3,2,5,6,7,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{2,0,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{2,7,7,6,9,4,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{8,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{9,7,2,6,1,3,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{7,1,3,0,0,8,null,null,null,null});  
		assertTrue(nr.valido(5));
		 
		nr.setSolucion(new Integer[]{4,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{0,8,1,7,2,3,3,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{4,0,6,4,5,0,3,4,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{4,2,2,8,8,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{0,9,4,2,3,5,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{7,9,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{0,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{0,1,7,9,1,4,8,5,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{7,3,1,2,7,2,4,7,8,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{6,6,1,2,4,1,0,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{0,9,3,6,2,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{5,8,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{4,7,2,7,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{5,4,9,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{8,3,6,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{5,5,5,6,1,3,9,0,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{9,9,4,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{8,5,0,8,9,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{9,3,2,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{5,5,7,3,8,1,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{9,4,0,3,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{9,0,0,6,2,5,6,7,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{9,2,8,3,8,6,6,1,7,null});  
		assertTrue(nr.valido(8));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{3,0,2,7,1,1,2,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{3,8,9,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{4,1,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{0,0,4,7,3,4,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{3,5,1,8,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{6,9,2,9,9,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{5,8,1,5,6,6,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{1,9,0,3,9,8,2,1,8,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{5,9,4,3,5,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{9,9,9,5,5,3,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{2,9,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{1,1,9,4,6,9,9,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{6,6,6,4,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{1,9,4,0,6,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{9,2,1,2,7,8,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{0,8,7,2,6,6,7,8,3,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{1,1,9,1,0,7,6,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{2,2,null,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(1));
		 
		nr.setSolucion(new Integer[]{6,1,9,3,9,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{3,0,4,1,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{5,1,0,5,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{1,4,4,1,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{1,5,0,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{1,1,7,1,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{2,0,0,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{9,0,6,4,7,2,2,6,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{3,3,null,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(1));
		 
		nr.setSolucion(new Integer[]{6,7,0,3,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{4,0,1,2,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{4,7,3,3,4,0,3,1,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{4,1,4,4,0,4,3,3,1,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{5,9,1,4,7,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{4,1,1,9,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{4,9,0,4,4,6,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{2,6,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{7,8,0,1,6,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{6,0,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{4,2,7,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{4,1,1,8,5,1,1,2,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{9,9,6,9,0,8,4,0,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{9,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{4,5,2,6,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{8,9,5,8,3,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{8,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{0,0,0,0,9,5,1,null,null,null});  
		assertTrue(nr.valido(6));
		 
		nr.setSolucion(new Integer[]{5,3,1,1,3,4,4,4,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{7,7,3,8,5,7,4,4,8,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{8,5,5,4,3,6,7,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{1,0,4,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{1,8,4,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{8,4,0,5,4,5,9,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{1,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{4,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{6,6,3,2,4,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{1,4,3,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{3,4,4,7,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{6,2,0,6,3,3,6,2,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{2,3,2,0,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{6,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{7,9,3,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{2,1,null,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(1));
		 
		nr.setSolucion(new Integer[]{3,0,3,7,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{4,6,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{2,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{7,2,8,2,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{4,2,3,9,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{7,9,5,1,7,0,6,null,null,null});  
		assertTrue(nr.valido(6));
		 
		nr.setSolucion(new Integer[]{5,0,2,3,9,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{4,5,6,2,2,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{9,4,7,0,9,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{9,0,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{7,9,7,3,6,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{1,2,3,0,9,5,6,1,9,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{0,3,7,3,8,1,2,3,8,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{2,7,9,4,3,9,2,0,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{0,9,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{5,6,2,2,4,2,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{9,6,1,6,3,8,7,4,null,null});  
		assertTrue(nr.valido(7));
		 
		nr.setSolucion(new Integer[]{0,0,6,1,9,4,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{4,2,6,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{1,5,8,4,9,5,1,4,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{9,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{1,7,3,4,2,1,4,6,null,null});  
		assertTrue(nr.valido(7));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{7,6,null,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(1));
		 
		nr.setSolucion(new Integer[]{7,0,1,4,5,0,1,2,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{1,4,0,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{9,0,1,6,7,0,1,7,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{7,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{5,2,4,2,9,9,7,6,9,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{8,9,3,1,8,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{9,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{6,1,9,1,9,9,2,null,null,null});  
		assertTrue(nr.valido(6));
		 
		nr.setSolucion(new Integer[]{1,7,5,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{9,8,1,2,0,9,2,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{4,7,3,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{6,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{8,1,2,8,7,6,1,6,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{9,3,4,4,6,1,4,2,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{4,8,1,2,0,8,2,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{8,9,2,2,9,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{4,3,8,3,2,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{6,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{6,6,1,2,5,0,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{2,9,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{4,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{0,2,6,7,4,7,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{2,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{3,4,null,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(1));
		 
		nr.setSolucion(new Integer[]{6,9,6,4,8,8,6,9,8,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{9,9,4,2,5,0,7,3,5,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{1,5,5,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{6,8,0,3,4,9,null,null,null,null});  
		assertTrue(nr.valido(5));
		 
		nr.setSolucion(new Integer[]{4,9,1,3,4,4,0,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{5,8,9,0,3,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{3,5,4,9,5,0,null,null,null,null});  
		assertTrue(nr.valido(5));
		 
		nr.setSolucion(new Integer[]{4,6,5,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{2,5,9,9,0,3,null,null,null,null});  
		assertTrue(nr.valido(5));
		 
		nr.setSolucion(new Integer[]{9,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{4,7,9,6,2,4,3,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{2,7,6,2,0,4,9,null,null,null});  
		assertTrue(nr.valido(6));
		 
		nr.setSolucion(new Integer[]{0,3,6,7,0,1,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{3,6,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{9,4,2,8,0,4,0,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{8,4,3,5,7,6,4,0,null,null});  
		assertTrue(nr.valido(7));
		 
		nr.setSolucion(new Integer[]{3,4,3,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{1,0,1,6,9,7,1,7,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{9,5,8,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{3,8,3,1,5,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{5,8,2,4,8,7,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{0,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{4,1,3,4,4,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{6,5,6,3,8,4,1,4,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{0,3,6,0,9,4,0,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{7,8,4,5,8,7,7,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{3,5,3,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{2,7,7,1,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{5,8,7,0,1,8,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{7,8,4,1,5,1,6,9,6,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{6,9,6,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{1,6,7,8,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{9,5,2,9,3,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{7,8,8,4,3,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{4,6,4,5,1,7,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{3,1,2,8,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{0,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{9,7,9,4,9,9,2,2,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{4,9,6,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{6,6,8,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{5,7,7,2,8,8,1,4,null,null});  
		assertTrue(nr.valido(7));
		 
		nr.setSolucion(new Integer[]{9,4,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{1,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{2,5,0,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{4,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{8,1,2,0,5,2,8,1,9,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{2,4,7,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{8,2,4,5,1,3,8,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{1,6,4,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{8,2,5,3,1,6,3,6,6,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{8,7,7,2,6,7,8,6,6,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{9,2,5,4,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{5,2,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{8,9,2,0,1,6,2,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{7,3,0,5,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{5,3,7,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{6,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{5,7,2,4,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{7,0,7,5,6,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{7,1,1,9,0,6,4,9,8,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{9,3,0,5,0,8,null,null,null,null});  
		assertTrue(nr.valido(5));
		 
		nr.setSolucion(new Integer[]{2,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{8,9,null,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{9,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{7,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{0,1,5,0,1,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{3,2,7,9,5,6,0,5,6,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{2,2,3,4,1,4,8,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{3,3,5,9,4,0,1,1,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{4,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{9,0,5,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{9,4,0,7,3,5,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{3,8,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{3,2,8,5,4,8,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{8,1,0,8,7,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{2,2,8,9,3,6,4,9,3,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{2,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{5,0,9,2,5,0,1,5,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{6,9,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{8,4,4,2,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{8,3,1,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{4,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{1,3,8,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{7,0,5,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{2,3,8,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{6,9,3,8,7,3,5,1,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{4,1,4,8,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{7,2,1,6,1,0,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{4,0,0,3,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{8,9,2,1,9,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{2,2,4,9,7,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{8,8,8,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{0,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{1,7,8,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{5,8,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{3,2,null,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(1));
		 
		nr.setSolucion(new Integer[]{1,9,8,4,8,1,9,4,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{3,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{9,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{4,8,4,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{8,2,9,8,9,3,1,6,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{9,5,6,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{6,9,7,3,6,7,2,4,7,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{3,6,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{4,4,2,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{4,7,7,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{4,6,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{1,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{8,6,0,6,8,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{4,5,1,0,5,0,2,5,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{2,8,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{9,4,6,6,0,7,null,null,null,null});  
		assertTrue(nr.valido(5));
		 
		nr.setSolucion(new Integer[]{0,3,8,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{3,6,1,0,0,3,8,5,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{7,0,1,9,8,0,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{7,0,6,2,3,8,null,null,null,null});  
		assertTrue(nr.valido(5));
		 
		nr.setSolucion(new Integer[]{6,5,7,5,0,3,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{2,2,3,1,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{1,4,4,3,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{7,0,3,0,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{8,2,1,8,1,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{4,0,5,4,7,8,3,null,null,null});  
		assertTrue(nr.valido(6));
		 
		nr.setSolucion(new Integer[]{0,6,8,2,0,6,1,1,8,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{5,3,2,9,1,4,null,null,null,null});  
		assertTrue(nr.valido(5));
		 
		nr.setSolucion(new Integer[]{5,0,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{6,9,8,2,2,8,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{3,9,1,6,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{3,8,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{1,6,0,7,2,4,null,null,null,null});  
		assertTrue(nr.valido(5));
		 
		nr.setSolucion(new Integer[]{4,4,3,6,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{0,8,7,5,4,3,1,6,null,null});  
		assertTrue(nr.valido(7));
		 
		nr.setSolucion(new Integer[]{5,3,9,2,6,5,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{0,9,2,3,1,0,1,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{0,1,4,7,1,2,8,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{2,5,8,5,7,3,0,5,8,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{9,6,6,9,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{8,1,4,3,9,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{3,0,5,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{6,5,3,2,2,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{8,1,4,4,5,3,3,2,5,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{9,8,9,7,7,7,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{4,7,5,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(2));
		 
		nr.setSolucion(new Integer[]{1,7,3,9,4,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{9,5,0,1,7,5,4,4,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{4,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{2,4,4,8,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{1,6,9,1,2,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{7,0,5,6,0,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{7,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{2,8,8,9,5,6,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{1,7,8,6,5,5,8,5,9,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{5,1,6,8,6,4,9,8,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{5,8,4,1,5,0,3,0,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{0,6,2,4,9,2,5,3,2,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{8,8,1,9,7,9,2,7,5,null});  
		assertTrue(nr.valido(8));
		 
		nr.setSolucion(new Integer[]{7,9,9,5,8,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{5,5,4,3,6,8,5,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{9,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{7,8,null,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(1));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{0,1,9,2,7,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{1,3,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{7,6,8,6,3,8,9,7,6,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{4,6,8,6,2,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{6,9,4,0,5,0,6,1,8,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{9,5,5,5,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{6,4,7,5,0,3,0,8,1,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{0,0,6,1,4,5,3,4,2,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{3,2,6,9,2,0,4,7,null,null});  
		assertTrue(nr.valido(7));
		 
		nr.setSolucion(new Integer[]{6,9,2,7,6,7,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{1,5,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{2,8,4,0,2,0,9,8,0,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{5,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{2,7,3,0,3,8,2,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{0,6,6,1,9,4,0,1,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{4,8,3,3,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{2,4,1,7,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{2,3,5,0,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{1,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{5,3,6,9,4,6,2,0,null,null});  
		assertTrue(nr.valido(7));
		 
		nr.setSolucion(new Integer[]{7,7,4,4,0,0,4,0,5,null});  
		assertTrue(nr.valido(8));
		 
		nr.setSolucion(new Integer[]{0,6,1,7,6,7,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{4,2,0,3,7,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{7,3,2,8,1,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{1,7,5,7,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{3,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{9,0,5,6,1,5,6,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{0,1,6,3,0,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{4,6,2,1,1,7,7,1,7,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{2,6,6,2,2,3,9,4,6,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{4,1,1,5,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{6,2,3,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{0,9,3,8,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{1,1,9,9,2,5,0,5,5,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{1,4,4,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(2));
		 
		nr.setSolucion(new Integer[]{1,1,2,6,2,null,null,null,null,null});  
		assertTrue(!nr.valido(4));
		 
		nr.setSolucion(new Integer[]{2,3,9,0,5,6,4,null,null,null});  
		assertTrue(nr.valido(6));
		 
		nr.setSolucion(new Integer[]{4,5,null,null,null,null,null,null,null,null});  
		assertTrue(!nr.valido(1));
		 
		nr.setSolucion(new Integer[]{5,8,5,7,2,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{0,1,1,5,0,3,6,5,0,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{8,3,6,0,9,6,9,null,null,null});  
		assertTrue(!nr.valido(6));
		 
		nr.setSolucion(new Integer[]{0,6,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{2,4,0,6,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{5,9,1,3,6,8,7,3,2,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{1,2,8,1,6,0,8,4,null,null});  
		assertTrue(nr.valido(7));
		 
		nr.setSolucion(new Integer[]{4,6,7,9,null,null,null,null,null,null});  
		assertTrue(nr.valido(3));
		 
		nr.setSolucion(new Integer[]{7,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(0));
		 
		nr.setSolucion(new Integer[]{4,4,5,6,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 
		nr.setSolucion(new Integer[]{6,3,9,1,4,null,null,null,null,null});  
		assertTrue(nr.valido(4));
		 
		nr.setSolucion(new Integer[]{1,4,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(1));
		 
		nr.setSolucion(new Integer[]{0,3,1,7,3,4,null,null,null,null});  
		assertTrue(!nr.valido(5));
		 
		nr.setSolucion(new Integer[]{null,null,null,null,null,null,null,null,null,null,null});  
		assertTrue(nr.valido(-1));
		 
		nr.setSolucion(new Integer[]{8,1,4,8,6,2,8,4,null,null});  
		assertTrue(!nr.valido(7));
		 
		nr.setSolucion(new Integer[]{7,6,8,6,1,6,9,4,8,null});  
		assertTrue(!nr.valido(8));
		 
		nr.setSolucion(new Integer[]{5,2,8,4,null,null,null,null,null,null});  
		assertTrue(!nr.valido(3));
		 		 
	}

}
