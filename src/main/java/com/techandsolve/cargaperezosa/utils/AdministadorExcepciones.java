package com.techandsolve.cargaperezosa.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.techandsolve.cargaperezosa.excepciones.ExcepcionNegocio;

public class AdministadorExcepciones {
	@Autowired
	private Environment env;

	public void lanzarExcepcion(MensajeErrorEnum msjEnum) {
		throw new ExcepcionNegocio(msjEnum.getCode(),
				obtenerMensajeError(msjEnum));
	}

	public String obtenerMensajeError(MensajeErrorEnum msjEnum) {
		return env.getProperty(msjEnum.getCode());
	}

	public void lanzarExcepcion(MensajeErrorEnum msjEnum, Object... parametros)
			throws RuntimeException {
		throw new ExcepcionNegocio(msjEnum.getCode(), String.format(
				obtenerMensajeError(msjEnum), parametros));
	}
}
