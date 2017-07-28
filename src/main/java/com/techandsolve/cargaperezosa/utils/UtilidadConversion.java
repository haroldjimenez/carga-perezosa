package com.techandsolve.cargaperezosa.utils;


public class UtilidadConversion {
	public byte[] generarArchivoRespuesta(Integer[] arrayCajas){
		StringBuilder respuesta = new StringBuilder();
		for (int i = 0; i < arrayCajas.length; i++) {
			contruirRespuesta(arrayCajas[i], i+1, respuesta);
		}
		return respuesta.toString().getBytes();
	}

	private void contruirRespuesta(int viajes,int dia, StringBuilder respuesta) {
		respuesta.append("Case #").append(dia).append(": ").append(viajes).append("\n");
	}
}
