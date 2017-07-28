package com.techandsolve.cargaperezosa.controladores.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techandsolve.cargaperezosa.entidades.Ejecuciones;
import com.techandsolve.cargaperezosa.servicios.EjecucionesLogService;

@RestController
@RequestMapping(value = "/")
public class EjecucionesWeb {
	@Autowired
	private EjecucionesLogService ejecuciones;
	
	@RequestMapping(value = "/consultar",method=RequestMethod.GET)
	public List<Ejecuciones> procesarArchivo2(){
		
		return ejecuciones.consultar();
	}
}
