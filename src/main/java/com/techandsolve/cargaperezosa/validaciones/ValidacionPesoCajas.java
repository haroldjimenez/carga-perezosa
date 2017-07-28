package com.techandsolve.cargaperezosa.validaciones;

import org.springframework.beans.factory.annotation.Autowired;

import com.techandsolve.cargaperezosa.utils.AdministadorExcepciones;
import com.techandsolve.cargaperezosa.utils.MensajeErrorEnum;

public class ValidacionPesoCajas implements Validacion<Byte> {

	
	@Autowired
	private AdministadorExcepciones adminExcepciones;
	@Override
	public void validar(Byte cajas) {
		if(cajas<1 || cajas >100){
			adminExcepciones.lanzarExcepcion(MensajeErrorEnum.ERROR_NUMERO_CAJAS, cajas);
		}		
	}

}
