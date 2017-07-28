package com.techandsolve.cargaperezosa.validaciones;

import com.techandsolve.cargaperezosa.servicios.MensajeErrorEnum;

public class ValidacionDiasTrabajo extends Validacion<Short> {

	@Override
	public void validar(Short dias) {
		if(dias<1 || dias >500){
			lanzarExcepcion(MensajeErrorEnum.ERROR_DIAS_TRABAJO, dias);
		}		
	}

}
