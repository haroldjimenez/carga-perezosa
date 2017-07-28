package com.techandsolve.cargaperezosa.validaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.techandsolve.cargaperezosa.excepciones.ExcepcionNegocio;
import com.techandsolve.cargaperezosa.servicios.MensajeErrorEnum;

public abstract class  Validacion<T> {
	
	@Autowired
	private Environment env;
	
	abstract void validar(T object);
	
	public void lanzarExcepcion(MensajeErrorEnum msjEnum) {
		throw new ExcepcionNegocio(msjEnum.getCode(),
				obtenerMensajeError(msjEnum));
	}

	public String obtenerMensajeError(MensajeErrorEnum msjEnum) {
		return env.getProperty(msjEnum.getCode());
	}

	public void lanzarExcepcion(MensajeErrorEnum msjEnum, Object... parametros) throws RuntimeException{
		throw new ExcepcionNegocio(msjEnum.getCode(), String.format(
				obtenerMensajeError(msjEnum), parametros));
	}
}
