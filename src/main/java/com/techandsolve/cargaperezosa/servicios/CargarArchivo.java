package com.techandsolve.cargaperezosa.servicios;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.log4j.Logger;

public class CargarArchivo {
	
	private static final Logger LOG = Logger.getLogger(CargarArchivo.class);
	
	public static void cargarArchivo(String rutaArchivo) throws IOException{
		LineIterator it = FileUtils.lineIterator(new File("D:\\prueba_tecnica\\LazyLoading\\lazy_loading_2.txt"), "UTF-8");
		
		try {
			
			byte numeroCajas = 0;
			int [] dias = null;
			List<Byte> cajas = new LinkedList<Byte>();
			if(it.hasNext() && dias == null ){
	        	dias = new int[Short.valueOf(it.nextLine())];
	        	numeroCajas = Byte.valueOf(it.nextLine());
	        	
	        } 
		    while (it.hasNext()) {
		        String line = it.nextLine();
		         if(numeroCajas == 0){
		        	Collections.sort(cajas);
		        	numeroCajas = Byte.valueOf(line);
		        	cajas = new LinkedList<Byte>();
		        } else {
		        	cajas.add( Byte.valueOf(line));
		        	numeroCajas--;
		        }
		        
		    }
		} catch (NumberFormatException e) {
			LOG.error("Error carga archivo, alguna de las lineas contenia caracteres diferentes a números");
			throw e;
		}finally {
		    LineIterator.closeQuietly(it);
		}
	}
	
	public static void cargarArchivo2(String rutaArchivo) throws IOException{
		LineIterator it = FileUtils.lineIterator(new File("D:\\prueba_tecnica\\LazyLoading\\lazy_loading_1.txt"), "UTF-8");
		
		try {
			
			byte numeroCajas = 0;
			int [] dias = null;
			Byte[] cajas = null;
			if(it.hasNext() && dias == null ){
	        	dias = new int[Short.valueOf(it.nextLine())];
	        	numeroCajas = Byte.valueOf(it.nextLine());
	        	cajas = new Byte [numeroCajas];
	        } 
		    while (it.hasNext()) {
		        String line = it.nextLine();
		         if(numeroCajas == 0){
		        	Arrays.sort(cajas);
		        	
		        	System.out.println("calculo::"+calcularMaximoNumeroViajes( Arrays.stream(cajas).collect(Collectors.toList())));
		        	numeroCajas = Byte.valueOf(line);
		        	cajas = new Byte[numeroCajas];
		        } else {
		        	cajas[numeroCajas-1]= Byte.valueOf(line);
		        	numeroCajas--;
		        }
		        
		    }
		    Arrays.sort(cajas);
		    System.out.println("calculo::"+calcularMaximoNumeroViajes( Arrays.stream(cajas).collect(Collectors.toList())));
		} catch (NumberFormatException e) {
			LOG.error("Error carga archivo, alguna de las lineas contenia caracteres diferentes a números");
			throw e;
		}finally {
		    LineIterator.closeQuietly(it);
		}
		
		
	}
	public static int calcularMaximoNumeroViajes(List<Byte> cajas){
		int viajes = 0;
		int numeroCaja=0;
		int pesoUltimaCaja=0;
		for (int i = cajas.size()-1; i > -1; i--) {
			if(pesoUltimaCaja==0){
				pesoUltimaCaja=cajas.get(i);
				numeroCaja++;
				cajas.remove(i);
			} else {
				numeroCaja++;
				cajas.remove(0);
			}
			if(pesoUltimaCaja*numeroCaja>=50){
				viajes++;
				pesoUltimaCaja = 0;
				numeroCaja = 0;
			} 
		}
		return viajes;
	}
	
	public static void main(String[] args) throws IOException {
		int conunt1=0;
		int conunt=0;
//		for (int i = 0; i < 100; i++) {
		long fechainicial = System.nanoTime();
		CargarArchivo.cargarArchivo2(null);
		long fechafin = System.nanoTime();
		conunt +=((fechafin-fechainicial));
//		}
		/**for (int i = 0; i < 100; i++) {
			long fechainicial = System.nanoTime();
			CargarArchivo.cargarArchivo2(null);
			long fechafin = System.nanoTime();
			conunt1 +=((fechafin-fechainicial));
			}*/
		
		
		
		
		System.out.println(conunt);
//		System.out.println(conunt1/100);
		
		
		
	}

}
