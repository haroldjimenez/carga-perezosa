package com.techandsolve.cargaperezosa.validaciones;

import org.springframework.beans.factory.annotation.Autowired;

import com.techandsolve.cargaperezosa.utils.AdministadorExcepciones;
import com.techandsolve.cargaperezosa.utils.MensajeErrorEnum;

public class ValidacionDiasTrabajo implements Validacion<Short> {

	@Autowired
	private AdministadorExcepciones adminExcepciones;

	@Override
	public void validar(Short dias) {
		if (dias < 1 || dias > 500) {
			adminExcepciones.lanzarExcepcion(MensajeErrorEnum.ERROR_DIAS_TRABAJO, dias);
		}
	}

}
