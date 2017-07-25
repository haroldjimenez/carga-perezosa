package com.techandsolve.cargaperezosa.controladores.rest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techandsolve.cargaperezosa.entidades.Ejecuciones;
import com.techandsolve.cargaperezosa.repositorios.EjecucionesLog;

@RestController
@RequestMapping(value = "/procesar-archivo")
public class ProcesarArchivo {
	
	@Autowired
	private EjecucionesLog ejecuciones;
	
	@RequestMapping(value = "/procesar",method=RequestMethod.GET)
	public String procesarArchivo(){
		Ejecuciones ejecucion= new Ejecuciones();
		ejecucion.setFechaEjecucion(new Date());
		ejecucion.setDocumentoIdentidad("2134567890");
		ejecuciones.save(ejecucion);
		return "Hola mundo";
	}

}
