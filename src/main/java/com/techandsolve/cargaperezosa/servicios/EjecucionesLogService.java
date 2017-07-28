package com.techandsolve.cargaperezosa.servicios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.techandsolve.cargaperezosa.entidades.Ejecuciones;
import com.techandsolve.cargaperezosa.repositorios.EjecucionesLog;
import com.techandsolve.cargaperezosa.utils.AdministadorExcepciones;
import com.techandsolve.cargaperezosa.utils.MensajeErrorEnum;

@Service
public class EjecucionesLogService {
	
	@Autowired
	private EjecucionesLog ejecuciones;
	
	@Autowired
	private AdministadorExcepciones excepcion;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void logear(String documento) {
		if(documento == null || documento.isEmpty())
			excepcion.lanzarExcepcion(MensajeErrorEnum.ERROR_DOCUMENTO_INVALIDO);
		Ejecuciones ejecucion = new Ejecuciones();
		ejecucion.setFechaEjecucion(new Date());
		ejecucion.setDocumentoIdentidad(documento);
		ejecuciones.save(ejecucion);
	}

}
