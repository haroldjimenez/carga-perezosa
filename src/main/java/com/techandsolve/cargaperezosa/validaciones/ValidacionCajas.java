package com.techandsolve.cargaperezosa.validaciones;

import com.techandsolve.cargaperezosa.servicios.MensajeErrorEnum;

public class ValidacionCajas extends Validacion<Byte> {

	@Override
	public void validar(Byte cajas) {
		if(cajas<1 || cajas >100){
			lanzarExcepcion(MensajeErrorEnum.ERROR_NUMERO_CAJAS, cajas);
		}		
	}
	

}
